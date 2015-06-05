<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>나의 홈</title>
</head>
<body>
<h1 align="center">나는 환영한다 너를</h1>
<table border="1" cellpadding="10" align="center">
<tr>
	<td>
	<c:choose>
		<c:when test="${sessionScope.ID == null }">
			<jsp:include page="loginForm.html"></jsp:include><br/>
		</c:when>
		<c:otherwise>
			<jsp:include page="logoutForm.jsp"></jsp:include><br/>
		</c:otherwise>
	</c:choose>
	<a href="template.jsp?BODY=Intro.html">소개한다 나의 가족</a><br/>
	<a href="template.jsp?BODY=bbsinput.html">쓴다 게시판 글</a><br/>
	<a href="bbs_list">읽는다 게시판 글</a><br/>
	<a href="">정보 상품의</a><br/>
	<a href="">고른 상품 바구니</a><br/>
	</td>
	<td height="650" width="650" valign="top">
	<jsp:include page="${param.BODY }"/>
	</td>
</tr>
</table>
</body>
</html>