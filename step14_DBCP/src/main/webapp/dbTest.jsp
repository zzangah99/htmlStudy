<%@page import="java.util.List"%>
<%@page import="kosta.dao.TestDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>DBCP TEST</h3>
<%
	TestDAO dao = new TestDAO();
	List<String> list = dao.selectByEname();
	
	out.println("결과 : " + list);
%>
</body>
</html>