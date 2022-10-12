<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>~.jsp 이동</h3>
<form action="encodingResult.jsp" method="post">
	이름: <input type="text" name="name">
	<input type="submit" value="전송">
</form>

<hr>
<h3>servlet 이동</h3>
<form action="encodingTest" method="post">
	이름: <input type="text" name="name">
	<input type="submit" value="전송">
</form>
</body>
</html>