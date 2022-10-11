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
		System.out.println("LoginServlet ����");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//System.out.println("LoginServlet init call");
		//init-param ���޵Ǵ� �� �ޱ�
		dbId = config.getInitParameter("dbId");
		dbPwd = config.getInitParameter("dbPwd");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		//post��� �ѱ� ���ڵ� ó��
		req.setCharacterEncoding("UTF-8");
		
		//�Ѿ���� �� 3���� �޴´�
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPwd");
		
		PrintWriter out = resp.getWriter();
		
		
		//id�� pw�� ��ġ�ϴ��� Ȯ���ؼ� ��ġ�ϸ� LoginOk.jsp�� �̵�
		//������ �̸�, ���̵�, ���� �ð� ����
		if(dbId.equals(userId) && dbPwd.equals(userPw)) {
			HttpSession session = req.getSession();
			session.setAttribute("id", userId);
			session.setAttribute("creationTime", new Date().toLocaleString());
			
			//resp.sendRedirect("index.jsp"); left �������� index.jsp�� �ε�Ǵµ� �װ� �ƴ϶� ������ ��ü�� �ٲ��� �ؼ� script�� ����Ѵ�
			out.println("<script>");
			out.println("top.location.href='index.jsp'"); //top �� �ٿ� iframe ���� ��ü�� index ������ �ε�
			out.println("</script>");
		}
		
		//�ƴϸ� �޽��� ����ϰ� ������ �̵�
		else {
			
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
