<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!doctype html>
<html lang="en">

<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link
	href="https://fonts.googleapis.com/css?family=Questrial&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main-style.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/login-style.css">
</head>

<body>

	<div class="header">
		<nav>
			<h1>Netbanking Application</h1>
		</nav>
	</div>
	<div class="main flex-row">
		<div class="login">
			<!--TODO: Make a place for errors and style it -->
			${error }
			<form:form id="login-form" action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
				<input id="username" class="form-items" name="username" type="text" placeholder="username"> 
				<input id="password" class="form-items" name="password" type="password" placeholder="password">
				<button id="submit" class="form-items" name="submit" type="submit" value="Submit">Submit</button>
			</form:form>
		</div>
	</div>

</body>

</html>