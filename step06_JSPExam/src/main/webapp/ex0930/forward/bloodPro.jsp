<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>이름, 혈액형 받기</h3>
<%
	//post 방식으로 전송되는 한글 데이터의 인코딩 처리 필요
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String blood = request.getParameter("blood");
	
	//System.out.println(name + " " + blood);
%>

<!-- forward는 request,response가 유지되면서 이동하기 때문에 jsp:param 없이도 불러온 다른 페이지에서도 request 받은 정보를 쓸 수 있다 -->
<jsp:forward page='<%=blood + ".jsp" %>'/>
</body>
</html>