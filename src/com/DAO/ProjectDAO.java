package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.AssignProjectVO;
import com.VO.ProjectVO;

@Repository
public class ProjectDAO {
	@Autowired
	SessionFactory sessionfactory;
	public void insert(ProjectVO projectvo)
	{
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(projectvo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	public List search() {
		List ls = new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q =session.createQuery("from ProjectVO");
		ls=q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
		
		return ls;
	}
	public void delete(ProjectVO projectvo) {

		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(projectvo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public List edit(ProjectVO projectvo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from ProjectVO where id='"+projectvo.getProjectId()+"' ");
		ls = q.list();
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}

	public void update(ProjectVO projectvo) {
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(projectvo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	public String searchname(ProjectVO value) 
	{
		List ls= new ArrayList();
		String name = "";
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from ProjectVO where id='"+value.getProjectId()+"' ");
		ls = q.list();
		session.close();
		ProjectVO v=(ProjectVO)ls.get(0);
		
		name = v.getProjectName();
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	return name;		
	}
}
