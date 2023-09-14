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
@WebServlet("/delete")
public class DeleteController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		
		SchoolDao schooldao=new SchoolDao();
			
		boolean result=schooldao.deletestudent(id);
		
		if (result)  
		{
			ArrayList <School> school1=schooldao.getAllStudents();
			
			req.setAttribute("msgwrite","id is deleted dont worry (-_-)");
			req.setAttribute("msg1",school1);
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req,resp);
		}
				
	}
}
