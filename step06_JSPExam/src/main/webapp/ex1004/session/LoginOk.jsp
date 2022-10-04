<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//캐시 저장 하지 않음
	response.setHeader("Cache-Control", "no-strore");

	//세션의 유효시간 설정
	session.setMaxInactiveInterval(30);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>0
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script> 
<script type="text/javascript">
	$(function(){
		$("#logout").click(function(){
			//모든 세션 정보 삭제
			<%-- <%session.invalidate();%> --%>
			//이 페이지가 로드될 때 클릭되기도 전에 WAS에서 먼저 실행된다
			//로그아웃 기능을 하는 페이지로 이동해서 모든 세션 삭제
			if(confirm("로그아웃 하시겠습니까?")){
				location.href="logout.jsp";
			}
		});
	})
</script>
</head>
<body>
<%-- <%= %> = ${} --%>
\${pageContext.request.contextPath} = ${pageContext.request.contextPath};


<%
	if(session.getAttribute("id") != null){
		%>
		<h3>
			<%=session.getAttribute("id")%>님 로그인 중<br>
			접속 시간 [<%=session.getAttribute("creationTime")%>]
		</h3>
		<img src="imgs/poster.jpg"><p>
		
		<a href="#" id="logout">로그아웃</a>
		
		<% 

	}else{
		%>
		<script>
		alert("로그인 하고 이용하세요");
		location.href="LoginForm.html";
		</script>
		<%
	}
%>

</body>
</html>