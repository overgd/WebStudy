<%@ page import="june01.ex01" %>
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

	request.setCharacterEncoding("EUC-KR");

	ex01 info = new ex01();
	
	info.setName(request.getParameter("NAME"));
	info.setAddr(request.getParameter("ADDR"));
	
	String[] animals = request.getParameterValues("ANIMAL");
	info.setAnimals(animals);
	
	request.setAttribute("MY_INFO", info);
	RequestDispatcher rd = request.getRequestDispatcher("ex01_output.jsp");
	rd.forward(request, response);
	

%>
</body>
</html>