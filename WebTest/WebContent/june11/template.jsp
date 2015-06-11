<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>이미지 갤러리</title>
</head>
<body>
<table width="100%" border="1" cellpadding="2">
	<tr>
		<td>
		<jsp:include page="top.jsp"/>
		</td>
	</tr>
	<tr>
		<td>
		<jsp:include page="${param.CONTENTPAGE }"/>
		</td>
	</tr>
	<tr>
		<td>
		<jsp:include page="bottom.jsp"/>
		</td>
	</tr>
</table>
</body>
</html>