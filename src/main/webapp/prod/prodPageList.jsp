<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<title>제품 정보 테이블</title>

<%--javascript and css stylesheet --%>
<%@include file="/common/basicLib.jsp"%>
<style type="text/css">
	.userClick {
		cursor : pointer;
	}
</style>
<script type="text/javascript">

	$(document).ready(function(){
		console.log("document.ready");
		
		//tr에 select (class="userClick")
		$(".prodClick").on("click", function(){
			console.log("prodClick");
			var prod_id = $(this).children()[1].innerText;
			
			$("#prod_id").val(prod_id);
			$("#frm").submit();
		});
		
	});
</script>

</head>
<!-- hidden으로 form을 넣는 것은 실무에서도 사용합니다! -->
<form action="/prodDetail" method="get" id="frm">
	<input type="hidden" id="prod_id" name="prod_id"/>
</form>
<body>

	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">제품</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<tr>
									<th>no.</th>
									<th>제품 아이디</th>
									<th>제품명</th>
									<th>제품그룹명</th>
									<th>제품등록일</th>
								</tr>

								<c:forEach items="${prodPageList }" var="prod" >
									<tr class="prodClick">
										<td>${prod.rnum }</td>
										<td>${prod.prod_id }</td>
										<td>${prod.prod_name }</td>
										<td>${prod.lprod_nm }</td>
										<td><fmt:formatDate value="${prod.prod_insdate }" pattern="yyyy/MM/dd" /></td>
									</tr>
								</c:forEach>
							</table>

						</div>
						<a class="btn btn-default pull-right" href="#">제품 등록</a>
						<!-- get으로 넘어갑니다. -->
						<div class="text-center">
							<ul class="pagination">
								<li><a href="/prodPageList?page=1&pageSize=10"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
									
								<c:forEach begin="1" end="${prodPageCnt}" var="pageNum">
									<li><a href="/prodPageList?page=${pageNum }&pageSize=10">${pageNum }</a></li>
								</c:forEach>

								<li>
								<a href="/prodPageList?page=${prodPageCnt }&pageSize=10" aria-label="Next"> 
								<span aria-hidden="true">&raquo;</span></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>