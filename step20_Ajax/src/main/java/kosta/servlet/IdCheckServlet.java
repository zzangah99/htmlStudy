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

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/idCheckServlet")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		
		CustomerDAO dao = new CustomerDAOImpl();
		if(dao.idCheck(id)){
			out.print("중복입니다");
		} else {
			out.print("사용 가능합니다");
		}
	}

}
