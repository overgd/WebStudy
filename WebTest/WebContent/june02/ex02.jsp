<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ex02" uri="http://june02.com" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="ex02.jsp" method="get">
<input type="radio" name="HUMAN" value="0"/> ����
<input type="radio" name="HUMAN" value="1"/> ����
<input type="radio" name="HUMAN" value="2"/> ��<br/><br/>
<input type="submit" value="����!"/>
</form>
<c:if test="${param.HUMAN != null }">
�ΰ� : 
<c:set var="HUM" value="${param.HUMAN}"/>
<c:choose>
<c:when test="${HUM == 0}">���� </c:when>
<c:when test="${HUM == 1}">���� </c:when>
<c:when test="${HUM == 2}">�� </c:when>
</c:choose>
<br/>
�� : 
<c:set var="COM" value="${ex02:game()}"/>
<c:choose>
<c:when test="${COM == 0}">���� </c:when>
<c:when test="${COM == 1}">���� </c:when>
<c:when test="${COM == 2}">�� </c:when>
</c:choose>
<br/>

<c:if test="${HUM == COM}">���</c:if>
<c:if test="${HUM-COM == -1 || HUM-COM == 2}">�� ��</c:if>
<c:if test="${COM-HUM == -1 || COM-HUM == 2}">�ΰ� ��</c:if>

</c:if>
</body>
</html>