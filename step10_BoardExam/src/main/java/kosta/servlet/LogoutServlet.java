package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/logout") //�ٸ� �ɼ��� ���� �� url-pattern�� �⺻ �Ӽ��̴�
@WebServlet(urlPatterns="/logout", loadOnStartup=1)
public class LogoutServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��� ������ ���� ����
		HttpSession session = req.getSession();
		session.invalidate();
		
		PrintWriter out = resp.getWriter();
		out.println("<script>");
		out.println("top.location.href='index.jsp'");
		out.println("</script>");
	}
}
