<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--charset=UTF-8 는 utf-8로 보내겠다는 의미
    pageEncoding=UTF-8 는 이 작업 파일을 utf-8로 작업하겠다
--%>
<%-- 보안적인 측면으로 인해 외부에서 WEB-INF로 접근 불가능..webapp 내에 있지만 불가능  --%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>basic</title>
</head>
	
<%= session.getAttribute("nameAl") %>

<!-- 스크립틀릿 < % %> : 자바 코드 작성 -->
<!-- 표현식 < %= %> : 출력을 표현 -->

<%
	String msg = "first jsp";

	Date date = new Date();
	SimpleDateFormat smplD = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
	String nowDate = smplD.format(date);
%>
<body>
	hello, world
	<br/>
	<%= msg %>
	<br/>
	<%=nowDate %>
	
	
	
</body>
</html>

<!-- http://locahost:8081/basic.jsp -->