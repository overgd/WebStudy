<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ tag body-content="empty" %>
<%@ attribute name="color" %>
<%@ attribute name="size" type="java.lang.Integer"%>
<font color="${color }">
<%
	for(int i = 0; i < size; i++) {
		out.print("¢¼");
	}
%>
</font>