<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="mytag" uri="http://mytag.com" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<mytag:line color="red" size="20"/><br/>
<mytag:gugudan dan="4"/> 
<mytag:sum from="1" to="100"/>
<mytag:mybox>
�߰�
</mytag:mybox>
<mytag:replace oldword1="hello" newword1="�߰�" oldword2="bye" newword2="�ݰ���">
hello ģ����� hello hello<br/>
bye bye ģ�����<br/>
hello ģ����� hello hello<br/>
</mytag:replace>
<mytag:mymin num1="12" num2="23"/>
${result }
</body>
</html>