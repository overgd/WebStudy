<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="m" uri="http://my_functions.com" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
������ �ֻ��� ���� : ${m:dice() }<br/> 
�ֻ��� ���� : ${m:dicegame() }<br/>
${param.MIN}���� ${param.MAX}������ ���� : ${m:rangeRandom(param.MIN, param.MAX) }<br/>
�ζ� ��ȣ : ${m:getLotto() }<br/>
${param.SU }�� ��Ʈ�� : ${m:square(param.SU) }
</body> 
</html>