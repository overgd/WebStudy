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
	Cookie cLogin = new Cookie("LOGIN", "");
	Cookie iLogin = new Cookie("ID", "");
	cLogin.setMaxAge(0);
	iLogin.setMaxAge(0);
	
	response.addCookie(cLogin);
	response.addCookie(iLogin);
	out.print("로그아웃!");
%>
</body>
</html>