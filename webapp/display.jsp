<%@page import="java.util.*"%>
<%@page import="dto.School"%>
<%@page import="dao.SchoolDao"%>
<%@page import="antlr.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>
<h1>IM DISPLAY WEB PAGE</h1>

<%
	String message=(String) request.getAttribute("msgwrite");
	String message1=(String) request.getAttribute("cookiepass");
	String message2=(String) request.getAttribute("sessionpass");

//	String message1=(String) request.getAttribute("msgdel/upd");
	if (message != null)
	{
%>
<h3><%=message %></h3>
<%	}%>
<% if (message1 != null) {%> 
<h3><%=message1 %></h3> <%	} %>
<% if (message2 != null) {%> 
<h3><%=message2 %></h3> <%	} %>
<%
	ArrayList <School> school_obj1=(ArrayList) request.getAttribute("msg1");
	%>
	
	<table border="2px" rules="all">
	<tr>	
	<th>Id</th>
	<th>Name</th>
	<th>MotherName</th>
	<th>FatherName</th>
	<th>StudentMail</th>
	<th>StudentPassword</th>
	<th>DELETE</th>
	<th>UPDATE</th>	
	</tr>
	<% 
	for(School school_obj: school_obj1)
	{
	%>
	<tr>
	<td><%=school_obj.getStudentId() %></td>
	<td><%=school_obj.getStudentName() %></td>	
	<td><%=school_obj.getMotherName() %></td>
	<td><%=school_obj.getFatherName()%></td>
	<td><%=school_obj.getStudentMail() %></td>
	<td ><%=school_obj.getStudentPassword() %></td>
	<td><a href="delete?id=<%=school_obj.getStudentId() %>"><button>Delete</button></a></td>	
	<td><a href="update?id=<%=school_obj.getStudentId() %>"><button>Update</button></a></td>	
	</tr>
	<% } %>
	</table>
</body>
</html>