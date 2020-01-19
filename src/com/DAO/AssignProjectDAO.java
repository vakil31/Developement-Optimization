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
import com.VO.StaffVO;

@Repository
public class AssignProjectDAO {
	@Autowired
	SessionFactory sessionfactory;
	public void insert(AssignProjectVO assignProjectvo)
	{
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(assignProjectvo);
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
		Query q =session.createQuery("from AssignProjectVO");
		ls=q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
	
	public void delete(AssignProjectVO countryvo) {

		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(countryvo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public List edit(AssignProjectVO assignProjectvo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from AssignProjectVO where id='"+assignProjectvo.getAssignProjectId()+"' ");
		ls = q.list();
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}

	public void update(AssignProjectVO assignProjectvo) {

		
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(assignProjectvo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	/*public String searchproject(AssignProjectVO asv) {
		// TODO Auto-generated method stub
		
		List ls= new ArrayList();
		String projectName = "";
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from AssignProjectVO where id='"+asv.getSvo().getStaffId()+"' ");
		ls = q.list();
		session.close();
		AssignProjectVO v=(AssignProjectVO)ls.get(0);
		
		projectName = v.getPvo().getProjectName();
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	return projectName;
	}*/
	public List searchproject(AssignProjectVO asv) {
		
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from AssignProjectVO where svo_staffId='"+asv.getSvo().getStaffId()+"' ");
		ls = q.list();
		session.close();
		
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	return ls;
	}

}
