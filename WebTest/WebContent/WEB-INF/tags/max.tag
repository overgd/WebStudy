<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ tag body-content="empty"%>
<%@ attribute name="num1" type="java.lang.Integer" %>
<%@ attribute name="num2" type="java.lang.Integer" %>
<%@ variable name-given="result" variable-class="java.lang.Integer" scope="AT_END"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int max = 0;
	if(num1 >= num2) {
		max = num1;
	}
	else {
		max = num2;
	}
%>
<c:set var="result" value="<%= max %>"/>