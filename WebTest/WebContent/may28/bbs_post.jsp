<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글쓰기 결과</title>
</head>
<body>
<h2>글쓰기 결과</h2>
<%
	request.setCharacterEncoding("EUC-KR");
	String name = request.getParameter("WRITER");
	String title = request.getParameter("TITLE");
	String content = request.getParameter("CONTENT");
	Date today = new Date();
	Long time = today.getTime();
	String filename = time + ".txt";
	PrintWriter writer = null;
	String result = null;
	
	try {
		String path = application.getRealPath("./WEB-INF/bbs/"+filename);
		writer = new PrintWriter(path);
		writer.printf("제목 : %s %n", title);
		writer.printf("글쓴이 : %s %n", name);
		writer.printf(content);
		out.print("저장된 위치 : ["+path+"]<br/>");	
		result ="OK";
	}
	catch(IOException ie) {
		try{
			result = "NOK";
		}
		finally {
			try {
				writer.close();
			}
			catch(Exception e) {
				
			}
		}
	}
	response.sendRedirect("bbs_result.jsp?RESULT="+result);
%>
</body>
</html>