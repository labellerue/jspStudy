<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>requestResult.jsp</title>
</head>
<body>
	<h1>requestResult.jsp</h1>
	
	<h2>parameter</h2>
	userId : <%=request.getParameter("userId") %> <br/>
	name : <%=request.getParameter("name") %> <br/>
	 
	<% UserVo userVo = (UserVo)session.getAttribute("userVo"); %>
	userId :<%=userVo.getUserId() %><br/>
	name : 	<%=userVo.getName() %><br/>
	alias : <%=userVo.getAlias() %><br/>
	birth:  <%=userVo.getBirth() %>
</body>
</html>













