<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>나라 정보 - ServletContextListener TEST</h3>
<fieldset>
	<legend>나라 선택</legend>
	<c:forEach items="${applicationScope.nationMap}" var="nation">
		<input type="radio" name="nation" value="${nation.key}">${nation.value}
	</c:forEach>
		
</fieldset>

<hr>
<h4>[접속자 수 : ${applicationScope.count}명]</h4>
</body>
</html>