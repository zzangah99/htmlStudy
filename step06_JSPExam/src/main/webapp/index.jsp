<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- jsp는 한글 인코딩이 안 되기 때문에 contentType, pageEncoding = "EUC-KR" or "UTF-8" 을 꼭 넣어줘야 한다 -->    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>JSP 시작하기</h1>
<%
	//java 문법
	//지역변수이므로 초기화 필수(내가 여기서 작성한 java 코드는 자동 생성되는 servlet에서 service 메소드 안에 들어가기 때문에 지역변수가 된다)
	String name = "천세륜";
	int age = 24;
	
	//콘솔출력
	System.out.println("난 어디에 출력되지?");
%>
<h3>
	이름: <%=name%> <br>
	나이: <%=age %> 살<br>
</h3>
<%
	String message = "신기하네";
	List<String> list = Arrays.asList("등산","수영","낚시","골프","축구");
	
	//브라우저에 출력
	out.println("message " + message +"<br>");
	out.println("<h4 style='color:green'>취미 : " + list + "</h4>");
%>

<hr>
이름 : <%=name %><br>
이름 : <%=this.name%><br>
함수 호출 : <%=this.test() %>
	
<%!
	//전역변수 선언, 메소드 선언
	//내가 선언한 전역 변수,메소드이기 때문에 servlet이 생성한 java 파일에서 service 메소드 안이 아니라 새로운 변수, 메소드로 들어간다
	String name;
	String phone;
	
	public String test(){
		System.out.println("test() 호출됨");
		return "재미있다";
	}
%>
</body>
</html>