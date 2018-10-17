<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- el scope 확인 예제 --%>
<%--
	page : jsp 페이지에서만 유효한 속성
	request : 요청이 끝날때 까지 유효한 속성
	session : session이 만료되기 전까지 유효한 속성
				(세션이 만료되는 시점: server 종료시/ tomcat 설정에 따라
									  session.invalidate()
									  사용자가 server timeout 시간안에 요청을 하지 않았을 때
	application : was에 하나 존재(서버 종료 전까지 유효)
	
 --%>
 <%
 	pageContext.setAttribute("attribute", "pageContextAttribute");
 	request.setAttribute("attribute", "requestAttribute");
 	session.setAttribute("attribute", "sessionAttribute");
 	application.setAttribute("attribute", "applicationAttribute");
 	
 %>
 
 pageContext : <%=pageContext.getAttribute("attribute") %> <br/>
 request : <%=request.getAttribute("attribute") %>  <br/>
 session : <%=session.getAttribute("attribute") %>  <br/>
 application : <%=application.getAttribute("attribute") %>  <br/>
 
 <h2>el</h2>
 <!-- 범위가 작은
  것부터 가져옴.. 그러니 key 값을 같은 이름으로 주지 마세요 -->
 el attribute : ${attribute} <br/>
 <!-- 지정해주면 그에 따른 값이 나오지만 이름은 다르게 주는게 바람직합니다. -->
 el attribute : ${applicationScope.attribute} <br/>
 el request attribute : ${requestScope.attribute} <br/>
 

</body>
</html>












