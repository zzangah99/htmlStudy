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
 * Servlet implementation class SelectAllServlet
 */
@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAOImpl();
		List<Member> list = dao.selectAll();
		
		//list를 scope 영역에 저장
		request.setAttribute("list", list);
		
		//memberSelect.jsp 이동
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}

}
