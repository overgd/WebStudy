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
	String id = request.getParameter("ID");
	String password = request.getParameter("PWD");
	
	if(id.equals(password)) {
		
		Cookie myLogin = new Cookie("LOGIN", "YES");
		Cookie myId = new Cookie("ID", id);
		myLogin.setMaxAge(100);//100초 유지
		myId.setMaxAge(100);
		
		response.addCookie(myLogin);
		response.addCookie(myId);
		
		out.print("로그인 성공");
	}
	else {
		out.print("로그인 실패");
	}
%>
</body>
</html>