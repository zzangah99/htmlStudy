package ex1005.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//모든 세션의 정보 삭제
		HttpSession session = req.getSession();
		session.invalidate();
		
		//폼으로 이동
		resp.sendRedirect("LoginForm.html");
	}
}
