<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="length" type="java.lang.Integer" required="false"%>	<%--  required="false"  반드시 값을 입력하지 않아도 됨 --%>
<%@ attribute name="color" type="String" required="true"%> <%-- required="true"  반드시 값을 입력 해야함 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 이 태그는 톰캣이 자동으로 클래스를 만들어 줍니다. 그렇기 때문에 type에 java.lang 클래스는 명시하지 않아도 됩니다. --%>

<%--length가 설정되어있지 않으면 기본 20개로 설정 --%>
<c:set var="length" value="${length == null ? 20 : length}"/>

<font color="${color }">
<c:forEach begin='1' end='${length }'>=</c:forEach>
logging
<c:forEach begin='1' end='${length }'>=</c:forEach>
</font>
<br/>