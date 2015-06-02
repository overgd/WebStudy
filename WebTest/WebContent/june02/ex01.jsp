<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EX01</title>
</head>
<body>
<form action="ex01.jsp" method="get" >
<input type="text" name="SU"/>
<input type="submit" value="구구단!" />
</form>
구구단을 외자!<br/>
<c:if test="${param.SU != null }">
${param.SU }단<br/>
<c:forEach var="cnt" begin="1" end="9">
${param.SU } X ${cnt } = ${param.SU*cnt}<br/>
</c:forEach>
</c:if>
</body>
</html>