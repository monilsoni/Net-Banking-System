<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">

<head>
<title>Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="https://fonts.googleapis.com/css?family=Questrial&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main-style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/dashboard-style.css">
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

			<!-- get username from spring security -->
			<h3 class="welcome-message">Welcome ${username }</h3>
			
			<form:form action="${pageContext.request.contextPath}/logout"  method="POST">
				<input class="logout-link" type="submit" value="Logout" />
			</form:form>
					
		</div>
		<div class="account-details">
			<h3>Dashboard</h3>
			<table>
				<tr>
					<th>Account Number</th>
					<th>IFSC code</th>
					<th>Account type</th>
					<th>Current balance</th>
					<th>Currency</th>
					<th>Transfer</th>
					<th>Mini Statement</th>
				</tr>

				<c:forEach var="accountList" items="${accountList}">

					<c:url var="transferLink" value="/transfer">
						<c:param name="accountNo" value="${accountList.accountNo}">
						</c:param>
					</c:url>
					
					<c:url var="miniStatementLink" value="/miniStatement">
				 		<c:param name="accountNo" value="${accountList.accountNo}">
				 		</c:param>
				 	</c:url>

					<tr>
						<td>${accountList.accountNo}</td>
						<td>${accountList.IFSC}</td>
						<td>${accountList.type}</td>
						<td>${accountList.balance}</td>
						<td>${accountList.currency}</td>
						<td class="transfer-link"><a href="${transferLink}">Proceed</a></td>
						<td class="transfer-link"><a href="${miniStatementLink}">Fetch</a></td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>