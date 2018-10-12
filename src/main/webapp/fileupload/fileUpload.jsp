<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 파일 전송은 post method만 가능 -->
<!-- get / fileUpload : fileUpload.jsp 요청
	post / fileUplaod : form 전송 처리
 -->
<form action="/fileUpload" method="post" enctype="multipart/form-data">
	<input type="text" name="userId" value="brown" /><br/>
	<input type="file" name="profile" /><br/>
	<input type="submit" value="전송" /> <br/>
	
	<%=application.getRealPath("/profile") %> <!-- 톰캣 배포되는 경로 -->
</form>

</body>
</html>