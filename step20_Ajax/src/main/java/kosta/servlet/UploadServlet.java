package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upLoadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		String path=request.getServletContext().getRealPath("/save");
		int maxSize= 1024*1024*100 ;
	    String encoding="UTF-8" ;
		
	    MultipartRequest m = new MultipartRequest(request, path, maxSize, encoding, 
				new DefaultFileRenamePolicy());
	    
	    //servier -> dao -> insert 완료~~
	   String name =  m.getParameter("name");
	   String subject =  m.getParameter("subject");
	   String filesystemName =  m.getFilesystemName("file");
	   String originalName =  m.getOriginalFileName("file");
	   long fileSize = m.getFile("file").length();
	   
	   System.out.println("name : " + name);
	   System.out.println("subject : " + subject);
	   System.out.println("filesystemName : " + filesystemName);
	   System.out.println("originalName : " + originalName);
	   System.out.println("fileSize : " + fileSize);
	   
	   Map<String, Object> map = new HashMap<>();
	   map.put("name", name);
	   map.put("subject", subject);
	   map.put("filesystemName", filesystemName);
	   map.put("originalName", originalName);
	   map.put("fileSize", fileSize);
	   map.put("path", path);
	   
	   //map을 json의 형태로 변환해서 보낸다.
	   JSONArray jsonArr = JSONArray.fromObject(map);
	   
	   PrintWriter out = response.getWriter();
	   out.println(jsonArr);
	   	    
	}

}



