<!DOCTYPE html5>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

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
	<c:if test="${not empty signUpError }">
		<div class="alert alert-danger" role="alert">${signUpError }</div>
	</c:if>

	<div class="jumbotron signup">
		<form class="form-horizontal" action="signup" method="post">
			<fieldset>
				<legend>Sign up</legend>

				<div class="form-group">
					<label for="nameInput">Name</label> <input type="text"
						pattern="[a-zA-Z- ]*" id="nameInput" class="form-control"
						name="name" required placeholder="Your name">
				</div>

				<div class="form-group">
					<label for="ageInput">Age</label> <input type="number" min="1"
						id="ageInput" class="form-control" name="age" required
						placeholder="Your age">
				</div>

				<div class="form-group">
					<label for="salaryInput">Salary</label> <input type="number"
						step="0.01" min="0" id="salaryInput" class="form-control"
						name="salary" required placeholder="Your salary">
				</div>

				<div class="form-group">
					<label for="usernameInput">Username</label> <input type="text"
						pattern=".{6,32}"
						title="The username must contain between 6 and 32 characters "
						id="usernameInput" class="form-control" name="username" required
						placeholder="Username">
				</div>

				<div class="form-group">
					<label for="pw1Input">Password</label> <input type="password"
						pattern=".{6,32}"
						title="The password must contain between 6 and 32 characters "
						id="pw1Input" class="form-control" name="password" required
						placeholder="Password">
				</div>

				<div class="form-group">
					<label for="pw2Input">Repeat your password</label> <input
						type="password" pattern=".{6,32}"
						title="The password must contain between 6 and 32 characters "
						id="pw2Input" class="form-control" name="confirmationPassword"
						required placeholder="Password"> <span id="message"></span>
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
	<script type="text/javascript" src="<c:url value="/javascript/main.js" />"></script>
	
</body>
</html>