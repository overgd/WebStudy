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

	String user = request.getParameter("ID");
	String password = request.getParameter("PWD");
	
	if(user.equals(password)) {
		session.setAttribute("MEMBER", user);
		session.setMaxInactiveInterval(100);
		out.print("로그인 성공");
	}else {
		out.print("로그인 실패");
	}
	
%>
</body>
</html>