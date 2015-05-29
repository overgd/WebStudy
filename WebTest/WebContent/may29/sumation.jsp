<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String n1 = request.getParameter("NUM1");
	String n2 = request.getParameter("NUM2");
	
	int num1 = Integer.parseInt(n1);
	int num2 = Integer.parseInt(n2);
	
	int sum = num1 + num2;
	
	request.setAttribute("SUM", sum);
	RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
	rd.forward(request, response);
%>
</body>
</html>