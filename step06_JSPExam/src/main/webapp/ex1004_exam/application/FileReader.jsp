<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
	//파일이 저장된 save 폴더에서 폴더 안에 있는 모든 파일 제목을 조회한다
	String realPath = (String)application.getAttribute("realPath");

	File path = new File(realPath);
	String [] fileList = path.list();
	
	out.println("<h3>파일 목록</h3>");
	if(fileList != null){
		out.println("<ul>");
		for(String s : fileList){
			out.println("<li>" + s + "</li>");
		}
		out.println("</ul>");
	}
	//조회된 파일을 첨부된 이미지처럼 출력한다
	
	//등록하기를 클릭하면 등록폼으로 이동
%>

<input type="button" value="등록하기" onclick="board_Form.html">
</body>
</html>