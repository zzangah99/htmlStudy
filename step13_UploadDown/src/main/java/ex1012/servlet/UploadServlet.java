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
		//�Ѿ���� �� 3�� �ޱ�
		/*
		 * String name = request.getParameter("name"); String subject =
		 * request.getParameter("subject"); String file = request.getParameter("file");
		 */
		
		//������ enctype="multipart/form-data" ������ ���� request�� ���� �� ����
		String saveDir = request.getServletContext().getRealPath("/save");
		int maxSize= 1024*1024*100;//100M
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String name = m.getParameter("name");
		String subject = m.getParameter("subject");
		String file = m.getParameter("file");
		
		String fileSystemName = m.getFilesystemName("file");//<input type="file" name="file" �� ���
		String originalName = m.getOriginalFileName("file"); 
		
		//÷�ε� ������ �뷮
		long fileSize = m.getFile("file").length();
		
		System.out.println("name = " + name);
		System.out.println("subject = " + subject);
		System.out.println("file = " + file);
		
		System.out.println("fileSystemName = " + fileSystemName);
		System.out.println("originalName = " + originalName);
		System.out.println("fileSize = " + fileSize);
		
		
		//scope ������ ����
		request.setAttribute("name", name);	//�信�� ${requestScope.name}
		request.setAttribute("subject", subject);
		request.setAttribute("fileSystemName", fileSystemName);
		request.setAttribute("originalName", originalName);
		request.setAttribute("saveDir", saveDir);
		request.setAttribute("fileSize", fileSize);
		
		
		//��� �������� �̵� - �信�� ����� ������ �����ؼ� ����
		//response, request�� �����ؼ� �������� forward ������� �̵��Ѵ�
		request.getRequestDispatcher("upLoadResult.jsp").forward(request, response);
		
	}

}
