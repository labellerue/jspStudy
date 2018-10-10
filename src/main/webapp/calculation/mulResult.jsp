<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sumResult.jsp</title>
</head>
<body>
	<h3>계산 값 확인</h3>
	결과값: <%=(Long)session.getAttribute("mulResult") %>
</body>
</html>