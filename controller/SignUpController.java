
package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SchoolDao;
import dto.School;
@WebServlet("/signup")
public class SignUpController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
		//int id=Integer.parseInt(req.getParameter("SchoolId"));
		String studentname=req.getParameter("student_name");	
		String fathername=req.getParameter("father_name");
		String mothername=req.getParameter("mother_name");
		String mail=req.getParameter("email");
		String password=req.getParameter("password");
		
		School school=new School();
		//school.setSchoolId(id);
		school.setStudentName(studentname);
		school.setFatherName(fathername);
		school.setMotherName(mothername);
		school.setStudentMail(mail);
		school.setStudentPassword(password);
		
		SchoolDao dao=new SchoolDao();	
		School dbSchool=dao.saveStudentDetails(school);
		
		if(dbSchool != null)
		{
			req.setAttribute("message","Successfully SignedUp which is written in controller");
			//resp.sendRedirect("Login.html");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req,resp);
		}
		
		
	}
}
