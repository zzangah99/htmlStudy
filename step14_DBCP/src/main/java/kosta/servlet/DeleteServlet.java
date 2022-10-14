package kosta.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;
import kosta.dto.Member;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAOImpl();
		
		if(dao.delete(id)==0) {
			request.setAttribute("errMsg", id+" 정보를 삭제할 수 없습니다");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else {
			response.sendRedirect("selectAll");//서블릿으로 이동
		}
	}

}
