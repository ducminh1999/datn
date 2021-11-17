<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
<link rel="stylesheet" href="./static/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="./static/fontawesome-5.15.3/css/all.css" type="text/css" />
<link rel="stylesheet" href="./static/css/style.css" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="row-10 border rounded div-login">
			<form method="post" id="registerForm">
				<div class="card-header">
					<p class="card-title">Register</p>
				</div>
				<% 

				 	String contextPath = (String) request.getContextPath();
					String message = (String) request.getAttribute("messageServer");
					if (message == null)
						message = "";

					String userName = (String) request.getAttribute("userName");
					if (userName == null)
						userName = "";
					String email = (String) request.getAttribute("email");
					if (email == null)
						email = "";
					String password = (String) request.getAttribute("password");
					if (password == null)
						password = "";
					String rePassword = (String) request.getAttribute("rePassword");
					if (rePassword == null)
						rePassword = "";
                %>
				<p id="error"><%= message %></p>
				<div class="card-body">
					<div class="form-group">
						<input type="text" class="form-control"  name="userName" id="userName" value="<%=userName %>" placeholder="User name" required>
					</div>
					<div class="form-group ">
						<input type="text" class="form-control" <%if(message!=""){ %>style="border-color: red"<%} %> name="email" id="email" value="<%=email %>" placeholder="E-mail" required>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="password" id="password" value="<%=password %>" placeholder="Password" required>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="rePassword" id="rePassword" value="<%=rePassword %>" placeholder="Re Password" required>
					</div>
					<button type="submit" onclick="validateRegister()" class="form-group btn btn-success form-control-file">Register</button>
					<div class="link-register">
						<a href="<%=contextPath %>/login">Click here to Login</a>
						<!--  <a href="<%=contextPath %>/admin/user/add">New</a> -->
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src=".\static\js\jquery-3.5.1.slim.min.js"></script>
	<script src=".\static\js\bootstrap.bundle.min.js"></script>
	<script src=".\static\js\jquery.js "></script>
	<script src=".\static\js\jquery-register.js "></script>
</body>
</html>