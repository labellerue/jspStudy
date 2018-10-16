<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>lotto.jsp</title>
</head>
<body>

<%
	int random = (int)(Math.random()*19+1);
	String lottoStd = null;

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try {
		// 1. JDBC 드라이버 로딩 ==> Class.forName()을 이용한다.
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 해당 DB에 접속하기 
		//		==> DriverManager.getConnection()을 이용하고
		//		==> 접속이 성공하면 Connection객체가 생성된다.
		String username = "pc02";
		String password = "java";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(url, username, password);
		
		stmt = conn.createStatement();
		
		StringBuffer sql = new StringBuffer();
		sql.append(" Select * From jspstudent ");
		sql.append(" Where no = " + random );

		//쿼리문 확인
		System.out.println("SQL 문제있니?"+sql);
		
		rs = stmt.executeQuery(sql.toString());

		if (rs.next()) {
			System.out.println("결과값은 " + rs.getString("name"));

			lottoStd = rs.getString("name");

		}

	} catch (Exception e) {
		System.out.println("lotto.jsp - 오류발생: " + e);
		out.println("lotto.jsp - 오류발생: " + e);

	} finally {
		// 6. 사용했던 자원을 반납한다.
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
%>
	<canvas id="myCanvas" width="200" height="200" >
	</canvas>
	

<script type="text/javascript">
	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");

	ctx.beginPath();
	ctx.arc(100, 100, 100, 0, 2 * Math.PI);
	ctx.stroke();
	
	ctx.font = "60px Arial";
	ctx.fillStyle = "skyblue";
	ctx.fillText('<%=lottoStd%>',10, 118);
</script>



</body>
</html>



















