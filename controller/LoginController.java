
package controller;
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SchoolDao;
import dto.School;
@WebServlet("/login")
public class LoginController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String dbEmail = req.getParameter("email");
		String dbPassword = req.getParameter("password");		
		SchoolDao schooldao=new SchoolDao();
		
		School school=schooldao.getBystudentMail(dbEmail);	
		if(school!=null) 
		{
			if (dbEmail.equals(school.getStudentMail()) && dbPassword.equals(school.getStudentPassword()))  
			{
				HttpSession session=req.getSession();
				session.setAttribute("sessionpass",school.getStudentName());
				req.setAttribute("msgwrite","SuccessfuLL LOGIN WINGIT");
				
				ArrayList<School> school1=(ArrayList <School>) schooldao.getAllStudents();
				req.setAttribute("msg1",school1);
				
				Cookie cookie=new Cookie("cookiepass",school.getStudentName());
				resp.addCookie(cookie);
				
				RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
				dispatcher.forward(req,resp);
			}
		}
		else 
		{
				req.setAttribute("msg1","INCORRECT DATA LOGIN AGAIN");
				//resp.sendRedirect("");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req,resp);
		}	
			
	}
}
/*
 		HttpSession session=req.getSession();
		session.setAttribute("sessionpass",school.getStudentName());
		Cookie cookie=new Cookie("cookiepass",school.getStudentName());
				resp.addCookie(cookie);
 <%
	LinkedList <School> school_obj1=(LinkedList) request.getAttribute("msg2");
	%>
	<table border="2px" rules="all">
	<tr>	
	<th>Id</th>
	<th>Name</th>
	<th>MotherName</th>
	<th>FatherName</th>
	<th>StudentMail</th>
	<th>StudentPassword</th>
	</tr>
	<% 
	for (School school_obj : school_obj1 ) { %>
	<tr>
	<td><%=school_obj.getSchoolId() %></td>
	<td><%=school_obj.getStudentName() %></td>	
	<td><%=school_obj.getMotherName() %></td>
	<td><%=school_obj.getFatherName()%></td>
	<td><%=school_obj.getStudentMail() %></td>
	<td><%=school_obj.getStudentPassword() %></td>
	<td><a href="delete?id=<%=school_obj.getSchoolId() %>"><button>DELETE</button></a></td>
	<td><a href="update?id=<%=school_obj.getSchoolId() %>"><button>DELETE</button></a></td>
	</tr>
	<% } %>
	
	</table>
 
 */
