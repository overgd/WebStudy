<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그 아웃</title>
</head>
<body>
<form action="logout.do" method="get">
안녕? ${sessionScope.ID }야<br/>
<input type="submit" value="로그 아웃"/>
</form>
</body>
</html>