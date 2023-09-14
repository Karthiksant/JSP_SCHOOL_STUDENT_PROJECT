package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SchoolDao;
import dto.School;
@WebServlet("/edit")
public class EditController extends HttpServlet
{		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			int id=Integer.parseInt(req.getParameter("id"));
			String studentname=req.getParameter("name");	
			String fathername=req.getParameter("FatherName");
			String mothername=req.getParameter("MotherName");
			String mail=req.getParameter("email");
			String password=req.getParameter("password");
			
			School school=new School();
			school.setStudentId(id);;
			school.setStudentName(studentname);
			school.setFatherName(fathername);
			school.setMotherName(mothername);
			school.setStudentMail(mail);
			school.setStudentPassword(password);
			
			SchoolDao dao=new SchoolDao();	
			School dbSchool=dao.UpdateSchool(school);
			
			if(dbSchool!=null) 
			{							
					ArrayList<School> school1=(ArrayList <School>) dao.getAllStudents();
					req.setAttribute("msg1",school1);
					req.setAttribute("msgwrite","updated successfully");
					
					HttpSession session=req.getSession();
					session.setAttribute("sessionpass",school.getStudentName());
					
					Cookie cookie=new Cookie("cookiepass",school.getStudentName());
					resp.addCookie(cookie);
					
					RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
					dispatcher.forward(req,resp);				
			}
								
		}
}
