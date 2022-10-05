package ex1005.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

public class LoginServlet extends HttpServlet {
	String dbId = "chun", dbPw = "1111", dbName = "";
	
	public LoginServlet() {
		System.out.println("LoginServlet ����");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LoginServlet init call");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		//post��� �ѱ� ���ڵ� ó��
		req.setCharacterEncoding("UTF-8");
		
		//�Ѿ���� �� 3���� �޴´�
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPwd");
		String userName = req.getParameter("userName");
		
		
		//id�� pw�� ��ġ�ϴ��� Ȯ���ؼ� ��ġ�ϸ� LoginOk.jsp�� �̵�
		//������ �̸�, ���̵�, ���� �ð� ����
		if(dbId.equals(userId) && dbPw.equals(userPw)) {
			HttpSession session = req.getSession();
			session.setAttribute("id", userId);
			session.setAttribute("name", userName);
			session.setAttribute("creationTime", new Date().toLocaleString());
			
			resp.sendRedirect("LoginOk.jsp");
		}
		
		//�ƴϸ� �޽��� ����ϰ� ������ �̵�
		else {
			PrintWriter out = resp.getWriter();
			
			out.println("<script>");
			out.println("alert('������ ��ġ���� �ʽ��ϴ�')");
			out.println("location.href='LoginForm.html'");
			out.println("</script>");
		}
	}
	
	/* @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet doGet call");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet doPost call");
	} */
	
}
