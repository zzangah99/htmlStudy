<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>include 지시자</h1>
<%@ include file="top.jsp" %>
<%
	String addr = "서울시 강남구";
%>

<h3>여기부터는 main.jsp 영역입니다</h3>
<hr>

<%@ include file="footer.jsp" %>

</body>
</html>