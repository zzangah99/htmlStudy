<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HttpSession - session 관련 메소드</h1>
<h3>
session.getId() : <%=session.getId() %> <br>
session.isNew() : <%=session.isNew() %> <br>
session.getMaxInactiveInterval() : <%=session.getMaxInactiveInterval() %> <br>
session.getCreationTime() : 
<%
	long creationTime = session.getCreationTime();
	String creationTimeStr = new Date(creationTime).toLocaleString();
	out.println(creationTime + " : " + creationTimeStr);//보기 쉽게 시간 표현
%> <br>
session.getLastAccessedTime() : 
<%
	long lastAccess = session.getLastAccessedTime();
	String lastAccessStr = new Date(lastAccess).toLocaleString();
	out.println(lastAccess + " : " + lastAccessStr);
%> <br>

<hr>
<%
	//세션에 정보 저장
	session.setAttribute("id", "chun");
	session.setAttribute("age", "24");
	session.setAttribute("hobbys",new String[]{"오","버","워","치"});
%>
저장된 정보 조회하기 <p>
아이디 : <%=session.getAttribute("id") %><br>
나이 : <%=session.getAttribute("age") %><br>
취미 : <%=session.getAttribute("hobbys") %><br>

</h3>
<a href = "sessionGet.jsp">session 정보 확인하러 가기</a>
</body>
</html>