<%@tag import="org.apache.jasper.runtime.JspContextWrapper"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.Connection"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="code" type="String" required="true"%>
<%-- attribute로 선언한 name은 스크립틀릿에서 문자열 타입의 변수가 됩니다. --%>

code: ${code } <br/>

<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try {
		//1. 드라이버 연결
		Class.forName("oracle.jdbc.driver.OracleDriver"); //얘를 찾아 클래스로 생성시켜 놔라

		//2. 커넥션 얻기
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "pc02", "java"); //아이피주소, 계정, pw

		//3. 구문객체(SQL문장 넘겨받기) 얻기
		stmt = conn.createStatement();
		
		//String code = (String)jspContext.getAttribute("code");
				
		StringBuffer sql = new StringBuffer();
		sql.append(" Select * From prod ");
		sql.append(" Where prod_lgu = '" + code + "'"); 							// ${code}
		
		//쿼리문 확인
		System.out.println("SQL 문제있니?" + sql);

		//쿼리문 실행
		rs = stmt.executeQuery(sql.toString());
		
out.write("<select>");

		while (rs.next()) {
	%>
	<option value='<%=rs.getString("prod_id")%>'><%=rs.getString("prod_name")%></option>
	<%
		}
out.write("</select>");


	} catch (Exception e) {
		System.out.println("code.tag - 오류발생: " + e);
		out.println("code.tag - 오류발생: " + e);

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
