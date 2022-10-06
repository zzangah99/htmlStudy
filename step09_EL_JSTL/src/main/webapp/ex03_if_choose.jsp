<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		alert("???");
		
		//job이 전송되었다면 전송된 value 값 선택
		if("${param.job}" != "" && "${param.job}" != "0" ){
			$("[name=job]").val("${param.job}");
		}
	})
</script>
</head>
<body>
<h3>JSTL - &lt;c:if> 와 &lt;c:choose</h3>
<!-- 
	만약 요청할 때 http://localhost:9000/step09_EL_JSTL/ex03_if_choose.jsp?age=값
	된다면 age의 값이 있으면 "당신의 나이는 ~살입니다." 출력
	
	* 나이가 18보다 크면 성인입니다 / 미성년자는 서비스를 이용할 수 없습니다
 -->
<c:if test="${not empty param.age }" var="result">
	<h2 style="color:red">당신의 나이는 ${param.age }살 입니다.</h2>
</c:if>

결과 : ${result}

<hr>
<c:choose>
	<c:when test="${param.age>18 }">
		<h4>나이가 18보다 크면 성인입니다. 자유롭게 이용하세요</h4>
	</c:when>
	<c:otherwise>
		<h4>${param.age}살은 미성년자이므로 서비스가 제한됩니다</h4>
	</c:otherwise>
</c:choose>

<hr>
<form action="ex03_if_choose.jsp">
	이름: <input type="text" name="name" value="${param.name}"><br>
	선택: 
		<select name="job">
			<option value="0">--선택--</option>
			<option value="개발자">개발자</option>
			<option value="디자이너">디자이너</option>
			<option value="DBA">DBA</option>
			<option value="기획자">기획자</option>
		</select>
		<p>
		<input type="submit" value="전송하기">
</form>

<!-- 
	1. 만약 name과 job이 전송된다면 "~님 직업은 ~입니다." 출력
	2. job의 종류에 따른 메시지를 출력
			개발자 - ??? , 디자이너 - ???
	3. 값이 전송되었다면 전송된 값으로 폼에 출력되게 한다
-->

<hr>
<c:if test="${not empty param.name and not empty param.job}" var="result2"> 
	<h4>${param.name}님 직업은 ${param.job=="0" ? "없습니다" : param.job+="입니다"}</h4>
	
	<c:choose>
		<c:when test="${param.job == '개발자'}">
			<h4>개발자입니다</h4>
		</c:when>
		<c:when test="${param.job == '디자이너'}">
			<h4>디자이너입니다</h4>
		</c:when>
		<c:when test="${param.job == 'DBA'}">
			<h4>DBA입니다</h4>
		</c:when>
		<c:when test="${param.job == '기획자'}">
			<h4>기획자입니다</h4>
		</c:when>
		<c:otherwise>
			<h4>백수입니다</h4>
		</c:otherwise>
	</c:choose>
</c:if>

<hr>
${applicationScope.list }

</body>
</html>