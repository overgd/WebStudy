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
<input type="radio" name="HUMAN" value="0"/> 가위
<input type="radio" name="HUMAN" value="1"/> 바위
<input type="radio" name="HUMAN" value="2"/> 보<br/><br/>
<input type="submit" value="결정!"/>
</form>
<c:if test="${param.HUMAN != null }">
인간 : 

<c:choose>
<c:when test="${param.HUMAN == 0}">가위 </c:when>
<c:when test="${param.HUMAN == 1}">바위 </c:when>
<c:when test="${param.HUMAN == 2}">보 </c:when>
</c:choose>
${param.HUMAN }
<br/>
컴 : 
<c:set var="COM" value="${ex02:game()}"/>
<c:choose>
<c:when test="${COM == 0}">가위 </c:when>
<c:when test="${COM == 1}">바위 </c:when>
<c:when test="${COM == 2}">보 </c:when>
</c:choose>
${COM }
<br/>

<c:if test="${param.HUMAN == COM}">비김</c:if>
<c:if test="${param.HUMAN-COM == -1 || param.HUMAN-COM == 2}">컴 승</c:if>
<c:if test="${COM-param.HUMAN == -1 || COM-param.HUMAN == 2}">인간 승</c:if>

</c:if>
</body>
</html>