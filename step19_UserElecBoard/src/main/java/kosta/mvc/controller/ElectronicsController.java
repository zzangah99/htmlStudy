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
	 * 전체검색
	 */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null || pageNo.equals("")) {
			pageNo = "1";
		}
		
		//List<Electronics> list = elecService.select();
		List<Electronics> list = elecService.select(Integer.parseInt(pageNo));
		request.setAttribute("list", list); //뷰에서 ${list}
		request.setAttribute("pageNo", pageNo);
		
		return new ModelAndView("elec/list.jsp");
	}
	
	
	/**
	 * 등록하기
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//폼에서 enctype="multipart/form-data" 설정되어 있기 때문에 request 아닌 MultipartRequest로 처리한다 - cos.jar
		String saveDir = request.getServletContext().getRealPath("/save");
		int maxSize= 1024*1024*100;//100M
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		//전송된 데이터 받기
		String modelNum = m.getParameter("model_num");
		String modelName = m.getParameter("model_name");
		String price = m.getParameter("price");
		String description = m.getParameter("description");
		String password = m.getParameter("password");
		
		Electronics elec = new Electronics(modelNum, modelName, Integer.parseInt(price), description, password);
		
		//만약 파일첨부가 되었다면
		if(m.getFilesystemName("file") != null) {
			//파일 이름 저장
			elec.setFname(m.getFilesystemName("file"));
			//파일 크기 저장
			long size = m.getFile("file").length();
			elec.setFsize((int)size);
			
		}
		
		elecService.insert(elec);
		
		return new ModelAndView("front", true); //key=elec&methodName=select 기본으로 설정된다
	}
	
	
	/**
	 * 상세보기
	 */
	public ModelAndView selectByModelNum(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String modelNum = request.getParameter("modelNum");
		boolean state = request.getParameter("flag")==null? true : false;//수정완료 후 들어오는 경우에는 조회수 증가 방지
		String pageNo = request.getParameter("pageNo");
		
		//두 번째 인수 boolean은 조회수 증가 여부를 판단할 인수(true이면 증가, false이면 증가 안 함)
		Electronics electronics = elecService.selectByModelnum(modelNum, state);
		request.setAttribute("elec", electronics);
		request.setAttribute("pageNo", pageNo);
		
		return new ModelAndView("elec/read.jsp"); //forward
	}
	
	
	/**
	 * 수정폼
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
	 * 삭제
	 */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String modelNum = request.getParameter("modelNum");
		String password = request.getParameter("password");
		
		//첨부된 파일을 삭제하는 경우라면 폴더에서도 파일을 삭제한다 - service에서
		String saveDir = request.getServletContext().getRealPath("/save");
		elecService.delete(modelNum, password, saveDir);
		
		return new ModelAndView("front", true);
	}
	
	
	/**
	 * 수정 완료
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
		
		//수정 완료 후
		/* 방법 1
		Electronics dbElec = elecService.selectByModelnum(modelNum, false);
		request.setAttribute("dbElec", dbElec);
		ModelAndView mv = new ModelAndView("elec/read.jsp"); */
		
		//방법 2
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=elec&methodName=selectByModelNum&modelNum="+modelNum+"&flag=false&pageNo="+pageNo);
		mv.setRedirect(true);
		
		return mv;
	}
}
