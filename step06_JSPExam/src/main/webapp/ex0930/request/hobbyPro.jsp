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
	request.setCharacterEncoding("UTF-8");
%>

<h3>
	이름: <%=request.getParameter("name") %>	<br>
	나이: <%=request.getParameter("age") %>	<br>
	
	<!-- 하나의 이름으로 값이 여러개 전송될 때는 getParameterValues() -->
	취미: 
	<%
		String hobbys[] = request.getParameterValues("hobby");
		for(String h : hobbys){
			out.println(h + " ");
		}
	%>	<br>
	접속자 IP: <%=request.getRemoteAddr() %> <br>
</h3>
</body>
</html>