<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>
</head>
<body>
<%--
	브라우저 주소줄에 입력한 경우: get
	form 태그의 method 속성: get/post
 --%>
 
	<form action="/dditLogin" method="post">
<%--	
	<form action="/loginServlet" method="post">
	<form action="/login/loginProcess.jsp" method="post">
--%>
	사용자 아이디: <input type="text" name="userId" value="brown"/><br/>
<!-- 사용자 아이디 : <input type="text" name="userId" value="day"/><br/>  -->
	사용자 비밀번호 : <input type="password" name="password" value="pass1234"/><br/>
	<input type="submit" value="로그인" />
	</form>
	
	
	
</body>
</html>