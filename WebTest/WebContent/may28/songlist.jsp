<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>나의 노래방</title>
</head>
<body>
<%
	String dir = application.getRealPath("./WEB-INF/lyrics");
	File dirs = new File(dir);
	String[] filenames = dirs.list();
%>
<h2>노래 제목 목록</h2>
<ul>
<%
	for(String str : filenames) {
		out.print("<li><a href='songreader.jsp?subject="+str+"'>"+str+"</a></li>");
	}
%>
</ul>
</body>
</html>