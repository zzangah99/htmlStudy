<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HttpServletRequest - request 관련 메소드</h1>
<%
	Enumeration<String> e = request.getHeaderNames(); //request의 header 정보에 해당하는 name들
	while(e.hasMoreElements()){
		String name = e.nextElement();
		String value = request.getHeader(name);
		out.println(name + " = " + value + "<br>");
	}
	
%>
<hr>
<!-- 서버에 프로젝트를 올리면 Servers -> server.xml 파일의 아래에 context 태그에 서버에 올라간 프로젝트 이름과 경로가 올라간다 -->
<!-- http 기본 포트 번호 : 80, ftp 기본 포트 번호 : 21 -->
<!-- IP(도메인)만 치고 들어오려면 설정을 해줘야 한다 -->
<!-- ContextPath는 프로젝트명이 아니라 xml 파일의 서버에 올라간 열릴 파일의 설정 path가 뜨는 것이다(개인이 설정 가능) -->
request.getContextPath() = <%=request.getContextPath() %><p>
request.getRequestURL() = <%=request.getRequestURL() %><p>
</body>
</html>