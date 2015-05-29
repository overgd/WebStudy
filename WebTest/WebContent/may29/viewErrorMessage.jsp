<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>오류 발생</title>
</head>
<body>
<!-- 에러페이지 우선권 가지게 하기 -->
<% response.setStatus(200); %> <!-- 브라우저의 에러페이지 루틴이 disable된다. -->
요청을 처리할 수 없습니다. <br/>
</body>
</html>