<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� Ȩ</title>
</head>
<body>
<h1 align="center">���� ȯ���Ѵ� �ʸ�</h1>
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
	<a href="template.jsp?BODY=Intro.html">�Ұ��Ѵ� ���� ����</a><br/>
	<a href="template.jsp?BODY=bbsinput.html">���� �Խ��� ��</a><br/>
	<a href="bbs_list">�д´� �Խ��� ��</a><br/>
	<a href="">���� ��ǰ��</a><br/>
	<a href="">�� ��ǰ �ٱ���</a><br/>
	</td>
	<td height="650" width="650" valign="top">
	<jsp:include page="${param.BODY }"/>
	</td>
</tr>
</table>
</body>
</html>