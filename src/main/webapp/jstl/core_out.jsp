<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>core_out.jsp</title>
</head>
<body>
<% 
	request.setAttribute("userId", "brown");
	request.setAttribute("userNm", "cony");
%>

<label>userId: </label> <c:out value="${userId }"></c:out> <br/>
<label>user: </label> <c:out value="${user }" default="brownDefault"></c:out> <%--default 값이 없을 때 기본 값 설정 --%>


</body>
</html>



























