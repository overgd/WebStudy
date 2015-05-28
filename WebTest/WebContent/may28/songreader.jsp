<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String filename = request.getParameter("subject");
	filename = new String(filename.getBytes("ISO-8859-1"), "EUC-KR");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>
<%
	out.println(filename);
%>
</title>
</head>
<body>
<%
	BufferedReader reader = null;
	try {
		String filepath = application.getRealPath("./WEB-INF/lyrics/"+filename);
		reader = new BufferedReader(new FileReader(filepath));
		while (true) {
			String str = reader.readLine();
			if(str == null) {
				break;
			}
			out.print(str+"<br/>");
		}
	}
	catch(FileNotFoundException fnfe) {
		out.print("파일 없음");
	}
	catch(IOException ioe) {
		out.print("파일을 읽을 수 없음");
	}
	finally {
		try{
			reader.close();
		}
		catch(Exception e) {
			
		}
	}
%>
</body>
</html>