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
<h4 align="center">�Խ��� �� ���</h4>
<table border="1">
	<tr>
		<td width="40">�۹�ȣ</td>
		<td width="300">������</td>
		<td width="80">�ۼ���</td>
	</tr>
	<c:forEach var="cnt" begin="0" end="${BBS_LIST.listSize - 1 }">
	<tr>
		<td>${BBS_LIST.seqNo[cnt] }</td>
		<td><a href="bbs_Item?NUM=${BBS_LIST.seqNo[cnt] }">${BBS_LIST.title[cnt] }</a></td>
		<td>${BBS_LIST.writer[cnt] }</td>
	</tr>
	</c:forEach>
</table>
<c:if test="${! BBS_LIST.firstPage }">
<a href="bbs_list?FIRST_NO=${BBS_LIST.seqNo[0] }">���� ������</a>
</c:if>
<c:forEach var="cnt" begin="1" end="${BBS_LIST.pageNum }">
<a href="bbs_list?PAGE_NO=${cnt }">${cnt }</a>
</c:forEach>
<c:if test="${! BBS_LIST.lastPage }">
<a href="bbs_list?LAST_NO=${BBS_LIST.seqNo[BBS_LIST.listSize - 1] }">���� ������</a>
</c:if>
</body>
</html>














