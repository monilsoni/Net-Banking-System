<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">

<head>
    <title>Transfer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://fonts.googleapis.com/css?family=Questrial&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/transfer-style.css">

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
        <div class="transfer-money">
            <h3>Transfer Money</h3>
            <form:form method="post" action="${pageContext.request.contextPath }/transaction">
           
            	<!-- remove this table if you can -->
            
                <table>
                    <tr>
                        <td>Account No.</td>
                        <td><input type="text" name="accountNoCred"></td>
                    </tr>
                    <tr>
                        <td>Amount</td>
                        <td><input type="number" name="amount" min="100" max="100000"></td>
                    </tr>

                    <tr>
                        <td>Message</td>
                        <td><input type="text" name="details"></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td><input id="submit" type="submit" value="Transfer"></td>
                    </tr>
                </table>
                              
                <font color="red">${error }</font>
                
            </form:form>
        </div>
    </div>

</body>

</html>