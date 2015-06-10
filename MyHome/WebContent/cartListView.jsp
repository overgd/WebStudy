<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ٱ���~</title>
</head>
<body>
<h3>��ٱ��� ����</h3>
<c:choose>
	<c:when test="${CART_LIST == null || CART_LIST.size <= 0 }">
	��ٱ��ϰ� �����.
	</c:when>
	
	<c:otherwise>
	
	<table border="1">
		<tr>
			<td width="80">��ǰ��ȣ</td>
			<td width="250">��ǰ�̸�</td>
			<td width="80">��ǰ����</td>
			<td width="50">����</td>
			<td width="100">���űݾ�</td>
			<td width="80">����/����</td>
		</tr>
		<c:choose>
			<c:when test="${START != null }">
				<c:forEach var="cnt" begin="${START }" end="${CART_LIST.size - 1 }">
					<tr>
						<td>${CART_LIST.code[cnt] }</td>
						<td>${CART_LIST.name[cnt] }</td>
						<td>${CART_LIST.price[cnt] }</td>
						
						<form action="modify_cart" method="post">
						<input type="hidden" name="CODE" value="${CART_LIST.code[cnt]}"/>
						
						<td>
						<input type="text" name="NUMBER" size="3" value="${CART_LIST.number[cnt] }"/>
						</td>
						
						<td>${CART_LIST.price[cnt] * CART_LIST.number[cnt] }��</td>
						
						<td>
						<input type="submit" name="BTNS" value="����"/>
						<input type="submit" name="BTNS" value="����"/>
						</td>
						</form>
		
					</tr>	
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${CART_LIST.size > 5 }">
						<c:set var="loopcount" value="4"/>
					</c:when>
					<c:otherwise>
						<c:set var="loopcount" value="${CART_LIST.size - 1 }"/>
					</c:otherwise>
				</c:choose>
				<c:forEach var="cnt" begin="0" end="${loopcount }">
					<tr>
						<td>${CART_LIST.code[cnt] }</td>
						<td>${CART_LIST.name[cnt] }</td>
						<td>${CART_LIST.price[cnt] }</td>
						
						<form action="modify_cart" method="post">
						<input type="hidden" name="CODE" value="${CART_LIST.code[cnt]}"/>
						
						<td>
						<input type="text" name="NUMBER" size="3" value="${CART_LIST.number[cnt] }"/>
						</td>
						
						<td>${CART_LIST.price[cnt] * CART_LIST.number[cnt] }��</td>
						
						<td>
						<input type="submit" name="BTNS" value="����"/>
						<input type="submit" name="BTNS" value="����"/>
						</td>
						</form>
		
					</tr>	
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
	<c:forEach var="cnt" begin="1" end="${CART_LIST.pageNum }">
	<a href="cart_list?PAGE_NO=${cnt }">${cnt }</a>
	</c:forEach>
	
	<form action="" method="post">
	��ٱ��� �Ѿ� : ${CART_LIST.totalAmount }��
	<input type="hidden" name="TOTAL" value="${CART_LIST.totalAmount }"/>
	<input type="submit" value="�����ϱ�"/>
	</form>
	
	</c:otherwise>
</c:choose>
</body>
</html>