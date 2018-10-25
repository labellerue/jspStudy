<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>core_import</title>
</head>
<body>

<h2>times tables jstl</h2>
<c:import url="timesTables.jsp">
	<c:param name="number" value="5"></c:param>  <%--파라미터를 timesTables.jsp로 보냄 --%>
</c:import>

<h2>naver search</h2>
<c:import url="https://search.naver.com/search.naver">
	<c:param name="query" value="html5"></c:param>   <%--url에 파라미터 key= query :: value= html5를 주었을 때 결과 --%>
</c:import>




</body>
</html>



















