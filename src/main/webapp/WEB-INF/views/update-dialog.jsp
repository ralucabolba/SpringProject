<!DOCTYPE html5>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page isELIgnored="false"%>

<html>
<head>
</head>
<body>
	<!-- Update dialog -->
	<div id="update-dialog" class="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Update product</h4>
				</div>
				<div class="modal-body" style="padding: 50px">
					<form id="update-form" class="form-horizontal" action="success/update" method="post">
						<fieldset>
							<input type="hidden" id="idInput" name="id">

							<div class="form-group">
								<label for="nameInput">Name</label> <input type="text"
									id="nameInput" class="form-control" name="name" required>
							</div>

							<div class="form-group">
								<label for="priceInput">Price</label> <input type="number"
									step="0.01" min="0" id="priceInput" class="form-control"
									name="price" required>
							</div>

							<div class="form-group">
								<label for="quantityInput">Quantity</label> <input type="number"
									min="0" id="quantityInput" class="form-control" name="quantity"
									required>
							</div>

							<input type="hidden" id="userIdInput" name="userId">

							<button type="submit" id="update-save" class="btn btn-success update-save"
								style="text-align: center">Save changes</button>

							<button id="update-close" type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>

							<input type="hidden" name="${_csrf.parameterName }"
								value="${_csrf.token }" id="csrf-protection" />
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>