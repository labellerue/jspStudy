<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>requestInfo</title>
</head>
<body>
	request.getLocalAddr() : 						<%=request.getLocalAddr() 			%>	<br/> 
	request.getRemoteAddr() 클라이언트IP:			<%=request.getRemoteAddr() 			%>	<br/>
	request.getContentLength() 요청한 정보의 길이: 	<%=request.getContentLength() 		%>	<br/>
	request.getCharacterEncoding() : 				<%=request.getCharacterEncoding() 	%>	<br/>
	request.getContentType() : 						<%=request.getContentType() 		%>	<br/>
	request.getProtocol() :							<%=request.getProtocol() 			%>	<br/>
	request.getMethod() :							<%=request.getMethod() 				%>	<br/>
	request.getRequestURI() 요청 주소:				<%=request.getRequestURI() 			%>	<br/>
	request.getContextPath() 요청 위치:				<%=request.getContextPath() 		%>	<br/>
	request.getServerName() :						<%=request.getServerName() 			%>	<br/>
	request.getServerPort() :						<%=request.getServerPort() 			%>	<br/>

</body>
</html>