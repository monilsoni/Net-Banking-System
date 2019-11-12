<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">

<head>
<title>Mini Statement</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="https://fonts.googleapis.com/css?family=Questrial&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main-style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mini-statement-style.css">
</head>

<body>

	<security:authentication var="username" property="principal.username" /> 

	<div class="header">
		<nav>
			<h1>Netbanking Application</h1>
		</nav>
	</div>
	<div class="main">
		<div class="navigation-bar">
			<h3 class="welcome-message">Welcome ${username }</h3>
			<form:form action="${pageContext.request.contextPath}/logout"  method="POST">
				<input type="submit" value="Logout" />
			</form:form>		
		</div>
		<div class="mini-statement">
			<h3>
				Mini-Statement for account number: ${accountNo }
			</h3>
			<table>
				<tr>
					<th>Date and Time</th>
					<th>Cr/Db</th>
					<th>Amount</th>
					<th>details</th>
					<th>Closing Balance</th>
				</tr>

				<c:forEach var="transaction" items="${transactionList}">
					<tr>
						<td>${transaction.date}</td>
						<td>${transaction.crDb}</td>
						<td>${transaction.amount}</td>
						<td>${transaction.details}</td>
						<td>${transaction.closingBalance}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>