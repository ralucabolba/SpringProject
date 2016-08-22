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

	<nav class="navbar navbar-dark bg-inverse">
		<button class="navbar-toggler hidden-sm-up" type="button"
			data-toggle="collapse" data-target="#exCollapsingNavbar2"
			aria-controls="exCollapsingNavbar2" aria-expanded="false"
			aria-label="Toggle navigation">&#9776;</button>
		<div class="collapse navbar-toggleable-xs" id="exCollapsingNavbar2">
			<a class="navbar-brand" href="javascript:void(0)">Products</a>
			<ul class="nav navbar-nav">
				<li class="nav-item" id="myAccount"><a class="nav-link" href="success/myaccount">My account</a></li>
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