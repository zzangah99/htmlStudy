package kosta.mvc.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.dao.CustomerDAO;
import kosta.mvc.dao.CustomerDAOImpl;
import kosta.mvc.dto.CustomerDTO;
import net.sf.json.JSONArray;

public class CustomerController implements Controller {
   private CustomerDAO customerDAO = new CustomerDAOImpl();
   
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}
	
	/**
	 * �Ƶ��ߺ�üũ
	 * */
	public void idCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");   
		
		String id = request.getParameter("id");
		boolean result = customerDAO.idCheck(id);
		
		PrintWriter out = response.getWriter();
		
		if(result) out.print("�ߺ��Դϴ�.");
		else out.print("��밡���մϴ�.");
	}
	
	
	
	/**
	 * ����ϱ�
	 * */
	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		CustomerDTO dto = new CustomerDTO(id, name, Integer.parseInt(age), tel, addr);
		int result = customerDAO.insert(dto);
		
		PrintWriter out = response.getWriter();
		out.print(result); // 0 , 1 
	}
	
	/**
	 * ��ü�˻�
	 * */
	public void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");   
		
		List<CustomerDTO> list = customerDAO.selectAll();
		
		//list�� �����Ҽ� ���⶧���� list�� jsonArray��ȯ�ؼ� ������.
		JSONArray arr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.print(arr);
		 
	}
	
	/**
	 * �����ϱ�
	 * */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		CustomerDTO dto = new CustomerDTO(id, name, Integer.parseInt(age), tel, addr);
		int result = customerDAO.update(dto);
		PrintWriter out = response.getWriter();
		out.print(result);
	}
	
	/**
	 * �����ϱ� 
	 * */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
         String id =   request.getParameter("id");
         
        int result =  customerDAO.delete(id);
        PrintWriter out = response.getWriter();
		out.print(result);
	}

}











