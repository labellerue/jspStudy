<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageContext.jsp</title>
</head>
<body>
<!-- 내장객체(implicit)
	: request, response, session, application, out, pageContext
 -->
 <%
 	request.equals(pageContext.getRequest());
 	response.equals(pageContext.getResponse());
 	session.equals(pageContext.getSession());
 	application.equals(pageContext.getServletContext());
 	out.equals(pageContext.getOut());
 	page.equals(pageContext.getPage());
 %>
 
 	request.equals(pageContext.getRequest()) :				<%=request.equals(pageContext.getRequest()) %> <br/>
 	response.equals(pageContext.getResponse()) : 			<%=response.equals(pageContext.getResponse()) %> <br/>
 	session.equals(pageContext.getSession()) : 				<%=session.equals(pageContext.getSession()) %> <br/>
 	application.equals(pageContext.getServletContext()) :	<%=application.equals(pageContext.getServletContext()) %> <br/>
 	out.equals(pageContext.getOut()) : 						<%=out.equals(pageContext.getOut()) %> <br/>
 	page.equals(pageContext.getPage()) : 					<%=page.equals(pageContext.getPage()) %>

</body>
</html>