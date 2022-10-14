package kosta.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;
import kosta.dto.Member;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
		MemberDAO dao = new MemberDAOImpl();
		List<Member> list = dao.searchByKeyWord(keyField, keyWord);
		
		request.setAttribute("list", list); //멤버 리스트 같은 변수
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}

}
