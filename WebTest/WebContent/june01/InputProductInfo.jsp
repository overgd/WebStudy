<%@ page import="june01.ProductInfo" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>자바빈 생성</title>
</head>
<body>

<%

	ProductInfo product = new ProductInfo();
	product.setName("디지탈 텔레비전");
	product.setPrice(10000);
	
	String[] pets = {"강아지", "고양이", "물고기"};
	product.setAnimals(pets);
	
	request.setAttribute("MY_ITEM", product);
	RequestDispatcher rd = request.getRequestDispatcher("showItem.jsp");
	rd.forward(request, response);

%>

</body>
</html>