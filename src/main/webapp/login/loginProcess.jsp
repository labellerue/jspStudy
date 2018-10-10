<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginProcess.jsp</title>
</head>
<body>

<%--login.jsp에서 전송한 파라미터: userId, password --%>
<%--request parameter 관련 메소드
	1. getParameter(String name)
	2. getParameterValues(String name)
	3. getParameterMap()
	4. getParameterNames()
 --%>
 
 	<%
 	String[] userIdValues = request.getParameterValues("userId");
 
 	Map<String, String[]> requestMap = request.getParameterMap();
 	
 	Enumeration<String> paramNames = request.getParameterNames();
 	while(paramNames.hasMoreElements()){
 		String paramName = paramNames.nextElement();
 		System.out.println("parameterName : " + paramName);
 	}
	%>
	
	
	request.getParameter("userId") : <%=request.getParameter("userId") %> <br/>
	request.getParameterValues("userId") : 
	<% for(String str : userIdValues) {
		out.write(str + "<br/>");
	}	%>
	request.getParameter("password") : <%=request.getParameter("password") %> <br/>
	
	
	<h3>getParameterMap()</h3>
	<%for(String str: requestMap.get("userId")){%>
		ID : <%=str %><br/>
	<%}%>
	<%for(String str: requestMap.get("password")){ %>
		PW : <%=str %><br/>
	<%} %>
	




</body>
</html>























