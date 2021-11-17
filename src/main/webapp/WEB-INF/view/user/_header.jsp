<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/static/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/static/fontawesome-5.15.3/css/all.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/static/css/style.css" />" rel="stylesheet" type="text/css">
<!-- <link href="../static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../static/fontawesome-5.15.3/css/all.css" rel="stylesheet" type="text/css">
<link href="../static/css/style.css" rel="stylesheet" type="text/css"> -->
</head>
<body>
	<!-- header -->
	<div class="row border-bottom">
		<div class="col-12 p-0">
			<nav class="navbar navbar-expand-lg navbar-light ">
				<a class="navbar-brand" href="#">CMS</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="mr-auto">
					</ul>
					<div class="dropdown navbar-nav">
						<a class="nav-link" data-toggle="dropdown" href="#"> <i class="fas fa-user"></i> <i class="fas fa-sort-down"></i>
						</a>
						<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu2">
							<%
								String contextPath = request.getContextPath();
							%>
							<a href="<%=contextPath%>/user/editProfile" class="dropdown-item"> <i class="fas fa-user"></i> User Profile
							</a>
							<div class="dropdown-divider"></div>
							<a href="<%=contextPath%>/logout" class="dropdown-item"> <i class="fas fa-sign-out-alt"></i> Logout
							</a>
						</div>
					</div>
				</div>
			</nav>
		</div>
	</div>
</body>
</html>