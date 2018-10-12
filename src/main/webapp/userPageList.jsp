<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<UserVo> userList = (List<UserVo>)request.getAttribute("pageList");
%>

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

<title>회원 정보 테이블</title>

<%--javascript and css stylesheet --%>
<%@include file="/common/basicLib.jsp"%>
<style type="text/css">
	.userClick {
		cursor : pointer;
	}
	
	
</style>
<script type="text/javascript">

	function al(user){
		document.location="/userDetail?userId="+user;
	}
	
	$(document).ready(function(){
		console.log("document.ready");
		
		
		
		//tr에 select (class="userClick")
		$(".userClick").on("click", function(){
			console.log("userClick");
			var userId = $(this).children()[1].innerText;
			
			$("#userId").val(userId);
			$("#frm").submit();
		});
		
	});
</script>

</head>
<!-- hidden으로 form을 넣는 것은 실무에서도 사용합니다! -->
<form action="/userDetail" method="get" id="frm">
	<input type="hidden" id="userId" name="userId"/>
</form>
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
							<table class="table table-striped table-hover">
								<tr>
									<th>no.</th>
									<th>아이디</th>
									<th>이름</th>
									<th>생일</th>
								</tr>
								<%
									if (userList != null) {
										for (int i = 0; i < userList.size(); i++) {
								%>
								
								<!-- <tr onclick="javascript:alert('<%=userList.get(i).getUserId()%>')"> -->
								<!--<tr onclick="al('<%=userList.get(i).getUserId()%>')">-->
								<tr class="userClick">
									<td><%=userList.get(i).getRnum()%></td>
									<td><%=userList.get(i).getUserId()%></td>
									<td><%=userList.get(i).getName()%></td>
									<td><%=userList.get(i).getBirth().toString().substring(4, 10)
											+ " "
											+ userList.get(i).getBirth().toString().substring(24)%></td>
								</tr>
								<%
										}
									}
								%>
							</table>
						</div>
						<a class="btn btn-default pull-right" href="/userForm" >사용자 등록</a><!-- get으로 넘어갑니다. -->
						<div class="text-center">
							<ul class="pagination">
								<li><a href="/userPageList?page=1&pageSize=10" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
								<%
									int pageCnt = (Integer) request.getAttribute("pageCnt");
									for (int p = 1; p <= pageCnt; p++) {
								%>
								<li><a href="/userPageList?page=<%=p%>&pageSize=10"><%=p%></a></li>
								<%
									}
								%>
								<li><a href="/userPageList?page=<%=pageCnt%>&pageSize=10" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>