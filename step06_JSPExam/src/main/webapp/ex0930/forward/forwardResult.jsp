<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>forward 결과 - forwardResult.jsp 문서입니다</h2>
<h3>
연산결과 : <%=request.getParameter("total") %><p>
메시지 : <%=request.getParameter("message") %>
</h3>
</body>
</html>