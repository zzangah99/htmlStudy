<%@page import="java.io.FileWriter"%>
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
	//전송된 데이터 받기(이름, 제목, 내용)
	long time = System.currentTimeMillis();

	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	/* 작성자이름_시간.txt 으로 저장 - 작성자이름_System.currentTimeMillis() + ".txt"
	//위 파일에 제목, 내용을 저장한다. ~.write();
	
	//먼저 저장할 save폴더를 이클립스에서 만든다.
    파일 경로 : application.getRealPath("/ex1004/exam/application/save")

    파일 리스트
    새글 등록
    IO 이용해서 파일 생성
    alert로 생성되었습니다
    FileReader.jsp로 이동하여 찍어냄  -> 폴더안에 있는 목록가져오기 (IO의 File객체의 ~.list() 메소드 )
    내용은 작성 제목 내용 */
    
    
    //FileWriter file = new FileWriter(application.getRealPath("/ex1004/exam/application/save"));
%>
</body>
</html>