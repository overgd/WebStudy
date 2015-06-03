<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ tag body-content="empty" %>
<%@ attribute name="from" type="java.lang.Integer" required="true" %>
<%@ attribute name="to" type="java.lang.Integer" required="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
	int result = (int)(Math.random()*(to-from+1) + from);
	out.print(result+"<br/>");
%>