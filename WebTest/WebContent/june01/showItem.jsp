<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ǰ ����</title>
</head>
<body>
<h2>��ǰ ����</h2>
��ǰ �̸� : ${MY_ITEM.productName }<br/>
��ǰ ���� : ${MY_ITEM.productPrice }<br/>
��ǰ �����̸� : ${MY_ITEM.animals[0] }, ${MY_ITEM.animals[1] },
${MY_ITEM.animals[2] }<br/>
</body>
</html>