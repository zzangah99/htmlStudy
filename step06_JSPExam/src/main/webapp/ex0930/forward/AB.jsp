<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>
<%=request.getParameter("name") %>님 혈액형은
<%=request.getParameter("blood") %>형
</h2>
<h3>엉뚱</h3>
</body>
</html>