<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>selectLang.jsp</title>
<script src="/js/jquery-3.3.1.min.js"></script>

<c:set var="lang" value="${param.lang == null ? 'ko' : param.lang}"/>

 <script type="text/javascript">
 	$(document).ready(function(){
 		
 		$("#lang").val("${lang}");
 		
 		$("#lang").on("change", function(){
 			$("#frm").submit();
 		});
 	});
 </script>
</head>
<body>
<%--
	1. lang 이라고 이름지어진 파라미터로 locale을 설정
	2. 만약 lang 파라미터가 없을 경우 ko를 기본 값으로 사용
	3. select box가 변경될 때 해당 언어로 페이지 재요청
	4. select box는 현재 요청된 lang 파라미터 언어값이 선택되어져 있어야함
		(lang 파라미터가 없을 경우 기본 값 ko)
		
	최초접속 : http://localhost:8081/jstl/fmt/selectLang.jsp
	그 이후 : select box를 변경하여 페이지 재요청
 --%>
 

<form action="selectLang.jsp" method="get" id="frm">
 <select id="lang" name="lang">
 	<option value="ko">한국어</option>
 	<option value="en">english</option>
 	<option value="ja">日本語</option>
 </select>
</form>
 
<fmt:setLocale value="${lang }" /> 
<fmt:bundle basename="kr.or.ddit.resource.msg.msg"> <%--properties의 위치 --%>
	<fmt:message key="hello"></fmt:message>
	<fmt:message key="visitor">
		<fmt:param value="brown"></fmt:param>
	</fmt:message>
</fmt:bundle>




</body>
</html>











