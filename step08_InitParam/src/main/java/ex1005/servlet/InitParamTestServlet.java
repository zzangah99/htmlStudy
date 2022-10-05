package ex1005.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamTestServlet extends HttpServlet {
	private String message, driverName, dbId;
	
	@Override
	public void init() throws ServletException {
		//context-param
		ServletContext application = super.getServletContext();
		message = application.getInitParameter("message");
		driverName = application.getInitParameter("driverName");
		
		dbId = super.getInitParameter("dbId");
		
		System.out.println(message + " , " + driverName + " , " + dbId);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Service call > " + message + " , " + driverName + " , " + dbId);
	}
}
