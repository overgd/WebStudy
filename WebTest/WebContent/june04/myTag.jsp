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
잘가
</mytag:mybox>
<mytag:replace oldword1="hello" newword1="잘가" oldword2="bye" newword2="반가워">
hello 친구들아 hello hello<br/>
bye bye 친구들아<br/>
hello 친구들아 hello hello<br/>
</mytag:replace>
<mytag:mymin var="result" num1="12" num2="23"/>
${result }<br/>

<mytag:list>
<mytag:row>
자동차
</mytag:row>
<mytag:row>
비행기
</mytag:row>
</mytag:list>

<mytag:newlist var1="*" var2="%">
<mytag:newrow>
후루루루루루루
</mytag:newrow>
<mytag:newrow>
호로로로로롤
</mytag:newrow>
</mytag:newlist>

</body>
</html>