<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Login form</title>

<!-- Fonts -->
<link href='https://fonts.googleapis.com/css?family=Quicksand'
	rel='stylesheet' type='text/css'>

<link href="<c:url value="/flatly/bootstrap.min.css" />" type="text/css"
	rel="stylesheet">
<link href="<c:url value="/flatly/bootstrap.css" />" type="text/css"
	rel="stylesheet">
<link href="<c:url value="/css/custom.css" />" type="text/css"
	rel="stylesheet">


</head>
<body>
	<form class="form-group">
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger" role="alert">${errorMessage}</div>
		</c:if>

		<c:if test="${not empty logoutMessage}">
			<div class="alert alert-info" role="alert">${logoutMessage}</div>
		</c:if>
	</form>

	<div class="jumbotron login">
		<form class="form-horizontal" action="<c:url value='/login'/>"
			method="post">
			<fieldset>
				<div class="form-group">
					<label for="usernameInput">Username</label> <input type="text"
						id="usernameInput" class="form-control" name="username"
						placeholder="Username">
				</div>

				<div class="form-group">
					<label for="passwordInput">Password</label> <input type="password"
						id="passwordInput" class="form-control" name="password"
						placeholder="Password">
				</div>

				<div class="form-group" style="text-align: center">
					<button id="login" class="btn btn-primary">Sign in</button>
				</div>


				<div class="form-group" style="text-align: center">
					<h6>
						Don't have an account? <a href="signup">Sign up</a>
					</h6>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</fieldset>
		</form>
	</div>

	<!-- jQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<!-- Javascript -->
	<script type="text/javascript" src="<c:url value="/bootstrap/bootstrap.min.js" />"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("button#login").click(function() {
				$(this).submit();
			})
		})
	</script>
</body>
</html>