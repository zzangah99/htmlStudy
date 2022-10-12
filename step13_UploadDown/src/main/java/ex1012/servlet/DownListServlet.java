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
		// save 폴더에 있는 파일의 정보를 가져와서 저장한 후 뷰 쪽으로 이동한다
		String saveDir = req.getServletContext().getRealPath("/save");
		File file = new File(saveDir);
		if(file.exists()) {
			String fileNames[] = file.list();
			
			req.setAttribute("fileNames", fileNames); //뷰엥서 ${fileNames}
		}
		
		//이동
		req.getRequestDispatcher("downList.jsp").forward(req, resp);
	}

}
