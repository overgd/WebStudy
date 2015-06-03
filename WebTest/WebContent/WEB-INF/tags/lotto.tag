<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ tag body-content="empty" %>
<%@ tag import="java.util.*" %>
<%
	TreeSet<Integer> ts = new TreeSet<Integer>();
	for(int i = 0; ts.size() < 6; i++) {
		int rnd = (int)(Math.random()*45 +1);
		ts.add(rnd);
	}
	out.print(ts+"<br/>");
%>
