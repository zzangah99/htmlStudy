<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{width:1000px; height:600px; border:1px gray solid; border-collapse: collapse;}
	td{border: 1px gray solid; text-align: center;}
	
	table tr:first-child{height:100px;}
	table tr:last-child{height:80px;}
	
	iframe {width:100%; height:420px; border:none;}
	
	h3 {background-color: orange;}
	
	table tr:nth-child(2) > td:first-child {width:200px;}
	
	a{text-decoration: none;}
	a:link{color:blue;}
	
</style>
</head>

<body>
<table>
	<tr>
		<td colspan="2">
			<jsp:include page="top.jsp" />
		</td>
	</tr>
	<tr>
		<td>
			<iframe src="left.jsp" name="left" ></iframe>
		</td>
		<td>
			<iframe src="center.jsp" name="center" ></iframe>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<jsp:include page="footer.jsp" />
		</td>
	</tr>

</table>

</body>
</html>