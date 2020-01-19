package com.DAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.LJVO;
import com.DAO.LJDAO;
@Repository
public class LJDAO {
	@Autowired
	SessionFactory sessionfactory;
  public void insert(LJVO ljvo)
	{
		try
		{
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(ljvo);
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
		Query q =session.createQuery("from LJVO");
		ls=q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
	  public void delete(LJVO ljvo) {

		try
		{
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(ljvo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
  public List edit(LJVO ljvo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from LJVO where id='"+ljvo.getLJId()+"'");
		ls = q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
  public void update(LJVO ljvo) {
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(ljvo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}}