<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

저장된 정보 출력하기<p>
아이디 : ${id } / <c:out value="${id}"/> <br>
나이 :  ${age } / ${sessionScope.age} / <c:out value="${age}"/> <br> <!-- 같은 세션이면 출력됨 -->
주소 :  ${addr} / ${applicationScope.addr} /<c:out value="${addr}"/> <br> <!-- 서버 유지시 출력됨 -->
이름 :  ${name } / <c:out value="${name}"/> <br>

</body>
</html>