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
	 * 아디중복체크
	 * */
	public void idCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");   
		
		String id = request.getParameter("id");
		boolean result = customerDAO.idCheck(id);
		
		PrintWriter out = response.getWriter();
		
		if(result) out.print("중복입니다.");
		else out.print("사용가능합니다.");
	}
	
	
	
	/**
	 * 등록하기
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
	 * 전체검색
	 * */
	public void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");   
		
		List<CustomerDTO> list = customerDAO.selectAll();
		
		//list를 응답할수 없기때문에 list를 jsonArray변환해서 보낸다.
		JSONArray arr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.print(arr);
		 
	}
	
	/**
	 * 수정하기
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
	 * 삭제하기 
	 * */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
         String id =   request.getParameter("id");
         
        int result =  customerDAO.delete(id);
        PrintWriter out = response.getWriter();
		out.print(result);
	}

}











