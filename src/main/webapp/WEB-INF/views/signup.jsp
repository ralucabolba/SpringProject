<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
						id="nameInput" class="form-control" name="name"
						placeholder="Your name">
				</div>

				<div class="form-group">
					<label for="ageInput">Age</label> <input type="text" id="ageInput"
						class="form-control" name="age" placeholder="Your age">
				</div>

				<div class="form-group">
					<label for="salaryInput">Salary</label> <input type="text"
						id="salaryInput" class="form-control" name="salary"
						placeholder="Your salary">
				</div>

				<div class="form-group">
					<label for="usernameInput">Username</label> <input type="text"
						id="usernameInput" class="form-control" name="username"
						placeholder="Username">
				</div>

				<div class="form-group">
					<label for="pw1Input">Password</label> <input type="password"
						id="pw1Input" class="form-control" name="password"
						placeholder="Password">
				</div>

				<div class="form-group">
					<label for="pw2Input">Repeat your password</label> <input
						type="password" id="pw2Input" class="form-control"
						name="confirmationPassword" placeholder="Password">
				</div>

				<button type="submit" class="btn btn-primary">Sign up</button>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}">
			</fieldset>
		</form>
	</div>

</body>
</html>