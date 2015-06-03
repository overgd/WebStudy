<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ tag body-content="scriptless" %>
<%@ attribute name="dan" type="java.lang.Integer"%>
<%@ attribute name="gugu" required="true" rtexprvalue="false"%>
<%@ variable name-from-attribute="gugu" alias="gu" variable-class="java.lang.Integer" scope="NESTED"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	for(int i = 1; i <= 9; i++) {
		%>
		<c:set var="gu" value="<%= dan*i %>"/>
		<jsp:doBody/>
		<%
	}

%>

