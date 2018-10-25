<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="date" value="<%=new Date() %>" />
date : ${date } <br/>
formatDate : <fmt:formatDate value="${date }" />  <br/>
formatDate pattern : <fmt:formatDate value="${date }" pattern="yyyy-MM-dd"/>  <br/>
date : <fmt:formatDate value="${date }" type="date" />  <br/>
date(full) : <fmt:formatDate value="${date }" type="date" dateStyle="full"/>  <br/>
date(medium) : <fmt:formatDate value="${date }" type="date" dateStyle="medium"/>  <br/>
date(short) : <fmt:formatDate value="${date }" type="date" dateStyle="short"/>  <br/>
time : <fmt:formatDate value="${date }" type="time"/>  <br/>

<c:set var="parseDate" value="2018-10-25" />
<fmt:parseDate var="dt" value="${parseDate }" pattern="yyyy-MM-dd" /> 
parseDate :  ${dt } ,
<fmt:formatDate value="${dt }" dateStyle="medium"/><br/>

</body>
</html>

















