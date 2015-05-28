<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
수신한 이름 : <%= request.getParameter("NAME")%><br/>
수신한 주소 : <%= request.getParameter("ADDR") %><br/>
수신한 취미 : <%
	String[] hobby = request.getParameterValues("hobby");
	for(int i = 0; i < hobby.length ; i++) {
		out.println(hobby[i]+"<br/>");
	}
%>
</body>
</html>