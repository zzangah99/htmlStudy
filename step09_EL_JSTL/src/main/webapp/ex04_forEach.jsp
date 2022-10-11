<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {width:400px; border:solid red 1px; border-collapse: collapse;}
	th, td{padding:5px; border:solid gray 1px; text-align: center;}
</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("tr:odd").css({backgroundColor:"skyblue"});
		
		$("tr:even").css({backgroundColor:"pink"});
		$("tr:eq(0)").css({backgroundColor:"orange", color:"white"});
	})
</script>
</head>
<body>
<h3>&lt;c:forEach>연습하기</h3>

<c:forEach var="i" begin="1" end="10">
	${i} ,
</c:forEach>
<hr>
<%
	String hobbys[] = {"등산","수영","낚시","골프"};
	//request.setAttribute("hobbys", hobbys);
%>
\${hobbys} = ${hobbys}<br>


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
			<td>${board.no}</td> <!-- board.getNo() -->
			<td>${board.subject}</td>
		</tr>
	</c:forEach>
</table>


<hr>
<!-- map을 이용한 반복문
	<input type="radio" value="kr"> 대한민국
-->
<fieldset>
	<legend>나라선택</legend>
	<c:forEach items="${bean.map}" var="nation">
		<input type="radio" name="nation" value="${nation.key}">${nation.value}
	</c:forEach> 	
</fieldset>

<!-- 숫자 1000의 자리마다 콤마(,) 처리 -->
가격 : 564915135400원 / <fmt:formatNumber value="564915135400"/>원


<hr>
<a href="ex03_if_choose.jsp">이동1</a>
<a href="/ex03_if_choose.jsp">이동2(경로 앞에 / 루트) - x</a>
<a href="${pageContext.request.contextPath}/ex03_if_choose.jsp">이동1</a><br>
\${pageContext.request.contextPath} = ${pageContext.request.contextPath} <!-- 경로를 지정할 때는 contextPath로 루트를 잡아주는 게 중요 -->

</body>
</html>