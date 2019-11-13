<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!doctype html>
<html lang="en">

<head>
	<title>Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="https://fonts.googleapis.com/css?family=Questrial&display=swap" rel="stylesheet">
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main-style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login-style.css">
</head>

<body>

	<div class="header">
		<nav>
			<h1>Netbanking Application</h1>
		</nav>
	</div>
	<div class="main flex-row">
		<div class="login">
			<form:form id="login-form"
				action="${pageContext.request.contextPath}/authenticateTheUser"
				method="POST">
				<!-- Place for messages: error, alert etc ... -->
				<div class="form-group form-items">
					<div>
						<!-- Check for login error -->
						<c:if test="${param.error != null}">
							<div class="alert alert-danger">Invalid username or
								password.</div>
						</c:if>

						<!-- Check for logout -->
						<c:if test="${param.logout != null}">
							<div class="alert alert-success">You have been logged out.</div>
						</c:if>
					</div>
				</div>

				<input id="username" class="form-items" name="username" type="text" placeholder="username">
				<input id="password" class="form-items" name="password" type="password" placeholder="password">
				<input id="submit" type="submit" class="form-items" name="submit" value="Submit">
			</form:form>
		</div>
	</div>

</body>

</html>