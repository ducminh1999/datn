<!DOCTYPE html>
<%@page import="milkTea.admin.dto.User"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Edit</title>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="_header.jsp"></jsp:include>
		<!-- content -->
		<div class="row">
			<jsp:include page="_menu.jsp"></jsp:include>
			<p class="mt-5 ml-5 pl-4 d-none" id="loading">Loading</p>
			<!-- Profile From Elements -->
			<div class="col-sm-10">
				<div class="row border-bottom div-lable">Edit Profile</div>
				<div class="row-10 border rounded div-form">
					<%
						String message = (String) request.getAttribute("messageServer");
												if (message == null)
													message = "";
												User user = (User) request.getAttribute("user");
												String firstName = (String) user.getFirstName();
												String lastName = (String) user.getLastName();
												String phone = (String) user.getPhone();
												String description = (String) user.getDescription();
												String email = (String) user.getEmail();
												if (firstName == null)
													firstName = "";
												if (lastName == null)
													lastName = "";
												if (phone == null)
													phone = "";
												if (description == null)
													description = "";
												if (email == null)
													email = "";
					%>
					<form id="editForm" method="post">
						<div class="card-header">
							<h6 class="card-title m-0 p-0">Profile From Elements</h6>
						</div>
						<div class="card-body w-75">
							<p id="error"><%=message%></p>
							<div class="form-group font-weight-bolder">
								<label for="firstName">First Name</label> <input type="text" class="form-control" name="firstName"
									id="firstName" placeholder="Enter the first name" value="<%=firstName%>" required>
							</div>
							<div class="form-group font-weight-bolder">
								<label for="lastName">Last Name</label> <input type="text" class="form-control" name="lastName" id="lastName"
									placeholder="Enter the last name" value="<%=lastName%>" required>
							</div>
							<div class="form-group font-weight-bolder">
								<label for="email">Email</label> <input type="email" readonly class="form-control-plaintext" id="email"
									value="<%=email%>">
							</div>
							<div class="form-group font-weight-bolder">
								<label for="phone">Phone</label> <input type="text" class="form-control" name="phone" id="phone"
									placeholder="Enter your phone number" value="<%=phone%>" required>
							</div>
							<div class="form-group font-weight-bolder">
								<label for="description">Description</label>
								<textarea class="form-control" name="description" id="description" rows="3"><%=description%></textarea>
							</div>
							<div class="form-group form-inline">
								<button type="submit" class="btn btn-success border mr-2">Submit Button</button>
								<button type="button" onclick="resetEditProfile()" class="btn btn-success border mr-2">Reset Button</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="../static/js/jquery-3.5.1.slim.min.js"></script>
	<script src="../static/js/bootstrap.bundle.min.js"></script>
	<script src="../static/js/jquery.js"></script>
	<script src="../static/js/jquery-editprofile.js "></script>
</body>
</html>