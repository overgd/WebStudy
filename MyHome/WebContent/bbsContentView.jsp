<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>게시글</h3>
글 번호 : ${ITEM.seqNo }<br/>
글 제목 : ${ITEM.title }<br/>
글 작성자 : ${ITEM.writer }<br/>
글 내용<br/>
${ITEM.content }
</body>
</html>