<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="g" uri="http://ex02.com" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>�Է��Ͻ� �ݾ��� ${param.GOLD}</h1>
5������ : ${g:goldnum(param.GOLD)[0] }<br/>
1������ : ${g:goldnum(param.GOLD)[1] }<br/>
5õ���� : ${g:goldnum(param.GOLD)[2] }<br/>
1õ���� : ${g:goldnum(param.GOLD)[3] }<br/>
5����� : ${g:goldnum(param.GOLD)[4] }<br/>
1����� : ${g:goldnum(param.GOLD)[5] }<br/>
5�ʿ��� : ${g:goldnum(param.GOLD)[6] }<br/>
1�ʿ��� : ${g:goldnum(param.GOLD)[7] }<br/>
5���� : ${g:goldnum(param.GOLD)[8] }<br/>
1���� : ${g:goldnum(param.GOLD)[9] }<br/>
</body>
</html>