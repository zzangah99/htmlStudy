<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a{text-decoration: none;}
</style>
</head>
<body>

<c:choose>
	<c:when test="${not empty sessionScope.id }">
		${id }님 로그인 중<br>
		[접속시간 : ${creationTime}]<p>
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a> <!-- servlet의 url-pattern이 /logout -->
	</c:when>
	<c:otherwise>
		<form method="post" action="${pageContext.request.contextPath}/login">	<!-- servlet의 url-pattern이 /login -->
		  ID : <input type="text" name="userId" size="10"/><br/>
		  PWD : <input type="password" name="userPwd" size="10"/><br/>
		  
		  <input type="submit" value="로그인" />
		  <input type="reset" value="취소" />
		</form>
	</c:otherwise>
</c:choose>

</body>
</html>