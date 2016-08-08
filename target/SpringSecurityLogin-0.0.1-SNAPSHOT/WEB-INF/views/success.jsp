<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page isELIgnored="false"%>

<html>
<head>

<meta charset="UTF-8" />
<title>Users</title>

<!-- Css -->
<link href="<c:url value="/flatly/bootstrap.min.css" />" type="text/css"
	rel="stylesheet">
<link href="<c:url value="/flatly/bootstrap.css" />" type="text/css"
	rel="stylesheet">
<link href="<c:url value="/css/custom.css" />" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="/bootstrap/bootstrap.min.js"></script>

</head>
<body>
	<c:url var="logoutUrl" value="/logout" />

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="success/add">Add new product</a></li>
					<li>
						<form action="${logoutUrl}" method="post">
							<button type="submit" class="btn btn-primary"
								style="margin-top: 7px">Log out</button>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>

					</li>
				</ul>
			</div>
		</div>
	</nav>


	<form class="form-group">
		<c:if test="${not empty incorrectProductMessage}">
			<div class="alert alert-danger" role="alert">${incorrectProductMessage}</div>
		</c:if>
	</form>

	<div class="alert alert-success" style="margin-top: 7px">
		<p>Hello, ${role}</p>
		<p>Last update : ${lastAction}</p>
	</div>
	<div class="jumbotron table">
		<%
			int rowCount = 0;
		%>
		<div class="form-group">
			<table class="table table-hover table-bordered">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>User id</th>
					<th style="width:13%">Operation</th>
				</tr>
				<c:forEach var="currentProduct" items="${productList }">
					<tr>
						<td>${currentProduct.getId()}</td>
						<td>${currentProduct.getName() }</td>
						<td class="numeric">${currentProduct.getPrice() }</td>
						<td class="numeric">${currentProduct.getQuantity() }</td>
						<td class="numeric">${currentProduct.getUserId() }</td>
						<td>
							<ul class="list-inline">
								<li>
									<form action="success/update/${currentProduct.getId()}"
										method="get">
										<button type="submit" class="btn btn-info">Update</button>
									</form>
								</li>
								<li>
									
									<form action="success/delete?productId=${currentProduct.getId()}"
										method="post">
										<button type="submit" class="btn btn-danger">Delete</button>
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
									</form>
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


	<!-- Javascript -->
	<script src="bootstrap/min.js"></script>
	<!-- JQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>

