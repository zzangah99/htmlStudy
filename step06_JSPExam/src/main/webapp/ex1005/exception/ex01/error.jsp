<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!-- isErrorPage를 true로 설정해야 exception 볼 수 있음 -->

<%
	response.setStatus(200);//정상. status 500 -> 200으로 변경. exception이라는 키워드를 사용하기 위해
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>예외가 발생했습니다</h3>
예외 종류 : <%=exception %><p>
예외 메시지 : <%=exception.getMessage() %><p>
예외 클래스 : <%=exception.getClass() %><p>

<hr>
<a href="exceptionForm.jsp">폼으로 이동</a>
</body>
</html>