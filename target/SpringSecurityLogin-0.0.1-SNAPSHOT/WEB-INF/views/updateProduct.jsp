<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Fonts -->
<link href='https://fonts.googleapis.com/css?family=Quicksand'
	rel='stylesheet' type='text/css'>


<link href="<c:url value="/flatly/bootstrap.min.css" />" type="text/css"
	rel="stylesheet">
<link href="<c:url value="/flatly/bootstrap.css" />" type="text/css"
	rel="stylesheet">
<link href="<c:url value="/css/custom.css" />" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="/bootstrap/bootstrap.min.js"></script>

<title>Update product</title>
</head>
<body>
	<c:url var="logoutUrl" value="/logout" />

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
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


	<div class="jumbotron product">
		<form class="form-horizontal" action="../update" method="post">
			<fieldset>
				<legend>Update product</legend>
				<input type="hidden" name="id" value="${selectedProduct.getId()}">

				<div class="form-group">
					<label for="nameInput">Name</label> <input type="text"
						id="nameInput" class="form-control" name="name"
						value="${selectedProduct.getName()}">
				</div>

				<div class="form-group">
					<label for="priceInput">Price</label> <input type="text"
						id="priceInput" class="form-control" name="price"
						value="${selectedProduct.getPrice()}">
				</div>

				<div class="form-group">
					<label for="quantityInput">Quantity</label> <input type="text"
						id="quantityInput" class="form-control" name="quantity"
						value="${selectedProduct.getQuantity()}">
				</div>

				<input type="hidden" name="userId"
					value="${selectedProduct.getUser().getId()}">

				<button type="submit" class="btn btn-success"
					style="text-align: center">Save changes</button>


				<input type="hidden" name="${_csrf.parameterName }"
					value="${_csrf.token }" />
			</fieldset>
		</form>
	</div>

</body>
</html>