<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<util:line/>
<util:newline color="red" size="10"/>
<util:random to="20" from="30"/>
<util:lotto/>
<util:box>안녕?</util:box>
<util:spade color="blue" size="20"/><br/>
<util:spade color="red" size="40"/><br/>
<util:june03 color="blue" size="30" height="12.0" weight="12.0"/>
<util:newbox color="red" size="2">
공사 중이다.<br/>
Bye~ Bye~ <br/>
</util:newbox>
<util:max num1="5" num2="3"/>
${result }
<util:anothermax var="re" num1="2" num2="3"/>
${re }
</body>
</html>