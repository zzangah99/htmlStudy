<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- jsp�� �ѱ� ���ڵ��� �� �Ǳ� ������ contentType, pageEncoding = "EUC-KR" or "UTF-8" �� �� �־���� �Ѵ� -->    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>JSP �����ϱ�</h1>
<%
	//java ����
	//���������̹Ƿ� �ʱ�ȭ �ʼ�(���� ���⼭ �ۼ��� java �ڵ�� �ڵ� �����Ǵ� servlet���� service �޼ҵ� �ȿ� ���� ������ ���������� �ȴ�)
	String name = "õ����";
	int age = 24;
	
	//�ܼ����
	System.out.println("�� ��� ��µ���?");
%>
<h3>
	�̸�: <%=name%> <br>
	����: <%=age %> ��<br>
</h3>
<%
	String message = "�ű��ϳ�";
	List<String> list = Arrays.asList("���","����","����","����","�౸");
	
	//�������� ���
	out.println("message " + message +"<br>");
	out.println("<h4 style='color:green'>��� : " + list + "</h4>");
%>

<hr>
�̸� : <%=name %><br>
�̸� : <%=this.name%><br>
�Լ� ȣ�� : <%=this.test() %>
	
<%!
	//�������� ����, �޼ҵ� ����
	//���� ������ ���� ����,�޼ҵ��̱� ������ servlet�� ������ java ���Ͽ��� service �޼ҵ� ���� �ƴ϶� ���ο� ����, �޼ҵ�� ����
	String name;
	String phone;
	
	public String test(){
		System.out.println("test() ȣ���");
		return "����ִ�";
	}
%>
</body>
</html>