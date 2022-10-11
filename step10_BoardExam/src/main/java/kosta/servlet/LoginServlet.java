package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

@WebServlet(urlPatterns="/login", loadOnStartup=1,
		initParams= {@WebInitParam(name="dbId", value="chun"),
					@WebInitParam(name="dbPwd", value="1111")
		}
)
public class LoginServlet extends HttpServlet {
	String dbId, dbPwd;
	
	public LoginServlet() {
		System.out.println("LoginServlet 생성");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//System.out.println("LoginServlet init call");
		//init-param 전달되는 값 받기
		dbId = config.getInitParameter("dbId");
		dbPwd = config.getInitParameter("dbPwd");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		//post방식 한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		//넘어오는 값 3개를 받는다
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPwd");
		
		PrintWriter out = resp.getWriter();
		
		
		//id와 pw이 일치하는지 확인해서 일치하면 LoginOk.jsp로 이동
		//세션의 이름, 아이디, 접속 시간 저장
		if(dbId.equals(userId) && dbPwd.equals(userPw)) {
			HttpSession session = req.getSession();
			session.setAttribute("id", userId);
			session.setAttribute("creationTime", new Date().toLocaleString());
			
			//resp.sendRedirect("index.jsp"); left 페이지에 index.jsp가 로드되는데 그게 아니라 페이지 전체가 바뀌어야 해서 script를 써야한다
			out.println("<script>");
			out.println("top.location.href='index.jsp'"); //top 을 붙여 iframe 위의 전체를 index 페이지 로드
			out.println("</script>");
		}
		
		//아니면 메시지 출력하고 폼으로 이동
		else {
			
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
