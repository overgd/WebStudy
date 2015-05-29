<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
학생 이름 : <%= request.getAttribute("NAME") %><br/>
점수 합: <%= request.getAttribute("SUM") %><br/>
점수 평균: <%= request.getAttribute("AVG") %><br/>
</body>
</html>