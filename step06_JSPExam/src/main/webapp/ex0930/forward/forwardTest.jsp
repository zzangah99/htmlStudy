<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>액션태그 - forward</h2>
<%
	int sum=0;
	for(int i=0; i<=10; i++){
		out.println(i + "<br>"); // 0 1 2 3 ... 으로 출력됨(html이므로 개행은 <br>로)
		//out.print(i); //01234... 로 출력됨
		sum += i;
	} 
	System.out.println("sum = "+sum);
	request.setCharacterEncoding("UTF-8");
	
	/* out.println("<script>");
	out.println("alert('되니?')");
	out.println("alert('글쎄~')");
	out.println("</script>");
	
	//out.print는 스크립트에서 바로 붙어서 나오기 때문에 여러 문장을 입력하려면 ; 까지 넣어야 한다
	out.print("<script>");
	out.print("alert('되니?');");
	out.print("alert('글쎄~');");
	out.print("</script>"); */
%>
<!-- 위 java가 실행됐지만 forward를 만나는 순간 화면은 forward 화면으로 바뀐다 -->
<jsp:forward page='forwardResult.jsp'>
	<jsp:param value="<%=sum %>" name="total"/>
	<jsp:param value="즐거운 주말" name="message"/>
</jsp:forward>

</body>
</html>