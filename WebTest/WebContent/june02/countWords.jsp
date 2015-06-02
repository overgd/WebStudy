<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("euc-kr"); %>
입력한 단어의 갯수!<br/><br/>
<c:set var="count" value="0"/>
<c:set var="contents" value="${param.CONTENT }"/>
<c:forTokens var="word" items="${contents }" delims=",. ">
${word }
<c:set var="count" value="${count+1 }"/>
<br/>
</c:forTokens>
단어의 갯수는 ${count }
</body>
</html>