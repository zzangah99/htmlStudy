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
 * Servlet implementation class DetailServlet
 */
@WebServlet("/read")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="error.jsp";
		String errMsg = "원하시는 정보를 찾지 못했습니다";
		boolean isRedirect = false; //true이면 redirect 방식, false이면 forward 방식
		
		MemberDAO dao = new MemberDAOImpl();
		Member m = dao.selectById(request.getParameter("id"));
		
		if(m == null) {
			request.setAttribute("errMsg", errMsg);
		}else {
			url = "read.jsp";
			request.setAttribute("member", m);
			isRedirect = true;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
