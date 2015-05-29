<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
${parm.ID }
<%
	String id = request.getParameter("ID");
	String password = request.getParameter("PASS");
	String name = request.getParameter("NAME");
	String addr = request.getParameter("ADDR");
	String addr_de = request.getParameter("ADDRDE");
	String gender = request.getParameter("GENDER");
	String phone = request.getParameter("PHONE");
	
	String filename = id + ".txt";
	PrintWriter writer = null;
	String result = null;
	
	try {
		String path = application.getRealPath("./WEB-INF/user/"+filename);
		writer = new PrintWriter(path);
		writer.println(id);
		writer.println(password);
		writer.println(name);
		writer.println(addr);
		writer.println(addr_de);
		writer.println(gender);
		writer.println(phone);
		out.print(id+password+name+addr+addr_de+gender+phone);
		result = "OK";
	}
	catch(IOException ie) {
		result = "NOK";
	}
	finally {
		try {
			writer.close();
		}
		catch(Exception e) {
			
		}
	}
	response.sendRedirect("joinResult.jsp?RESULT="+result+"&ID="+id+"&NAME="+name);
	
%>
</body>
</html>