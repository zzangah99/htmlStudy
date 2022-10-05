package ex1005.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet 작성 방법
 *	1) 반드시 pubic class
 *	2) HttpServlet 상속
 *	3) 필요한 메소드를 재정의한다
 *	4) 실행을 위해서 등록을 한다
 *		- web.xml에 등록
 *		- @annotation 등록
 */

public class LifeCycleServlet extends HttpServlet {
	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet의 생성자 호출");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycleServlet의 init call");
	}
	
	/* @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleServlet의 service call");
		//재정의(오버라이딩)을 했기 때문에 doGet, doPost가 실행되지 않은 것
	} */
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//문서 첫줄에 한글 인코딩 설정
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("LifeCycleServlet의 doGet call");
		
		//브라우저에 출력
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Servlet 실습중</title></head>");
		out.println("<body>");
		out.println("<h3 style='color:red'>Servlet 시작하기</h3>");
		
		//HttpSession
		HttpSession session = request.getSession();
		session.setAttribute("name", "세륜");
		
		//ServletContext
		ServletContext application = request.getServletContext();
		application.setAttribute("message", "servlet 뭐라는거지");
		
		//Cookie
		Cookie cookie = new Cookie("lastDate",System.currentTimeMillis()+"");
		response.addCookie(cookie);
		
		out.println("</body>");
		out.println("</html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleServlet의 doPost call");
	}

	@Override
	public void destroy() {
		//서블릿이 소멸될 때 호출
		System.out.println("LifeCycleServlet의 destroy call");
	}
}
