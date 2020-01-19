package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.FormVO;


@Repository
public class FormDAO {
	@Autowired
	SessionFactory sessionfactory;
	public void insert(FormVO formvo)
	{
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(formvo);
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
		Query q =session.createQuery("from FormVO");
		ls=q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
	
	public void delete(FormVO formvo) {

		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(formvo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public List edit(FormVO formvo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from FormVO where id='"+formvo.getFormId()+"' ");
		ls = q.list();
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}

	public void update(FormVO formvo) {
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(formvo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	public List searchform(FormVO formvo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		//System.out.println("LS --------------------"+mvo.getLvo().getLoginId());
		Query q = session.createQuery("from FormVO where lvo_loginId='"+formvo.getLvo().getLoginId()+"'");
		ls = q.list();
		session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return ls;
		}
	public List searchModule(FormVO formvo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		//System.out.println("LS --------------------"+mvo.getLvo().getLoginId());
		Query q = session.createQuery("from FormVO where mvo_moduleId='"+formvo.getMvo().getModuleId()+"'");
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
