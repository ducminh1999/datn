<!DOCTYPE html>
<%@page import="milkTea.admin.dto.ContentDto"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View</title>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="_header.jsp"></jsp:include>
		<!-- content -->
		<div class="row">
			<jsp:include page="_menu.jsp"></jsp:include>
			<!-- Profile From Elements -->
			<p class="mt-5 ml-5 pl-4" id="loading"></p>
			<div class="col-sm-10 a" id="content1">
				<div class="row border-bottom div-lable">View Content</div>
				<div class="row-10 border rounded div-form">
					<form>
						<div class="card-header">
							<h6 class="card-title m-0 p-0">Content From Elements</h6>
						</div>
						<div class="card-body">
							<table id="tbl-result" class="table table-bordered table-hover table-striped ">
								<thead>
									<tr>
										<th>#</th>
										<th>Title</th>
										<th>Brifer</th>
										<th>Create Date</th>
									</tr>
								</thead>
								<tbody>
									<%
										List<ContentDto> list = (List<ContentDto>) request.getAttribute("list");
																String contextPath = request.getContextPath();
									%>
									<%
										for (ContentDto content : list) {
									%>
									<tr data-widget="expandable-table" aria-expanded="false">
										<td><%=content.getId()%></td>
										<td><%=content.getTitle()%></td>
										<td><%=content.getBrief()%></td>
										<td><%=content.getCreateDate()%></td>
										<td><a href="<%=contextPath%>/user/editContent?id=<%=content.getId()%>">Edit</a> | <a
											href="<%=contextPath%>/user/deleteContent?id=<%=content.getId()%>">Delete</a></td>
									</tr>
									<%
										}
									%>
									
								<!-- <tr data-widget="expandable-table" aria-expanded="true">
                                        <td>2</td>
                                        <td>Alexander Pierce</td>
                                        <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                                        <td>11/7/2014 10:13</td>
                                    </tr> -->
									</tbody>
									
							</table>
							<% 
									if (list.size() == 0) {
									%>
									
									<div>Danh sach trong</div>
									<%
										}
									%>
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="../static/js/jquery-3.5.1.slim.min.js"></script>
	<script src="../static/js/bootstrap.bundle.min.js"></script>
	<script src="../static/js/jquery.js"></script>
</body>
</html>