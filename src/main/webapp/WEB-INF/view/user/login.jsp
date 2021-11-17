<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet" href="./static/css/bootstrap.min.css" />
<link rel="stylesheet" href="./static/fontawesome-5.15.3/css/all.css" />
<link rel="stylesheet" href="./static/css/style.css" />
</head>
<body>
	<div class="container">
		<!-- <div class="row-10 border rounded d-flex align-items-center justify-content-center" style="width:400px"> -->
		<div class="row-10 border rounded div-login">
			<%
				String message = (String) request.getAttribute("messageServer");
				String contextPath = request.getContextPath();
				if (message == null)
					message = "";
				String email = (String) request.getAttribute("email");
				if (email == null)
					email = "";
				String password = (String) request.getAttribute("password");
				if (password == null)
					password = "";
			%>
			<form id="loginForm" method="post">
				<div class="card-header">
					<p class="card-title">Please Sign In</p>
				</div>
				<p id="error"><%=message%></p>
				<div class="card-body">
					<div class="form-group">
						<input type="email" name="email" value="<%=email%>" class="form-control" id="email" placeholder="E-mail" required>
					</div>
					<div class="form-group">
						<input type="password" name="password" value="<%=password%>" class="form-control" id="password"
							placeholder="Password" required>
					</div>
					<div class="form-group custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input" id="rememberMe"> <label
							class="custom-control-label label-remember" for="rememberMe">Remember Me</label>
					</div>
					<button type="submit" class="form-group btn btn-success form-control-file">Login</button>
					<div class="link-register">
						<a href="<%=contextPath%>/register">Click here to Register</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src=".\static\js\jquery-3.5.1.slim.min.js"></script>
	<script src=".\static\js\bootstrap.bundle.min.js"></script>
	<script src=".\static\js\jquery.js "></script>
	<script src=".\static\js\jquery-login.js "></script>
</body>
</html>