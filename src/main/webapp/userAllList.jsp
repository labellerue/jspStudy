<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% List<UserVo> userList = (List<UserVo>)request.getAttribute("userList"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%--javascript and css stylesheet --%>
<%@include file="/common/basicLib.jsp"%>

</head>
<body>

	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>

					<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
						<div class="row">
							<div class="col-sm-8 blog-main">
								<h2 class="sub-header">사용자</h2>
								<div class="table-responsive">
									<table class="table table-striped">
										<tr>
											<th>no.</th>
											<th>아이디</th>
											<th>이름</th>
											<th>생일</th>
										</tr>
<%
							if(userList != null){
										for (int i = 0; i < userList.size(); i++) {
%>
										<tr>
											<td><%=i + 1%></td>
											<td><%=userList.get(i).getUserId()%></td>
											<td><%=userList.get(i).getName()%></td>
											<td><%=userList.get(i).getBirth().toString().substring(4,10)+" "+userList.get(i).getBirth().toString().substring(24)%></td>
										</tr>
<%
										}
							}
%>
									</table>
								</div>
								<a class="btn btn-default pull-right">사용자 등록</a>
								<div class="text-center">
									<ul class="pagination">
										<li><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

</body>
</html>
