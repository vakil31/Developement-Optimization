package com.DAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.TestVO;
import com.DAO.TestDAO;
@Repository
public class TestDAO {
	@Autowired
	SessionFactory sessionfactory;
  public void insert(TestVO testvo)
	{
		try
		{
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(testvo);
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
		Query q =session.createQuery("from TestVO");
		ls=q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
	  public void delete(TestVO testvo) {
		try
		{
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(testvo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
  public List edit(TestVO testvo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from TestVO where id='"+testvo.gettestId()+"'");
		ls = q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
  public void update(TestVO testvo) {
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(testvo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}