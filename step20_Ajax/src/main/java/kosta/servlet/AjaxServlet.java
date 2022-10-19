package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String imgNames [] = {"spring.jpg","android.jpg","jquery.jpg","jsmasterbook.jpg"};

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book = request.getParameter("book"); //0 1 2 3 ...
		String imgInfo = imgNames[Integer.parseInt(book)];
		
		//front에 전송
		//out.println();
		PrintWriter out = response.getWriter();
		out.println(imgInfo);//브라우저로 보내는 것
	}

}
