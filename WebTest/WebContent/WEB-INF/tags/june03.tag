<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ tag body-content="scriptless" %>
<%@ attribute name="color" %>
<%@ attribute name="size" type="java.lang.Integer"%>
<%@ attribute name="height" type="java.lang.Double"%>
<%@ attribute name="weight" type="java.lang.Double"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<font color="${color }">
<%
if(color != null && size != null){
	
	int rnd = (int)(Math.random()*4+1);
	String shpae = "";
	
	switch(rnd) {
		
		case 1:
			shpae = "��";
			break;
		case 2:
			shpae = "��";
			break;
		case 3:
			shpae = "��";
			break;
		case 4:
			shpae = "��";
			break;
	}
	for(int i = 0; i < size; i++) {
		out.print(shpae);
	}
}
%>

</font>