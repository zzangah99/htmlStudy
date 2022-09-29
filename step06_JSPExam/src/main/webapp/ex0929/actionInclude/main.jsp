<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>action include Test</h2>
<!-- 이 방식으로 파일을 가져오면 서블릿이 각각 만들어진다 -->
<jsp:include page="top.jsp"/>

<%
	String addr = "서울 - Seoul";

	//request 인코딩 변경(한글 깨짐 방지)
	request.setCharacterEncoding("UTF-8");
%>
인코딩 : <%=request.getCharacterEncoding() %><br>

<hr>
<h3>여기는 메인입니다</h3>

<hr>
<!-- footer.jsp로 id, addr 정보를 전송한다 -->
<jsp:include page="footer.jsp">
	<jsp:param value="seryun" name="id"/>
	<jsp:param value="<%=addr%>" name="addr"/>
</jsp:include>

</body>
</html>