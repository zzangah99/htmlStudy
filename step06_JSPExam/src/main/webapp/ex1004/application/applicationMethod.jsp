<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>ServletContext - application 관련 메소드</h3>
application.getContextPath() = <%=application.getContextPath() %><br>
application.getRealPath("/") = <%=application.getRealPath("/") %><br>

application.getMajorVersion = <%=application.getMajorVersion() %><br>
application,getMinorVersion= <%=application.getMinorVersion() %><br>
application.getServerInfo() = <%=application.getServerInfo() %><br>


<%
	//application 영역에 정보 저쟝
	application.setAttribute("message", "배고프디");
	application.setAttribute("addr", "경기도 성남시 오리역");
	application.setAttribute("menus", Arrays.asList("중식","한식","일식"));
	
%>

application 영역에 저장된 정보 확인<p>
메시지 : <%=application.getAttribute("message") %><br>
주소 : <%=application.getAttribute("addr") %><br>
메뉴 : <%=application.getAttribute("menus") %><br>

<a href="${pageContext.request.contextPath}/ex1004/session/sessionGet.jsp">정보확인하러가기</a>
</body>
</html>