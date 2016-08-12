<!DOCTYPE html5>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta charset="UTF-8" />

<!-- Fonts -->
<link href='https://fonts.googleapis.com/css?family=Quicksand'
	rel='stylesheet' type='text/css'>

<link href="<c:url value="/flatly/bootstrap.min.css" />" type="text/css"
	rel="stylesheet">
<link href="<c:url value="/flatly/bootstrap.css" />" type="text/css"
	rel="stylesheet">
<link href="<c:url value="/css/custom.css" />" type="text/css"
	rel="stylesheet">

<title>Sign up</title>

</head>
<body>
	<!-- Div for displaying an alert box with some error message -->
	<div id="error-div"></div>

	<div class="jumbotron signup">
		<form id="signup-form" class="form-horizontal" action="signup"
			method="post">
			<fieldset>
				<legend>Sign up</legend>

				<div class="form-group">
					<label for="name-user">Name</label> <input id="name-user"
						type="text" pattern="[a-zA-Z- ]*" class="form-control" name="name"
						required placeholder="Your name">
				</div>

				<div class="form-group">
					<label for="age-user">Age</label> <input id="age-user"
						type="number" min="1" class="form-control" name="age" required
						placeholder="Your age">
				</div>

				<div class="form-group">
					<label for="salary-user">Salary</label> <input id="salary-user"
						type="number" step="0.01" min="0" class="form-control"
						name="salary" required placeholder="Your salary">
				</div>

				<div class="form-group">
					<label for="username-user">Username</label> <input
						id="username-user" type="text" pattern=".{6,32}"
						title="The username must contain between 6 and 32 characters "
						class="form-control" name="username" required
						placeholder="Username">
				</div>

				<div class="form-group">
					<label for="password-user">Password</label> <input
						id="password-user" type="password" pattern=".{6,32}"
						title="The password must contain between 6 and 32 characters "
						class="form-control" name="password" required
						placeholder="Password">
				</div>

				<div class="form-group">
					<label for="confirmation-password-user">Repeat your
						password</label> <input id="confirmation-password-user" type="password"
						pattern=".{6,32}"
						title="The password must contain between 6 and 32 characters "
						class="form-control" name="confirmationPassword" required
						placeholder="Password"> <span id="message"></span>
				</div>

				<button type="submit" class="btn btn-primary">Sign up</button>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}">
			</fieldset>
		</form>
	</div>

	<!-- jQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<!-- Javascript -->
	<script type="text/javascript" src="/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/javascript/main.js" />"></script>

</body>
</html>