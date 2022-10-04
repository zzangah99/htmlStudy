<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h3 {text-align: center;}
</style>
</head>
<body>
<%
	boolean cookieCheck = false;
	Cookie [] cookies = request.getCookies();
	long now = 0;
	Cookie findCookie = null;
	

	//마지막 방문일을 저장하고 있는 쿠키가 있는지로 방문 여부 판별
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("lastVisit")){
			//쿠키 있음
			cookieCheck = true;
			findCookie = cookie;
		}
	}
	
		
	if (cookieCheck) {
		out.println("<h3>당신의 마지막 접속일은 " + new Date(Long.parseLong(findCookie.getValue())) + "</h3><p>");

		now = System.currentTimeMillis();
		out.println("<h3>현재 접속 시간 : " + new Date(now) + "</h3><p>");

		findCookie.setValue(String.format("%s", now));
		out.println("<h3>다시 저장된 시간 : " + now + "</h3><p>");

	} else {
		out.println("<h3>당신은 처음 방문하셨습니다.</h3><p>");

		now = System.currentTimeMillis();
		out.println("<h3>현재 접속 시간 : " + new Date(System.currentTimeMillis()) + "</h3><p>");

		Cookie co = new Cookie("lastVisit", String.format("%s", now));
		co.setMaxAge(60 * 60 * 24 * 365);
		co.setPath("/");
		response.addCookie(co);

		out.println("<h3>다시 저장된 시간 : " + now + "</h3><p>");
	}
%>

</body>
</html>