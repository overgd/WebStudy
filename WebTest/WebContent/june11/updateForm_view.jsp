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
<script type="text/javascript">
function validate(form) {
	if(form.title.value == "") {
		alert("제목을 입력하세요!");
		return false;
	}else if(form.writername.value == "") {
		alert("작성자를 입력하세요!");
		return false;
	}else if(form.content.value == "") {
		alert("내용을 입력하세요!");
		return false;
	}else if(form.password.value == "") {
		alert("암호를 입력하세요!");
		return false;
	}
}
</script>
<c:if test="${!empty writing }">
<form action="update.do" method="post" enctype="multipart/form-data" onsubmit="return validate(this)">
<input type="hidden" name="id" value="${writing.writingid }"/>
<table width="100%" border="1" cellpadding="1">
<tr>
	<td>글제목</td>
	<td><input type="text" name="title" size="40" value="${writing.title }"/>
	</td>
</tr>
<tr>
	<td>작성자</td>
	<td><input type="text" name="writername" size="10" value="${writing.writername }"/>
	</td>
</tr>
<tr>
	<td>이메일</td>
	<td><input type="text" name="email" size="10" value="${writing.email }"/>
	</td>
</tr>
<tr>
	<td>암호</td>
	<td><input type="password" name="password" size="15"/>
	</td>
</tr>
<tr>
	<td>이미지</td>
	<td><img alt="그림" src="../upload_files/thumb.${writing.imagename }" border="0">
	<input type="file" name="imagename" size="20" value="${writing.imagename }"/>
	</td>
</tr>
<tr>
	<td>글내용</td>
	<td><textarea name="content" rows="8" cols="40">${writing.content }</textarea>
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="수정"/>
		<input type="button" value="취소" onclick="javascript:history.go(-1)"/>
	</td>
</tr>
</table>
</form>
</c:if>
</body>
</html>