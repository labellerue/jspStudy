<%@page import="kr.or.ddit.filter.RequestCounterFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>requestCount.jsp</title>
</head>
<body>

requestCount <br/>
접속횟수 <br/>
<c:forEach items="${uriMap }" var="map">
	${map.key } : ${map.value }
</c:forEach>

</body>
</html>