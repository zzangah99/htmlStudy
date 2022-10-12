package ex1012.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownListServlet
 */
@WebServlet("/downList")
public class DownListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// save ������ �ִ� ������ ������ �����ͼ� ������ �� �� ������ �̵��Ѵ�
		String saveDir = req.getServletContext().getRealPath("/save");
		File file = new File(saveDir);
		if(file.exists()) {
			String fileNames[] = file.list();
			
			req.setAttribute("fileNames", fileNames); //�俨�� ${fileNames}
		}
		
		//�̵�
		req.getRequestDispatcher("downList.jsp").forward(req, resp);
	}

}
