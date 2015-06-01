<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>상품 정보</title>
</head>
<body>
<h2>상품 정보</h2>
상품 이름 : ${MY_ITEM.productName }<br/>
상품 가격 : ${MY_ITEM.productPrice }<br/>
상품 동물이름 : ${MY_ITEM.animals[0] }, ${MY_ITEM.animals[1] },
${MY_ITEM.animals[2] }<br/>
</body>
</html>