package ex1005.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {
	private String dbId, dbPwd, message, driverName;
	
	//init-param 은 service에서 불러와도 되지만 service는 계속 호출되기 때문에 효율적이지 않다
	@Override
	public void init() throws ServletException {
		ServletContext application = super.getServletContext();
		message = application.getInitParameter("message");
		driverName = application.getInitParameter("driverName");
		
		dbId = super.getInitParameter("dbId");
		dbPwd = getInitParameter("dbPwd");
		
		System.out.println("dbId="+dbId + " , " +"dbPwd="+dbPwd);
		System.out.println("message="+message + " , " +"driverName="+driverName);
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Service call > dbId="+dbId + " , " +"dbPwd="+dbPwd + " , " + "message="+message + " , " +"driverName="+driverName);
	}
}
