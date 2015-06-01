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
생성된 주사위 난수 : ${m:dice() }<br/> 
주사위 게임 : ${m:dicegame() }<br/>
${param.MIN}부터 ${param.MAX}까지의 난수 : ${m:rangeRandom(param.MIN, param.MAX) }<br/>
로또 번호 : ${m:getLotto() }<br/>
${param.SU }의 루트값 : ${m:square(param.SU) }
</body> 
</html>