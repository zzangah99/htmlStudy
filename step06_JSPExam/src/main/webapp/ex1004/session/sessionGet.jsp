<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
저장된 정보 조회하기 <p>
아이디 : <%=session.getAttribute("id") %><br>
나이 : <%=session.getAttribute("age") %><br>
취미 : <%=session.getAttribute("hobbys") %><br>
</h3>

<hr>
<h3>
application 영역에 저장된 정보 확인<p>
메시지 : <%=application.getAttribute("message") %><br>
주소 : <%=application.getAttribute("addr") %><br>
메뉴 : <%=application.getAttribute("menus") %><br>
</h3>
</body>
</html>