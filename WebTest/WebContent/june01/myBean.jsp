<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="cus" class="june01.CustomInfo" scope="request"/>
�̸� : <jsp:getProperty property="name" name="cus"/><br/>
���� : <jsp:getProperty property="gender" name="cus"/><br/>
���� : <jsp:getProperty property="age" name="cus"/><br/>
�ּ� : <jsp:getProperty property="addr" name="cus"/><br/>
</body>
</html>