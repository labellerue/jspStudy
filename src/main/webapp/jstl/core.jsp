<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.util.model.PageVo"%>
<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.UserServiceInf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>core.jsp</title>
</head>
<body>
<%-- core tag prefix(명명) : c   uri는 /jsp/가 있는 것으로 사용 -->
	<%-- jstl 태그 사용법 : <prefix:태그명/>  닫힘 태그는 별도로 필요 없음--%>
	<h2>core set</h2>
	<%--pageContext.setAttribute("attribute", "cSetValue"); 와 같은 것 --%>
	<c:set var="attribute" value="cSetValue" scope="request"/>
	
	el : ${attribute } <br/>
	pageContext : <%=pageContext.getAttribute("attribute") %> <br/>
	request : <%=request.getAttribute("attribute") %> <br/>
	
	<h2>core remove</h2>
	<%--pageContext.removeAttribute("attribute"); --%>
	<c:remove var="attribute"/>
	el : ${attribute } <br/>
	<%--별도의 null처리가 필요 없음 --%>
	
	<h2>core if : 단일 비교</h2>
	<c:set var="code" value="01" />
	<%-- code가 01이면 if 안쪽 코드가 실행 --%>
	
	<c:if test="${code == '01' }">
		if 실행
	</c:if>
	
	<h2>core choose : 실직적인 if 구문</h2>
	<c:choose>
		<c:when test="${code == '00' }"> 공공</c:when>
		<c:when test="${code == '01' }"> 공일</c:when>
		<c:when test="${code == '02' }"> 공이</c:when>
		<c:when test="${code == '03' }"> 공삼</c:when>
		<c:otherwise>else</c:otherwise>
	</c:choose>
	
	<h2>core forEach : 반복문</h2>
	<%--사용자 리스트 1페이지 조회 --%>
	<%
		UserServiceInf userService = new UserService();
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		request.setAttribute("userList", resultMap.get("pageList"));
		
	%>
	<%--items : 반복문 돌릴 것 --%>
	<table>
		<tr>
			<th>no.</th>
			<th>아이디</th>
			<th>이름</th>
			<th>생일</th>
		</tr>
	<c:forEach items="${userList }" var="user">
		<tr class="userClick">
			<td>${user.rnum }</td>
			<td>${user.userId }</td>
			<td>${user.name }</td>
			<td>${user.birth }</td>
		</tr>
	</c:forEach>
	</table>
	
	<h2>core forEach index loop</h2>
	<c:forEach begin="0" end="10" var="i" step="3"> 
		${i}&nbsp;&nbsp;&nbsp;
	</c:forEach>
	
	<h2>core forEach : map</h2>
	<%
		Map<String, String> strMap = new HashMap<String,String>();
		strMap.put("ranger1", "red");
		strMap.put("ranger2", "pink");
		strMap.put("ranger3", "yellow");
		strMap.put("ranger4", "green");
		
		request.setAttribute("strMap", strMap);
	%>
	<c:forEach items="${strMap}" var="map">
		${map.key } / ${map.value } <br/>
	</c:forEach>
	
</body>
</html>

























