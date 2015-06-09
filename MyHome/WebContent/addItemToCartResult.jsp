<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>장바구니 결과</title>
</head>
<body>
<h2>장바구니!</h2>
장바구니에 ${param.CODE }상품을 ${param.ITEM_NUM }개 담았다!<br/><br/>
<a href="#" onclick="self.close()">닫기</a>
</body>
</html>