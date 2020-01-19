package com.DAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.DemoVO;
import com.DAO.DemoDAO;
@Repository
public class DemoDAO {
	@Autowired
	SessionFactory sessionfactory;
  public void insert(DemoVO demovo)
	{
		try
		{
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(demovo);
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
		Query q =session.createQuery("from DemoVO");
		ls=q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
	  public void delete(DemoVO demovo) {
		try
		{
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(demovo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
  public List edit(DemoVO demovo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from DemoVO where id='"+demovo.getdemoId()+"'");
		ls = q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
  public void update(DemoVO demovo) {
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(demovo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}