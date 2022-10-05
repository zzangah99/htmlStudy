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
 * Servlet �ۼ� ���
 *	1) �ݵ�� pubic class
 *	2) HttpServlet ���
 *	3) �ʿ��� �޼ҵ带 �������Ѵ�
 *	4) ������ ���ؼ� ����� �Ѵ�
 *		- web.xml�� ���
 *		- @annotation ���
 */

public class LifeCycleServlet extends HttpServlet {
	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet�� ������ ȣ��");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycleServlet�� init call");
	}
	
	/* @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleServlet�� service call");
		//������(�������̵�)�� �߱� ������ doGet, doPost�� ������� ���� ��
	} */
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� ù�ٿ� �ѱ� ���ڵ� ����
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("LifeCycleServlet�� doGet call");
		
		//�������� ���
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Servlet �ǽ���</title></head>");
		out.println("<body>");
		out.println("<h3 style='color:red'>Servlet �����ϱ�</h3>");
		
		//HttpSession
		HttpSession session = request.getSession();
		session.setAttribute("name", "����");
		
		//ServletContext
		ServletContext application = request.getServletContext();
		application.setAttribute("message", "servlet ����°���");
		
		//Cookie
		Cookie cookie = new Cookie("lastDate",System.currentTimeMillis()+"");
		response.addCookie(cookie);
		
		out.println("</body>");
		out.println("</html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleServlet�� doPost call");
	}

	@Override
	public void destroy() {
		//������ �Ҹ�� �� ȣ��
		System.out.println("LifeCycleServlet�� destroy call");
	}
}
