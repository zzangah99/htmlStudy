package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.Electronics;
import kosta.mvc.service.ElectronicsService;
import kosta.mvc.service.ElectronicsServiceImpl;

public class ElectronicsController implements Controller {
	private ElectronicsService elecService = new ElectronicsServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * ��ü�˻�
	 */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null || pageNo.equals("")) {
			pageNo = "1";
		}
		
		//List<Electronics> list = elecService.select();
		List<Electronics> list = elecService.select(Integer.parseInt(pageNo));
		request.setAttribute("list", list); //�信�� ${list}
		request.setAttribute("pageNo", pageNo);
		
		return new ModelAndView("elec/list.jsp");
	}
	
	
	/**
	 * ����ϱ�
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//������ enctype="multipart/form-data" �����Ǿ� �ֱ� ������ request �ƴ� MultipartRequest�� ó���Ѵ� - cos.jar
		String saveDir = request.getServletContext().getRealPath("/save");
		int maxSize= 1024*1024*100;//100M
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		//���۵� ������ �ޱ�
		String modelNum = m.getParameter("model_num");
		String modelName = m.getParameter("model_name");
		String price = m.getParameter("price");
		String description = m.getParameter("description");
		String password = m.getParameter("password");
		
		Electronics elec = new Electronics(modelNum, modelName, Integer.parseInt(price), description, password);
		
		//���� ����÷�ΰ� �Ǿ��ٸ�
		if(m.getFilesystemName("file") != null) {
			//���� �̸� ����
			elec.setFname(m.getFilesystemName("file"));
			//���� ũ�� ����
			long size = m.getFile("file").length();
			elec.setFsize((int)size);
			
		}
		
		elecService.insert(elec);
		
		return new ModelAndView("front", true); //key=elec&methodName=select �⺻���� �����ȴ�
	}
	
	
	/**
	 * �󼼺���
	 */
	public ModelAndView selectByModelNum(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String modelNum = request.getParameter("modelNum");
		boolean state = request.getParameter("flag")==null? true : false;//�����Ϸ� �� ������ ��쿡�� ��ȸ�� ���� ����
		String pageNo = request.getParameter("pageNo");
		
		//�� ��° �μ� boolean�� ��ȸ�� ���� ���θ� �Ǵ��� �μ�(true�̸� ����, false�̸� ���� �� ��)
		Electronics electronics = elecService.selectByModelnum(modelNum, state);
		request.setAttribute("elec", electronics);
		request.setAttribute("pageNo", pageNo);
		
		return new ModelAndView("elec/read.jsp"); //forward
	}
	
	
	/**
	 * ������
	 */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String modelNum = request.getParameter("modelNum");
		String pageNo = request.getParameter("pageNo");
		Electronics elec = elecService.selectByModelnum(modelNum, false);
		
		request.setAttribute("elec", elec);
		request.setAttribute("pageNo", pageNo);
		
		return new ModelAndView("elec/update.jsp"); //forward
	}
	
	
	/**
	 * ����
	 */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String modelNum = request.getParameter("modelNum");
		String password = request.getParameter("password");
		
		//÷�ε� ������ �����ϴ� ����� ���������� ������ �����Ѵ� - service����
		String saveDir = request.getServletContext().getRealPath("/save");
		elecService.delete(modelNum, password, saveDir);
		
		return new ModelAndView("front", true);
	}
	
	
	/**
	 * ���� �Ϸ�
	 */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String modelNum = request.getParameter("modelNum");
		String modelName = request.getParameter("modelName");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String password = request.getParameter("password");
		String pageNo = request.getParameter("pageNo");
		
		elecService.update(new Electronics(modelNum, modelName, Integer.parseInt(price), description, password));
		
		//���� �Ϸ� ��
		/* ��� 1
		Electronics dbElec = elecService.selectByModelnum(modelNum, false);
		request.setAttribute("dbElec", dbElec);
		ModelAndView mv = new ModelAndView("elec/read.jsp"); */
		
		//��� 2
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=elec&methodName=selectByModelNum&modelNum="+modelNum+"&flag=false&pageNo="+pageNo);
		mv.setRedirect(true);
		
		return mv;
	}
}
