<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="bc" uri="http://taglib5.tld" %>
<fmt:setBundle basename="june02/intro"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><fmt:message key="TITLE"/></title>
</head>
<body>
<h2><fmt:message key="TITLE"/></h2>
<h3><fmt:message key="GREETING"/></h3>
<fmt:message key="BODY"/><br/>
<font size="2"><fmt:message key="COMPANY_NAME"/></font>
<bc:Hbar values="100,85,9" fgcolor="red" bgcolor="yellow" width="500" labels="one,two,three"/>
</body>
</html>