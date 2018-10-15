<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	UserVo userDetail = (UserVo)request.getAttribute("userDetail");
	System.out.println(userDetail);
	//프로필 이미지를 설정하지 않은 경우
	if(userDetail.getProfile() == null){
		userDetail.setProfile("/profile/noimage.png");
	}
%>

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
								<img src="<%=userDetail.getProfile() %>" width="216" />
							</div>
						</div>
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
							<div class="col-sm-10">
								<label class="control-label" ><%=userDetail.getUserId() %></label>
							</div>
						</div>

						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">이름</label>
							<div class="col-sm-10">
								<label class="control-label"><%=userDetail.getName() %></label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">주소</label>
							<div class="col-sm-10">
								<label class="control-label"><%=userDetail.getAddr1() %></label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">상세주소</label>
							<div class="col-sm-10">
								<label class="control-label"><%=userDetail.getAddr2() %></label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">우편번호</label>
							<div class="col-sm-10">
								<label class="control-label"><%=userDetail.getZip() %></label>
							</div>
						</div>

						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">생년월일</label>
							<div class="col-sm-10">
								<label class="control-label"><%=userDetail.getBirth() %></label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">이메일</label>
							<div class="col-sm-10">
								<label class="control-label"><%=userDetail.getEmail() %></label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">연락처</label>
							<div class="col-sm-10">
								<label class="control-label"><%=userDetail.getTel() %></label>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<a class="btn btn-default" href="/userUpdate?userId=<%=userDetail.getUserId() %>" >정보 수정</a>
							</div>
						</div>
					</form>
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>