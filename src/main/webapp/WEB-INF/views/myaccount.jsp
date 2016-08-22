<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta charset="UTF-8" />

<!-- Bootstrap CSS -->
<link href="<c:url value="/dist/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/dist/css/bootstrap.css" />" rel="stylesheet"
	type="text/css">
<!-- Custom CSS -->
<link href="<c:url value="/css/custom.css" />" rel="stylesheet"
	type="text/css">

<title>My account</title>
</head>

<body>
	<!-- Div for displaying an alert box with some error message -->
	<div id="error-div"></div>
	
	<div class="jumbotron myaccount">
		<form id="myaccount-form" class="form-horizontal" action="myaccount"
			method="post">
			<fieldset>
				<legend>My account</legend>

				<div class="form-group">
					<label for="new-name-user">Name</label> <input id="new-name-user"
						type="text" pattern="[a-zA-Z- ]*" class="form-control" name="name"
						required value="${authenticatedUser.name }">
				</div>

				<div class="form-group">
					<label for="new-age-user">Age</label> <input id="new-age-user"
						type="number" min="1" class="form-control" name="age" required
						 value="${authenticatedUser.age}">
				</div>

				<div class="form-group">
					<label for="new-salary-user">Salary</label> <input
						id="new-salary-user" type="number" step="0.01" min="0"
						class="form-control" name="salary" required
						 value="${authenticatedUser.salary}">
				</div>

				<div class="form-group">
					<label for="new-username-user">Username</label> <input
						id="new-username-user" type="text" pattern=".{6,32}"
						title="The username must contain between 6 and 32 characters "
						class="form-control" name="username" required
						 value="${authenticatedUser.username}">
				</div>

				<button type="submit" class="btn btn-primary">Save changes</button>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}">
			</fieldset>
		</form>
	</div>

	<!-- jQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
	<!-- JQuery tablesorter -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.27.2/js/jquery.tablesorter.js"></script>

	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

	<!-- Javascript -->
	<script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script>
	
	<!-- Bootstrap Javascript -->
	<script type="text/javascript"
		src="<c:url value="/dist/js/bootstrap.min.js" />"></script>
	<!-- Main Javascript -->
	<script type="text/javascript"
		src="<c:url value="/javascript/main.js" />"></script>
</body>
</html>