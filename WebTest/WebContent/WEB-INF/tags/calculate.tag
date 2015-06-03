<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ tag body-content="scriptless" %>
<%@ attribute name="start" type="java.lang.Integer"%>
<%@ attribute name="end" type="java.lang.Integer"%>
<%@ attribute name="var" required="true" rtexprvalue="false"%>
<%@ variable name-from-attribute="var" alias="result" variable-class="java.lang.Integer" scope="NESTED"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	for(int i = start; i <= end ;i++) {
		%>
		<c:set var="result" value="<%= i %>"/>
		<jsp:doBody/>
		<%
	}
%>