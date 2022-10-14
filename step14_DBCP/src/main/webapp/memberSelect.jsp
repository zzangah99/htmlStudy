<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
  table{width:100%; border:none;}
  th,td{padding:5px; border: 1px solid pink ; text-align: center }
  a{text-decoration: none}
 </style>
 
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("[value=삭제]").click(function(){
		if(confirm("삭제하시겠습니까?")){
			let id = $(this).parent().parent().find("td:eq(1)").text();
			location.href = "${pageContext.request.contextPath}/delete?id="+id;
		}
		
	});
	
	
	$("[name=search]").submit(function(){
		if($("[name=keyField]").val() == "0"){
			alert("검색 필드를 선택하세요");
			return false;
		}
		
		if($("[name=keyWord]").val()==""){
			alert("검색할 단어를 입력하세요");
			$("[name=keyWord]").focus();
			return false;
		}
	});
})
</script>
</head>

<body>



<div style="text-align:center">
 <h1>[ 회원 정보 LIST ]</h1>
<table cellspacing="0">
  <tr>
    <th colspan="9" style="text-align:right">
      <a href="memberForm.html">[ 회원가입 ]</a>&nbsp;&nbsp;&nbsp;
      <a href="index.jsp">[ 새로고침 ]</a>&nbsp;&nbsp;&nbsp;
    </th>
  </tr>
  <tr bgColor="pink">
    <th>번호</th>
    <th>아이디</th>
    <th>비밀번호</th>
    <th>이름</th>
    <th>나이</th>
    <th>주소</th>
    <th>연락처</th>
    <th>가입일</th>
    <th>삭제</th>
  </tr>
  
  
  <c:choose>
  	<c:when test="${empty list}">
  		<tr><th colspan="9">검색된 정보가 없습니다</th></tr>  	
  	</c:when>
  	<c:otherwise>
  	<!-- scope에 저장된 정보를 forEach를 이용해서 출력 -->
  	<c:forEach items="${requestScope.list}" var="list" varStatus="varList">
  	<tr>
  		<td>${varList.count}</td>
  		<td><a href="${pageContext.request.contextPath}/read?id=${list.id}">${list.id}</a></td>
  		<td>${list.pwd}</td>
  		<td>${list.name}</td>
  		<td>${list.age}</td>
  		<td>${list.addr}</td>
  		<td>${list.phone}</td>
  		<td>
  			${list.joinDate} / 
  			<!-- DB에서 가져온 string을 날짜 형식으로 변환 -->
  			<fmt:parseDate value="${list.joinDate}" pattern="yyyy-MM-dd HH:mm:ss" var="fmtDate"/>
  			<fmt:formatDate value="${fmtDate}" pattern="yyyy-MM-dd"/>
  		</td>
  		<td><input type="button" value="삭제"></td>
  	</tr>
  	</c:forEach>
  	</c:otherwise>
  </c:choose>
 
</table>
<p>

<form name="search" action="${pageContext.request.contextPath}/search" method="post">
 <select name="keyField">
   <option value="0">--선택--</option>
   <option value="id">아이디</option>
   <option value="name">이름</option>
   <option value="addr">주소</option>
 </select>
 
<input type="text" name="keyWord"/>
<input type="submit" value="검색" />  

</form>
</div>

</body>
</html>




