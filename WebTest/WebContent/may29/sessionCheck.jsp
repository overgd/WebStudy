<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� �α��� üũ</title>
</head>
<body>
<%

	String member = (String)session.getAttribute("MEMBER");
	
	if(member == null) {
		out.print("�α��ε��� ����");
	}else {
		out.print("���̵� "+member+"�� �α��� ��");
	}

%>	
</body>
</html>