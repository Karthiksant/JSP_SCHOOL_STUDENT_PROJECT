<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body>

<form action="signup" method="post">
	<table>
	<tr>
	
	<td> <label for="student_name"> StudentName : </label></td>
	<td> <input type="text" name="student_name" required="required"></td>
	</tr> 
	
	<tr>
	<td> <label for="father_name"> Father's Name : </label></td>
			<td> <input type="text" name="father_name" required="required"></td>
	</tr> 
	<tr>
			<td> <label for="mother_name"> Mother's Name : </label></td>
			<td> <input type="text" name="mother_name" required="required"></td>
	</tr> 
	<tr>
			<td> <label for="email"> StudentEmail : </label></td>
			<td> <input type="email" name="email" required="required"></td>
	</tr> 
	<tr>
			<td> <label for="password"> StudentPassword : </label></td>
			<td> <input type="text" name="password" required="required"></td>
	</tr> 
	<tr> 
		 <td><input type="submit"></td>
	</tr>
	</table>	
	</form>

</body>
</html>