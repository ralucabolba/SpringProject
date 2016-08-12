<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta charset="UTF-8" />
<title>Users</title>

<!-- Css -->
<link href="<c:url value="/flatly/bootstrap.min.css" />" type="text/css"
	rel="stylesheet">
<link href="<c:url value="/flatly/bootstrap.css" />" type="text/css"
	rel="stylesheet">
<link href="<c:url value="/css/custom.css" />" type="text/css"
	rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css" type="text/css" rel="stylesheet">

</head>
<body>
	<!-- Including the navigation bar at the top of the page -->
	<jsp:include page="nav.jsp" />

	<form class="form-group">
		<c:if test="${not empty incorrectProductMessage}">
			<div class="alert alert-danger" role="alert">${incorrectProductMessage}</div>
		</c:if>
	</form>

	<div class="alert alert-success" style="margin-top: 7px">
		<p>Hello, ${role}</p>
		<p>Last update : ${lastAction}</p>
	</div>

	<!-- Including the div for the add operation of products -->
	<jsp:include page="addproduct.jsp" />

	<div class="jumbotron table">
		<%
			int rowCount = 0;
		%>

		<script type="text/javascript">
			var products = [];
		</script>

		<div class="form-group">
			<table id="product-table" class="table table-hover table-bordered">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>User id</th>
					<th style="width: 13%">Operation</th>
				</tr>

				<c:forEach var="currentProduct" items="${productList }">
					<tr>
						<td class="idProduct">${currentProduct.getId()}</td>
						<td class="nameProduct">${currentProduct.getName() }</td>
						<td class="numeric priceProduct">${currentProduct.getPrice() }</td>
						<td class="numeric quantityProduct">${currentProduct.getQuantity() }</td>
						<td class="numeric userIdProduct">${currentProduct.getUserId() }</td>
						<td>
							<ul class="list-inline">
								<li>
									<button class="btn btn-info rowUpdate"
										data-toggle="modal"
										data-target="#update-dialog">Update</button>
								</li>
								<li>
									<button class="btn btn-danger rowDelete" data-toggle="modal"
										data-target="#delete-dialog">Delete</button>
								</li>
							</ul>
						</td>
					</tr>

					<%
						rowCount++;
					%>
				</c:forEach>
			</table>
		</div>

		<div class="form-group">
			<p style="text-align: center">
				Total number of rows :
				<%=rowCount%></p>
		</div>
	</div>

	<!-- Include the dialog for updating a product -->
	<jsp:include page="update-dialog.jsp"/>

	<!-- Delete confirmation dialog-->
	<div id="delete-dialog" class="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Delete product?</h4>
				</div>
				<div class="modal-body">
					<p>The product will be permanently deleted and cannot be
						recovered. Are you sure?</p>
				</div>
				<div class="modal-footer">
					<button id="dialog-close" type="button" class="btn btn-default"
						data-dismiss="modal">Close</button>
					<input type="hidden" id="rowNo">
					<button id="dialog-delete" type="button" class="btn btn-primary">Delete</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- jQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

	<!-- Javascript -->
	<script type="text/javascript"
		src="<c:url value="/bootstrap/bootstrap.min.js" />"></script>

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
	
	<script type="text/javascript" src="<c:url value="/javascript/main.js" />"></script>

</body>
</html>

