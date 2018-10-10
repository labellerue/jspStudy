<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="en">
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Welcome to Carroty</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">
    <form class="form-signin" action="/dditLogin" method="post">
      <img class="" src="/image/Carroty_c.jpg" alt="" width="200" >
      <br/><br/>
      <h1 class="h3 mb-3 font-weight-normal">Welcome to Carroty</h1>
      <label for="inputEmail" class="sr-only">ID</label>
      <!-- ID 입력박스 -->
      <input type="text" name="userId" id="inputEmail" class="form-control" placeholder="your ID" required autofocus value="brown">
      <label for="inputPassword" class="sr-only">Password</label>
      <!-- PW 입력박스 -->
      <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required value="brownpass">
      <div class="checkbox mb-3">
<%--        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
  --%>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2018. SoHyoung Lee all rights reserved.</p>
    </form>
  </body>
</html>


















