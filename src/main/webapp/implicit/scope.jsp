<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scope.jsp</title>
</head>
<body>

	<h1>SCOPE (범위)</h1>
	<h3>scope.jsp -> scopeServlet -> scopeResult.jsp(dispatch)</h3>
	<h5>(값을 전송)   ->   (각 영역에 속성 저장)   ->   (각 영역에 저장된 값을 확인)</h5>
	
	<form action="/scopeServlet" method="post">	
	<input type="text" name="pageScope" value="james" /><br/>	
	<input type="text" name="requestScope" value="brown" /><br/>	
	<input type="text" name="sessionScope" value="sally" /><br/>	
	<input type="text" name="applicationScope" value="cony" /><br/>	
	<input type="submit" value="전송" /><br/>	
	</form>
</body>
</html>






