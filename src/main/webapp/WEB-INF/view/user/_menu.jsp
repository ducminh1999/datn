<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<!-- menu -->
	<div class="col-sm-2 p-0 border-right">
		<%
			String contextPath = request.getContextPath();
		String search = (String) request.getAttribute("search");
		if(search==null) search="";
		%>
		<div class="p-2 border-bottom">
			<form id="searchForm" action="<%=contextPath %>/user/view" method="post" class="form-inline">
				<div class="input-group" data-widget="sidebar-search">
					<input type="text" name="search" class="form-control  form-control-sidebar" placeholder="Search" value="<%=search%>">
					<div class="input-group-append">
						<button type="submit" class="btn btn-sidebar">
							<i class="fas fa-fw fa-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
		<a id="load" class="btn border-0 form-control-file text-left p-0"
			href="<%=contextPath%>/user/view">
			<div class="row-2 p-2 border-bottom">
				<i class="fas fa-table"></i> View Contents
			</div>
		</a> <a id="load"  class="btn border-0 form-control-file text-left p-0"
			href="<%=contextPath%>/user/addContent">
			<div class="row-2 p-2 border-bottom">
				<i class="fas fa-edit"></i> Form content
			</div>
		</a>
	</div>
</body>
</html>