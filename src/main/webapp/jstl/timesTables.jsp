<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl/timesTables.jsp</title>
<style type="text/css">
	td {
	border: 1px solid white; 
	color: white;
	background-color: #BCA1D6;
	}
</style>
</head>
<body>

<table>
	<c:forEach begin="1" end="9" var="gob">
	<tr>
		<c:forEach begin="2" end="${param.number }" var="dan">
			<td>${dan } * ${gob } = ${dan * gob}</td>
		</c:forEach>
	</tr>
	</c:forEach>
</table>
	
</body>
</html>