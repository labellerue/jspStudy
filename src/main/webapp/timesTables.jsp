<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td {border: 1px solid skyblue;}
</style>
</head>
<body>
	<table>
	<%for(int dan=2 ; dan<10 ; dan++){%>
		<tr>
			<%for(int gob=1 ; gob<10 ; gob++){%>
			<td><%=dan%> * <%=gob%> = <%=dan*gob%></td>
			<%}%>
		</tr>
		<%}%>
	</table>
	
</body>
</html>