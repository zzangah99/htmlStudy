<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>쿠키 정보 확인하기</h3>
<%
	Cookie [] cookies = request.getCookies();//쿠키는 리퀘스트에 따라 들어오고 여러개일 수 있으므로 배열로 받음
	
	if(cookies != null){
		out.println("쿠키 개수 : " + cookies.length +"<p>");
		
		for(Cookie co : cookies){
			out.println(co.getName() + " = " + co.getValue() +"<br>");
		}
		
	}else{
		out.println("<h3>저장된 쿠키 정보가 없습니다</h3>");
	}
%>

</body>
</html>