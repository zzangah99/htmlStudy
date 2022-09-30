<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	
	String dbID = "chun";
	String dbPW = "1111";
	
	String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPwd");
	String userName = request.getParameter("userName");
	
	//request 받은 변수는 null이 들어올 가능성이 있기 때문에 equals()의 인수로 넣어야 nullPointerException 발생을 방지할 수 있다
	if(dbID.equals(userId) && dbPW.equals(userPwd)){
		response.sendRedirect("LoginOk.jsp?userName="+ URLEncoder.encode(userName, "UTF-8"));
		
		//forward 방식
		//request.getRequestDispatcher("LoginOk.jsp").forward(request, response);
	}else{
		%>
		<script type="text/javascript">
			alert("<%=userName%>님 아이디 또는 비번을 확인해주세요");
			<%-- alert(<%=userName%> + "님 아이디 또는 비번을 확인해주세요");  이건 alert(천세륜 + "님 아이디~"); 로 나와서 안 된다 --%>
			
			//location.href="LoginForm.html";
			history.back();	//뒤로가기. 기존에 작성했던 부분이 남아있다
		</script>
		<%
		
		//script는 정적 요소이고 java는 동적요소라 먼저 WAS로 이동되어 스크립트보다 먼저 실행되기 때문에 위의 script 코드와 만날 수 없다
		//response.sendRedirect("LoginForm.html");
	}
%>


</body>
</html>