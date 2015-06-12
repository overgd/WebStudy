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
<c:if test="${RESULT == 'FAIL'}">
<script type="text/javascript">
alert("암호가 틀렸습니다!");
</script>
</c:if>
<c:if test="${! empty RESULT }">
	<script type="text/javascript">
	alert("변경되지 않았습니다!");
	location.href="bbs_update?id=${id}";
	</script>
</c:if>
<c:if test="${ empty RESULT }">
	<script type="text/javascript">
	alert("변경되었습니다.");
	location.href="bbs_update?id=${id}";
	</script>
</c:if>
</body>
</html>