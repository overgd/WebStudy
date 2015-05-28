<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String str = request.getParameter("RESULT");
	if(str.equals("OK")) {
		out.print("성공적으로 글을 저장했습니다.");
	}
	else {
		out.print("저장실패");
	}
%>

</body>
</html>