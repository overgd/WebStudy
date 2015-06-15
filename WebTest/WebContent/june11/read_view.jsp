<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<c:if test="${empty writing }">
존재하지 않습니다.
</c:if>
<c:if test="${!empty writing }">
<table width="100%" border="1" cellpadding="1">
<tr>
	<td>제목</td>
	<td>${writing.title }</td>
</tr>
<tr>
	<td>작성자</td>
	<td>${writing.writername }</td>
</tr>
<tr>
	<td colspan="2"><img alt="그림" src="../upload_files/${writing.imagename }" border="0"></td>
</tr>
<tr>
	<td>글내용</td>
	<td>${writing.content }</td>
</tr>
<tr>
	<td colspan="2">
		<a href="javascript:goReply()">[답글]</a>
		<a href="javascript:goModify()">[수정]</a>
		<a href="javascript:goDelete()">[삭제]</a>
		<a href="bbs_list">[목록]</a>
	</td>
</tr>
</table>
writing.groupid:${writing.groupid },parentid:${writing.writingid }
</c:if>
<script type="text/javascript">
function goDelete(){
	document.move.action="bbs_delete";
	document.move.submit();
}
function goModify(){
	document.move.action="bbs_update";
	document.move.submit();
}
function goReply(){
	document.move.action="bbs_reply";
	document.move.submit();
}
</script>
<form name="move" method="post">
<input type="hidden" name="id" value="${writing.writingid }"/>
<input type="hidden" name="parentid" value="${writing.writingid }"/>
<input type="hidden" name="groupid" value="${writing.groupid }"/>
</form>
</body>
</html>