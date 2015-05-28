<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>연락처</title>
</head>
<body>
<%
	String dir = application.getRealPath("./WEB-INF/contacts");
	File dirs = new File(dir);
	String[] filenames = dirs.list();
%>
<h1>연락처</h1>
<%
	for(String str : filenames) {
		out.print("<a href='contactsreader.jsp?name="+str+"'>"+str+"</a><br/>");
	}
%>
</body>
</html>