<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>timezone.jsp</title>
</head>
<body>

<c:set var="now" value="<%=new Date() %>" />
format date(한국) : <fmt:formatDate value="${now }" type="both"/> <br/>

<fmt:timeZone value="Asia/Bangkok">
format date(방콕) : <fmt:formatDate value="${now }" type="both"/> <br/>
</fmt:timeZone>








</body>
</html>






