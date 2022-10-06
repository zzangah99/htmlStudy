<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    <!-- c를 쓰긔 위해선언을 먼저 해줘야 한다! -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>JSTL - &lt;c:out> and &lt;c:set></h3>

<c:out value="안녕!" /><br>
<c:out value="<h4>안녕</h4>"/> <br>
<c:out value="<h4>안녕</h4>" escapeXml="true"/> <br> <!-- 마크업 인식x -->
<c:out value="<h4>안녕</h4>" escapeXml="false"/> <br>
${"<h4>안녕</h4>"}<hr>

<!-- 변수 선언 -->
<c:set var="id" value="king" />
<c:set var="age" value="20" scope="session" /> <!--  page|request|session|application -->
<c:set var="addr" value="제주도" scope="application" />

<% 
	String name="천세륜"; 
	//xxx.setAttribute("name", name);
%>
<c:set var="name" value="<%=name %>"/>
이름: ${name } / <p>

저장된 정보 출력하기<p>
아이디 : ${id } / <c:out value="${id}"/> <br>
나이 :  ${age } / ${sessionScope.age} / <c:out value="${age}"/> <br>
주소 :  ${addr} / ${applicationScope.addr} /<c:out value="${addr}"/> <br>
이름 :  ${name } / <c:out value="${name}"/> <br>


<a href="ex02_result.jsp">확인하러가기</a>

</body>
</html>