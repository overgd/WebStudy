<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.RESULT == 'OK' }">
	됐다 로그인!<br/>
	안녕? ${sessionScope.ID }
	</c:when>
	<c:otherwise>
	실패했다 로그인<br/>
	확인해라 아이디와 암호를
	</c:otherwise>
</c:choose>
</body>
</html>