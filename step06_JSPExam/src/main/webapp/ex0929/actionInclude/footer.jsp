<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- main의 addr을 그냥은 못 쓴다 -->
<%
	//parameter(or 폼)로 전송된 데이터를 받기
	String id = request.getParameter("id");
	String addr = request.getParameter("addr");
%>

<h1>footer.jsp 입니다</h1> 

<h4>주소 : <%=addr %></h4>
<h4>아이디 : <%=id %></h4>
</body>
</html>