<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% Cookie[] cookies = request.getCookies(); %>
<%! 
	private String getValue(Cookie[] c, String n) {

		if(c == null) return null;
		
		for(Cookie cookie : c) {
			if(cookie.getName().equals(n)) {
				return cookie.getValue();
			}
		}
		
		return null;
			
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	if(getValue(cookies, "ID") != null) {
		out.print("아이디 "+getValue(cookies, "ID")+"로 로그인 됨");
	}else {
		out.print("로그인이 안됨!");	
	}
%>
</body>
</html>