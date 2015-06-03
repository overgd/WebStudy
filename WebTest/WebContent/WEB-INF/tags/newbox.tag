<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ tag body-content="scriptless" %>
<%@ attribute name="color" %>
<%@ attribute name="size" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>
<table border="1">
	<tr>
		<td>
			<font color="${color }" size="${size }">
			<util:june03 color="red" size="5">
			<jsp:doBody/>
			</util:june03>
			</font>
		</td>
	</tr>
</table>