<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>세션 로그인 체크</title>
</head>
<body>
<%

	String member = (String)session.getAttribute("MEMBER");
	
	if(member == null) {
		out.print("로그인되지 않음");
	}else {
		out.print("아이디가 "+member+"로 로그인 됨");
	}

%>	
</body>
</html>