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
	<c:url var="logoutUrl" value="/logout" />
	<%-- <nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li>
						<button id="addProduct" class="btn btn-primary"
							style="margin-top: 7px">Add new product</button>
					</li>
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
	</nav> --%>

	<nav class="navbar navbar-dark bg-inverse">
		<button class="navbar-toggler hidden-sm-up" type="button"
			data-toggle="collapse" data-target="#exCollapsingNavbar2"
			aria-controls="exCollapsingNavbar2" aria-expanded="false"
			aria-label="Toggle navigation">&#9776;</button>
		<div class="collapse navbar-toggleable-xs" id="exCollapsingNavbar2">
			<a class="navbar-brand" href="javascript:void(0)">Products</a>
			<ul class="nav navbar-nav">
				<li class="nav-item" id="addProduct"><a class="nav-link" href="javascript:void(0)">Add new
						product</a></li>
				<li class="nav-item"><a class="nav-link" id="logout" href="javascript:void(0)">Logout</a></li>
			</ul>
		</div>
	</nav>
	<!-- Form for performing logout -->
	<form action="${logoutUrl}" method="post" id="logout-form">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>