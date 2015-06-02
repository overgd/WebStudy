<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JSTL Example</title>
</head>
<body>
<c:set var="num1" value="7"/> <!-- ���� ���� -->
<c:set var="num2" value="9"/>
<c:set var="result" value="${num1 * num2 }"/>
${num1 }�� ${num2 }�� ���� ${result }�Դϴ�.

<c:if test="${num1 > num2 }">
${num1 }�� Ů�ϴ�.
</c:if>
<c:if test="${num2 > num1 }">
${num2 }�� Ů�ϴ�.
</c:if>

<c:choose>
<c:when test="${num1 == 7 }">�ȳ�?</c:when>
<c:when test="${num2 == 9 }">�ݰ�</c:when>
<c:otherwise>�����մϴ�.</c:otherwise>
</c:choose>

<c:forEach var="count" begin="1" end="10">
<br/>${count }
</c:forEach>

<c:forEach var="count" begin="1" end="10" step="2">
<br/>${count }
</c:forEach>

<c:forEach var="cnt" begin="1" end="5">
<br/><font size="${cnt }">Ŀ����~</font>
</c:forEach>

<c:set var="CODE" value="80012" scope="request"/>
<c:set var="NAME" value="�½�����" scope="request"/>
<c:set var="PRICE" value="15000" scope="request"/>

</body>
</html>