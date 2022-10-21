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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		PrintWriter out = response.getWriter();
		CustomerDAO dao = new CustomerDAOImpl();
		
		int result = dao.delete(id);
		if(result>0) {
			out.println("삭제 되었습니다");
		}else {
			out.println("삭제에 실패하였습니다");
		}
	}

}
