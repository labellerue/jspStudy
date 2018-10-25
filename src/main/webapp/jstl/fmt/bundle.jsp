<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bundle</title>
</head>
<body>
<h2>기본 로케일</h2>
<fmt:bundle basename="kr.or.ddit.resource.msg.msg"> <%--properties의 위치 --%>
	<fmt:message key="hello"></fmt:message>
	<fmt:message key="visitor">
		<fmt:param value="brown"></fmt:param>
	</fmt:message>
</fmt:bundle>

<h2>변경 로케일: ja</h2>
<fmt:setLocale value="ja"/> <%-- 상위 bundle 설정이 쭉 이어지기 때문에 setLocale로 다시 잡아줍니다. --%>
<fmt:bundle basename="kr.or.ddit.resource.msg.msg"> <%--properties의 위치 --%>
	<fmt:message key="hello"></fmt:message>
	<fmt:message key="visitor">
		<fmt:param value="brown"></fmt:param>
	</fmt:message>
</fmt:bundle>

<h2>setBundle</h2>
<fmt:setLocale value="en"/> 
<fmt:setBundle basename="kr.or.ddit.resource.msg.msg" var="msg"/>  <%-- 변수 var를 사용하여 bundle에 변수로 사용하는 방법 --%>
	<fmt:message key="hello" bundle="${msg }"></fmt:message>
	<fmt:message key="visitor" bundle="${msg }">
		<fmt:param value="brown"></fmt:param>
	</fmt:message>





</body>
</html>















