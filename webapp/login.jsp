<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<%
	String message=(String) request.getAttribute("msg1");
	if (message != null)
	{
%>
<h3><%=message %></h3>
<%
	}
%>

<form action="login"  method="post">
	<table>
	
	<tr> <td><label for="email">StudentEmail Id:</label> <td>
		 <td><input type="email" name="email" required="required"></td>
	</tr>
	<tr> <td><label for="password">StudentPassword:</label> <td>
		 <td><input type="password" name="password" required="required"></td>
	</tr>
	<tr> 
		 <td><input type="submit" value="Login" required="required"></td>
	</tr>	
	</table>
	</form>

</body>
</html>