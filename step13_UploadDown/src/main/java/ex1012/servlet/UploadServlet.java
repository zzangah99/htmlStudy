package ex1012.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UpLoad")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//넘어오는 값 3개 받기
		/*
		 * String name = request.getParameter("name"); String subject =
		 * request.getParameter("subject"); String file = request.getParameter("file");
		 */
		
		//폼에서 enctype="multipart/form-data" 설정된 경우는 request로 받을 수 없다
		String saveDir = request.getServletContext().getRealPath("/save");
		int maxSize= 1024*1024*100;//100M
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String name = m.getParameter("name");
		String subject = m.getParameter("subject");
		String file = m.getParameter("file");
		
		String fileSystemName = m.getFilesystemName("file");//<input type="file" name="file" 인 경우
		String originalName = m.getOriginalFileName("file"); 
		
		//첨부된 파일의 용량
		long fileSize = m.getFile("file").length();
		
		System.out.println("name = " + name);
		System.out.println("subject = " + subject);
		System.out.println("file = " + file);
		
		System.out.println("fileSystemName = " + fileSystemName);
		System.out.println("originalName = " + originalName);
		System.out.println("fileSize = " + fileSize);
		
		
		//scope 영역에 저장
		request.setAttribute("name", name);	//뷰에서 ${requestScope.name}
		request.setAttribute("subject", subject);
		request.setAttribute("fileSystemName", fileSystemName);
		request.setAttribute("originalName", originalName);
		request.setAttribute("saveDir", saveDir);
		request.setAttribute("fileSize", fileSize);
		
		
		//결과 페이지로 이동 - 뷰에서 출력할 정보를 저장해서 간다
		//response, request를 유지해서 가져가는 forward 방식으로 이동한다
		request.getRequestDispatcher("upLoadResult.jsp").forward(request, response);
		
	}

}
