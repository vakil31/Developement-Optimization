package com.DAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.BoreVO;
import com.DAO.BoreDAO;
@Repository
public class BoreDAO {
	@Autowired
	SessionFactory sessionfactory;
  public void insert(BoreVO borevo)
	{
		try
		{
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(borevo);
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
		Query q =session.createQuery("from BoreVO");
		ls=q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
	  public void delete(BoreVO borevo) {
		try
		{
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(borevo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
  public List edit(BoreVO borevo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from BoreVO where id='"+borevo.getboreId()+"'");
		ls = q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
  public void update(BoreVO borevo) {
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(borevo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}