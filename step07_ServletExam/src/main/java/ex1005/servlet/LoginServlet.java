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
		System.out.println("LoginServlet 생성");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LoginServlet init call");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		//post방식 한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		//넘어오는 값 3개를 받는다
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPwd");
		String userName = req.getParameter("userName");
		
		
		//id와 pw이 일치하는지 확인해서 일치하면 LoginOk.jsp로 이동
		//세션의 이름, 아이디, 접속 시간 저장
		if(dbId.equals(userId) && dbPw.equals(userPw)) {
			HttpSession session = req.getSession();
			session.setAttribute("id", userId);
			session.setAttribute("name", userName);
			session.setAttribute("creationTime", new Date().toLocaleString());
			
			resp.sendRedirect("LoginOk.jsp");
		}
		
		//아니면 메시지 출력하고 폼으로 이동
		else {
			PrintWriter out = resp.getWriter();
			
			out.println("<script>");
			out.println("alert('정보가 일치하지 않습니다')");
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
