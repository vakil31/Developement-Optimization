package com.DAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.NishiVO;
import com.DAO.NishiDAO;
@Repository
public class NishiDAO {
	@Autowired
	SessionFactory sessionfactory;
  public void insert(NishiVO nishivo)
	{
		try
		{
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(nishivo);
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
		Query q =session.createQuery("from NishiVO");
		ls=q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
	  public void delete(NishiVO nishivo) {

		try
		{
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(nishivo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
  public List edit(NishiVO nishivo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from NishiVO where id='"+nishivo.getNishiId()+"'");
		ls = q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
  public void update(NishiVO nishivo) {
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(nishivo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}}