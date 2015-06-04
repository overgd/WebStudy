<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>찾았다! ${param.gu }의 맛집!</title>
</head>
<body>
<h1>찾았다! ${param.gu }의 맛집!</h1>
<ul>
<c:forEach var="name" items="${RESULT }">
<li>${name }</li>
</c:forEach>
</ul>
</body>
</html>