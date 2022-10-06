<%@page import="ex1006.el.Product"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL(Expression Language) = 표현언어</h3>
<h4>
\${5} = ${5} <br>
\${5+2} = ${5+2} <br>
\${5*2} = ${5*2} <br>
\${5>3} = ${5>3} <br>
\${5 lt 10} = ${5 lt 10} <br>

\${"안녕"} = ${"안녕"} <br>
\${'반가워'} = ${'반가워'} <br>

\${5 gt 3 && 10 eq 10} = ${5 gt 3 && 10 eq 10} <br>
\${5 gt 3 and 10 eq 10} = ${5 gt 3 and 10 eq 10} <br>
\${5 gt 3 || 10 eq 10} = ${5 gt 3 || 10 eq 10} <br>

\${5 gt 3 ? "크다" : "작다"} = ${5 gt 3 ? "크다" : "작다"} <br>


<!-- 
	만약 http://localhost:9000/step09_EL_JSTL/ex01_ELTest.jsp?age=10&id=값
	요청이 된다고 가정하고 나이를 출력해보고 나이에 따른 성인, 미성년자를 출력한다
	
	만약 id가 없으면 guest, 있으면 id를 출력한다
-->
<%--
	int age = Integer.parseInt(request.getParameter("age"));
	if(age>18)
--%>

나이 : ${param.age}살<br>
구분 : ${param.age > 18 ? "성인" : "미성년자" }<br>

아이디 : ${param.id == null ? "guest" : param.id} <br>
아이디 : ${empty param.id ? "guest" : param.id} <br>
아이디 : ${param.id != null ? param.id : "guest"} <br>
아이디 : ${not empty param.id ? param.id : "guest"} <br>

<!-- 표현 언어에서 문자열 연결하는 방법 -->
<%-- 아이디 : ${param.id == null ? "guest" : param.id+"님"} <br> --%>
아이디 : ${param.id == null ? "guest" : param.id +="님"} <br>
아이디 : ${param.id == null ? "guest" : param.id.concat("님")} <hr>


Scope 영역(pageContext &lt; request &lt; session &lt; application) 있는 정보 가져오기<br>
<%
	//정보 저장
	request.setAttribute("id", "chunseryun");

	session.setAttribute("addr", "오리역");
	session.setAttribute("message", "표현언어 연습중");
	
	application.setAttribute("message", "오늘이 끄으읕");
	application.setAttribute("hobbys", Arrays.asList("등산","수영","낚시","골프"));
%>

아이디(request) : <%=request.getAttribute("id") %> / ${requestScope.id} / ${id} <br>

addr(session) : <%=session.getAttribute("addr") %> / ${requestScope.addr} <br>
message(session) : ${sessionScope.message} / ${message} <p>

message(application) : <%=application.getAttribute("message") %> / ${applicationScope.message} / ${message} <br>
hobbys(application) : ${applicationScope.hobbys} / ${hobbys} <hr>


자바 객체의 속성 및 메소드 접근<p>
<%--
	Product p = new Product();
	out.println(p.getCode());
--%>

<!-- 객체 생성 -->
<jsp:useBean id="p" class = "ex1006.el.Product"/>
상품코드 : <%=p.getCode() %> /${p.code}<br> <!-- p.getCode() 호출 -->
상품이름 : ${p.name}<br>
가격: ${p.price }<br>
수량: ${p.qty }<br>
총금액(가격*수량) : ${p.price * p.qty }원<br>

</h4>
</body>
</html>