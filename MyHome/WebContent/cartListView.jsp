<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>장바구니~</title>
</head>
<body>
<h3>장바구니 관리</h3>
<c:choose>
	<c:when test="${CART_LIST == null || CART_LIST.size <= 0 }">
	장바구니가 비었다.
	</c:when>
	
	<c:otherwise>
	
	<table border="1">
		<tr>
			<td width="80">상품번호</td>
			<td width="250">상품이름</td>
			<td width="80">상품가격</td>
			<td width="50">수량</td>
			<td width="100">구매금액</td>
			<td width="80">수정/삭제</td>
		</tr>
		
		<c:forEach var="cnt" begin="0" end="${CART_LIST.size - 1 }">
			<tr>
				<td>${CART_LIST.code[cnt] }</td>
				<td>${CART_LIST.name[cnt] }</td>
				<td>${CART_LIST.price[cnt] }</td>
				
				<form action="modify_cart" method="post">
				<input type="hidden" name="CODE" value="${CART_LIST.code[cnt]}"/>
				
				<td>
				<input type="text" name="NUMBER" size="3" value="${CART_LIST.number[cnt] }"/>
				</td>
				
				<td>${CART_LIST.price[cnt] * CART_LIST.number[cnt] }원</td>
				
				<td>
				<input type="submit" name="BTNS" value="수정"/>
				<input type="submit" name="BTNS" value="삭제"/>
				</td>
				</form>

			</tr>	
		</c:forEach>

	</table>
	
	<form action="" method="post">
	장바구니 총액 : ${CART_LIST.totalAmount }원
	<input type="hidden" name="TOTAL" value="${CART_LIST.totalAmount }"/>
	<input type="submit" value="결제하기"/>
	</form>
	
	</c:otherwise>
</c:choose>
</body>
</html>