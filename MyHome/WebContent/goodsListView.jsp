<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>상품 목록</title>
</head>
<body>
<h4 align="center">상품 목록</h4>
<table border="1" align="center">
	<tr>
		<td width="70">코드번호</td>
		<td width="300">상품이름</td>
		<td width="80">가격</td>
		<td width="70">장바구니</td>
	</tr>
	<c:forEach var="cnt" begin="0" end="${GOODS_LIST.listSize - 1 }">
	<tr>
		<td>${GOODS_LIST.codeList[cnt] }</td>
		<td><a href="goods_item?NUM=${GOODS_LIST.codeList[cnt] }">${GOODS_LIST.nameList[cnt] }</a></td>
		<td>${GOODS_LIST.priceList[cnt]}</td>
		<td><a href="#" onclick="window.open('add_item_to_cart?CODE=${GOODS_LIST.codeList[cnt] }','장바구니','width=150 height=150').focus()">담기</a></td>
	</tr>
	</c:forEach>
</table>
<c:if test="${! GOODS_LIST.firstPage }">
<a href="goods_list?FIRST_NO=${GOODS_LIST.codeList[0] }">이전 페이지</a>
</c:if>
<c:forEach var="cnt" begin="1" end="${GOODS_LIST.pageNum }">
<a href="goods_list?PAGE_NO=${cnt }">${cnt }</a>
</c:forEach>
<c:if test="${! GOODS_LIST.lastPage }">
<a href="goods_list?LAST_NO=${GOODS_LIST.codeList[GOODS_LIST.listSize - 1] }">다음 페이지</a>
</c:if>
</body>
</html>