<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>factorial.jsp</title>
</head>
<%!
	public String msg(){
		return "hello world";
	}

	// factorial method 선언
	public int factorial(int num){
		if(num == 0){
			return 1;
		}else if(num == 1){
			return 1;
		}
		return num*factorial(num-1);
	}
%>
<body>
	<%=msg()%>
	<br/>
	<%--factorial method 호출(loop를 통해 factorial 8까지 출력) --%>
	<%for(int i=1 ; i<9 ; i++){ %>
		factorial(<%=i%>) = <%=factorial(i)%>
		<br/>
	<%} %>

</body>
</html>