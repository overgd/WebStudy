<%@page import="java.io.FileReader"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String filename = request.getParameter("name");
	filename = new String(filename.getBytes("ISO-8859-1"), "EUC-KR");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>
<%=filename%>님의 연락처
</title>
</head>
<body>
<%
	BufferedReader reader = null;
	
	try {
		String path = application.getRealPath("./WEB-INF/contacts/"+filename);
		reader = new BufferedReader(new FileReader(path));
		
		while(true) {
			String str = reader.readLine();
			if(str == null){
				break;
			}
			out.print(str);
		}
	}
	catch(FileNotFoundException fnfe) {
		out.print("존재하지 않는 이름입니다.");
	}
	finally {
		try{
			reader.close();
		}
		catch(Exception e){
			
		}
	}

%>
</body>
</html>