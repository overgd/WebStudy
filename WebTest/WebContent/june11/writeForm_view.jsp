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
		alert("������ �Է��ϼ���!");
		return false;
	}else if(form.writername.value == "") {
		alert("�ۼ��ڸ� �Է��ϼ���!");
		return false;
	}else if(form.imagename.value == "") {
		alert("�̹����� �����ϼ���!");
		return false;
	}else if(form.content.value == "") {
		alert("������ �Է��ϼ���!");
		return false;
	}else if(form.password.value == "") {
		alert("��ȣ�� �Է��ϼ���!");
		return false;
	}
}
</script>
<form action="write.do" method="post" enctype="multipart/form-data" onsubmit="return validate(this)">
<table width="100%" border="1" cellpadding="1">
<tr>
	<td>����</td>
	<td><input type="text" name="title" size="40"/>
	</td>
</tr>
<tr>
	<td>�ۼ���</td>
	<td><input type="text" name="writername" size="10"/>
	</td>
</tr>
<tr>
	<td>�̸���</td>
	<td><input type="text" name="email" size="10"/>
	</td>
</tr>
<tr>
	<td>��ȣ</td>
	<td><input type="password" name="password" size="15"/>
	</td>
</tr>
<tr>
	<td>�̹���</td>
	<td><input type="file" name="imagename" size="20"/>
	</td>
</tr>
<tr>
	<td>�۳���</td>
	<td><textarea name="content" rows="8" cols="40"></textarea>
	</td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="�� �ø���"/></td>
</tr>
</table>
</form>
</body>
</html>