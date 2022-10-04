<%@page import="java.util.Date"%>
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
		session.setAttribute("id", dbID);
		session.setAttribute("name", userName);
		session.setAttribute("creationTime", new Date(session.getCreationTime()).toLocaleString());
		
		//쿠키에 아이디 저장 - savedId
		Cookie cookie = new Cookie("savedId", userId);
		cookie.setMaxAge(60*60*24*365);//1년
		cookie.setPath("/");
		response.addCookie(cookie);
		
		response.sendRedirect("LoginOk.jsp");//값을 따로 넘길 필요가 없다
		
	}else{
		out.println("<script>");
		out.println("alert('" + userName + "님 정보를 다시 확인해주세요');");
		out.println("history.back();");
		out.println("</script>");
	}
%>


</body>
</html>