<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sumInput</title>
</head>
<body>
	<h3>계산기</h3>
	<form action="/sumCalculation" method="post">
	<input type="text" name="start" /> <br/>
	<input type="text" name="end" /> <br/>
	<input type="submit" value="계산하기" />
	</form>
</body>
</html>