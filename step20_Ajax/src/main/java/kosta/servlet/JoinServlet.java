package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.CustomerDAO;
import kosta.dao.CustomerDAOImpl;
import kosta.dto.CustomerDTO;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/joinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		PrintWriter out = response.getWriter();
		
		CustomerDAO dao = new CustomerDAOImpl();
		CustomerDTO dto = new CustomerDTO(id, name, Integer.parseInt(age), tel, addr);
		int result = dao.insert(dto);
		out.print(result);
	}

}
