package com.DAO;

import java.util.ArrayList;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.DeptVO;

@Repository
public class DeptDAO {
	@Autowired
	SessionFactory sessionfactory;
	public void insert(DeptVO deptvo)
	{
		try
		{		
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(deptvo);
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
		Query q =session.createQuery("from DeptVO");
		ls=q.list();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
	
	public void delete(DeptVO deptvo) {

		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(deptvo);
			tr.commit();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public List edit(DeptVO deptvo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from DeptVO where id='"+deptvo.getDeptId()+"' ");
		ls = q.list();

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}

	public void update(DeptVO deptvo) {
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(deptvo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}
