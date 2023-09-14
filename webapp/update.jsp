<%@page import="dto.School"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<% School obj=(School) request.getAttribute("msg1"); %>
	<form   action="edit" method="post" target="_blank">
	<table>
	<tr>
	<td>Name :</td>
	<td><input type="text" name="name" value="<%=obj.getStudentName() %>"> </td>
	
	</tr>
	<tr>
	<td>Id :</td>
	<td><input type="number" name="id" value="<%=obj.getStudentId()%>" ></td>
	
	</tr>
	<tr>
	<td>FatherName :</td>
	<td><input type="text" name="FatherName" value="<%=obj.getFatherName()%>"> </td>
	
	</tr>
	<tr>
	<td>MotherName :</td>
	<td><input type="text" name="MotherName" value="<%=obj.getMotherName()%>"> </td>
	
	</tr>
	<tr>
	<td>Email :</td>
	<td><input type="email" name="email" value="<%=obj.getStudentMail()%>"> </td>
	
	</tr>
	<tr>
	<td>Password :</td>
	<td><input type="password" name="password" value="<%=obj.getStudentPassword()%>"> </td>
	
	</tr>	
	<tr> 
		 <td><input type="submit" value="update" ></td>
	</tr>
	</table>
	</form>

</body>
</html>