<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	int[] sub = new int[3];
	String[] subject = new String[3];
	String name = request.getParameter("NAME");
	
	int total_sum = 0;
	int total_avg = 0;
	
	for(int i = 0; i < 3; i++) {
		subject[i] = request.getParameter("SUB"+(i+1));
		sub[i] = Integer.parseInt(subject[i]);
		total_sum = total_sum + sub[i];
	}	
	total_avg = total_sum/sub.length;
	
	request.setAttribute("NAME", name);
	request.setAttribute("SUM", total_sum);
	request.setAttribute("AVG", total_avg);
	
	RequestDispatcher rd = request.getRequestDispatcher("ex2_res.jsp");
	rd.forward(request, response);
%>
</body>
</html>