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

<title>회원 정보 테이블</title>

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
							<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
							<div class="col-sm-10">
							<c:choose>
								<c:when test="${userDetail.profile == null }"><img src="/profile/noimage.png" width="216" /></c:when>
								<c:otherwise><img src="${userDetail.profile }" width="216" /></c:otherwise>
							</c:choose>
								
							</div>
						</div>
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
							<div class="col-sm-10">
								<label class="control-label" >${userDetail.userId }</label>
							</div>
						</div>

						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">이름</label>
							<div class="col-sm-10">
								<label class="control-label">${userDetail.name }</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">주소</label>
							<div class="col-sm-10">
								<label class="control-label">${userDetail.addr1 }</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">상세주소</label>
							<div class="col-sm-10">
								<label class="control-label">${userDetail.addr2 }</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">우편번호</label>
							<div class="col-sm-10">
								<label class="control-label">${userDetail.zip }</label>
							</div>
						</div>

						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">생년월일</label>
							<div class="col-sm-10">
								<label class="control-label"><fmt:formatDate value="${userDetail.birth }" pattern="yyyy-MM-dd" /></label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">이메일</label>
							<div class="col-sm-10">
								<label class="control-label">${userDetail.email }</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">연락처</label>
							<div class="col-sm-10">
								<label class="control-label">${userDetail.tel }</label>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<a class="btn btn-default" href="/userUpdate?userId=${userDetail.userId }" >정보 수정</a>
							</div>
						</div>
					</form>
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>