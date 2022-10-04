<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String cookieSavedId = "";

	//쿠키에 저장된 아이디가 있는지 확인 - savedId
	Cookie [] cookies = request.getCookies();
	
	//만약 있으면 폼에 출력한다
	if(cookies != null){
		for(Cookie co : cookies){
			if(co.getName().equals("savedId")) {
				cookieSavedId = co.getValue();
				break;
			}
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 회원 인증 Page</h2>

<form method="get" action="LoginPro.jsp">
  ID : <input type="text" name="userId" value="<%=cookieSavedId%>"/><br/>
  PWD : <input type="password" name="userPwd" /></br/>
  NAME : <input type="text" name="userName" /></br/>
  
  <input type="submit" value="로그인" />
</form>

</body>
</html>