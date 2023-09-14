package controller;
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SchoolDao;
import dto.School;
@WebServlet("/update")
public class UpdateController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		SchoolDao dao=new SchoolDao();	
		School school=dao.getSchoolById(id);
		if(school != null)
		{
			req.setAttribute("msg1",school);
			RequestDispatcher dispatcher=req.getRequestDispatcher("update.jsp");
			dispatcher.forward(req,resp);
		}
		else
		{
			req.setAttribute("msg2","firstly login to update");
			//resp.sendRedirect("Login.html");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req,resp);
		}				
	}
}
//  <td><a href="update?id=<%=school_obj.getStudentId() %>"><button>UPDATE</button></a></td>