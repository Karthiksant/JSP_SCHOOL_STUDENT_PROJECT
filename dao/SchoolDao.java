package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;
import dto.School;

public class SchoolDao 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public School saveStudentDetails(School school)
	{
		et.begin();
		em.persist(school);
		et.commit();
		return school;
	}
	public School getBystudentMail(String mail) 
	{
		Query query=em.createQuery("Select p from School p where StudentMail=?1");
		query.setParameter(1,mail);
		try 
		{
			School school = (School) query.getSingleResult();
			return school;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
		
	}
	@SuppressWarnings("unchecked")
	public ArrayList<School> getAllStudents()
	{
		Query query=em.createQuery("Select p from School p ");
		List <School> school=query.getResultList();
		return (ArrayList<School>) school;		
	}
	public boolean deletestudent(int id)
	{
		School school=em.find(School.class,id);
		if(school !=null)
		{
			et.begin();
			em.remove(school);
			et.commit();
			return true;
		}
		return false;
	}
	public School getSchoolById(int id)
	{	
		try 
		{
			return em.find(School.class,id);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	public School UpdateSchool(School school)
	{
		et.begin();
		em.merge(school);
		et.commit();
		return school;
	}
}


