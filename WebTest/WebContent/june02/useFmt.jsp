<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>날짜와 시간, 숫자</title>
</head>
<body>
<c:set var="data" value="<%= new Date() %>"/>
[오늘의 날짜] <fmt:formatDate value="${data }"/><br/>
[지금 시간] <fmt:formatDate value="${data }" type="time"/><br/>
[s] <fmt:formatDate value="${data }" type="both" dateStyle="short" timeStyle="short"/><br/>
[m] <fmt:formatDate value="${data }" type="both" dateStyle="medium" timeStyle="medium"/><br/>
[l] <fmt:formatDate value="${data }" type="both" dateStyle="long" timeStyle="long"/><br/>
[f] <fmt:formatDate value="${data }" type="both" dateStyle="full" timeStyle="full"/><br/>
<fmt:formatNumber value="123456000" groupingUsed="true"></fmt:formatNumber><br/>
<fmt:formatNumber value="3.141592" pattern="#.##"/><br/>
<fmt:formatNumber value="100.356" pattern="#.00"/><br/>
<fmt:formatNumber value="3456777" type="currency"/><br/>
<%
	String timelist[] = TimeZone.getAvailableIDs();
	for(int cnt = 0; cnt < timelist.length; cnt++) {
	out.println(timelist[cnt] + "<br>");
	}
%>
<c:forTokens items="America" delims="">
<fmt:timeZone value="${WORLD }">
<fmt:formatDate value="${data }" type="both" dateStyle="full" timeStyle="full"/><br/>
</fmt:timeZone>
</c:forTokens>

</body>
</html>