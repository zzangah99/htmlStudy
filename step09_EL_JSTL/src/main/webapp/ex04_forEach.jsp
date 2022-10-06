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
<h3>&lt;c:forEach>연습하기</h3>

<c:forEach var="i" begin="1" end="10">
	${i} ,
</c:forEach>
<hr>
<%
	String hobbys[] = {"등산","수영","낚시","골프"};
%>
<c:forEach var="hobby" items="<%=hobbys %>" varStatus="state">
	${hobby} / ${state.index } / ${state.count} <br>
</c:forEach>

<hr>
<h4>Bean에 있는 데이터 출력</h4>
<jsp:useBean id="bean" class="ex1006.jstl.ForEachBean"/>
menus: ${bean.menus }<p> <!-- bean.getMenus() 호출 -->
names: ${bean.names }<p>
boardList: ${bean.boardList }<p>
map: ${bean.map}<p>


<select name="menu">
	<option value="0">--선택--</option>
	<c:forEach items="${bean.menus}" var="menu">
		<option value="${menu}">${menu}</option>		
	</c:forEach>
</select>

<p>
<fieldset>
	<legend>이름선택</legend>
	<c:forEach items="${bean.names}" var="name" varStatus="state">
		<input type="checkbox" name="userName" value="${state.count}"> ${name}
	</c:forEach>
</fieldset>

<p>
<table>
	<tr>
		<th>순서</th>
		<th>번호</th>
		<th>제목</th>
	</tr>
	<c:forEach items="${bean.boardList}" var="board" varStatus="state">
		<tr>
			<td>${state.count}</td>
			<td>${board.no}</td> <!-- board의 getNo() -->
			<td>${board.subject}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>