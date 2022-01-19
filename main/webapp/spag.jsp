<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%pageContext.setAttribute("result", 345);  %>
<!-- ---------------------------------------- -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${requestScope.result} 입니다.<br >
	${names[1]}<br >
	${notice.Test2}<br >
	${result}<br >
	${param.num}<br >
	${header.Cookie}
</body>
</html>