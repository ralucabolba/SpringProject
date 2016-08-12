<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Add div -->
	<div id="add-div" class="jumbotron product" style="display: none">
		<form id="add-form" class="form-horizontal" action="success/add"
			method="post">
			<fieldset>
				<div class="form-group">
					<label for="nameInput">Name</label> <input id="nameAdd" type="text"
						class="form-control" name="name" placeholder="Product name"
						required>
				</div>

				<div class="form-group">
					<label for="priceInput">Price</label> <input id="priceAdd" type="number"
						step="0.01" min="0" class="form-control" name="price"
						placeholder="Product price" required>
				</div>

				<div class="form-group">
					<label for="quantityInput">Quantity</label> <input id="quantityAdd" type="number"
						min="0" class="form-control" name="quantity"
						placeholder="Product quantity" required>
				</div>

				<button type="submit" class="btn btn-success"
					style="text-align: center">Add new product</button>

				<button id="closeAdd" class="btn btn-primary"
					style="text-align: center">Close</button>

				<input type="hidden" name="${_csrf.parameterName }"
					value="${_csrf.token }" />
			</fieldset>
		</form>
	</div>
</body>
</html>