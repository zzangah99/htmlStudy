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

<table>
<caption><h3>Board LIST</h3></caption>
	<tr>
		<th>순서</th>
		<th>글번호</th>
		<th>제목</th>
		<th>내용</th>
	</tr>
	<c:forEach items="${applicationScope.boardList}" var="board" varStatus="state">
	<tr>
		<td>${state.count}</td>
		<td>${board.no}</td>
		<td>${board.subject}</td>
		<td>${board.content}</td>
	</tr>
	</c:forEach>
</table>

<hr>

<c:if test="${not empty sessionScope.id }">
<form action="${pageContext.request.contextPath}/board" method="post"> 
	글번호 : <input type="text" name="no" size="10"><p>
	제목 : <input type="text" name="subject"><p>
	내용 : <textarea rows="10" cols="20" name="content"></textarea><p>
	<input type="submit" value="등록">
	<input type="reset" value="취소">
</form>
</c:if>

</body>
</html>