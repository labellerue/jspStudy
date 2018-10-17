<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
<c:if test="${userDetail.profile == '' }">
<c:set var="userDetail" property="profile" value="/profile/noimage.png">
</c:set>
</c:if>
 --%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>제품 상세정보 테이블</title>

<%--javascript and css stylesheet --%>
<%@include file="/common/basicLib.jsp"%>
</head>

<body>
	<!-- top bar -->
	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<!-- left bar -->
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<!-- form -->
					<form class="form-horizontal" role="form" method="get" action="/userUpdate" >
						<div class="form-group">
						
							<label for="userNm" class="col-sm-2 control-label">제품아이디</label>
							<div class="col-sm-10">
								<label class="control-label" >${prodDetail.prod_id }</label>
							</div>
						</div>

						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">제품명</label>
							<div class="col-sm-10">
								<label class="control-label">${prodDetail.prod_name }</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">제품그룹명</label>
							<div class="col-sm-10">
								<label class="control-label">${prodDetail.lprod_nm }</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">바이어이름</label>
							<div class="col-sm-10">
								<label class="control-label">${prodDetail.buyer_name }</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">바이어 이메일</label>
							<div class="col-sm-10">
								<label class="control-label">${prodDetail.buyer_mail }</label>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<a class="btn btn-default" href="/userUpdate?userId=${prodDetail.prod_id }" >정보 수정</a>
							</div>
						</div>
					</form>
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>