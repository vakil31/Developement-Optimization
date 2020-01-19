package com.DAO;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.StaffVO;

@Repository

public class StaffDAO {
	@Autowired
	SessionFactory sessionfactory;
	public void insert(StaffVO staffvo)
	{
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(staffvo);
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
		Query q =session.createQuery("from StaffVO");
		ls=q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
	
	public void delete(StaffVO countryvo) {

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

	public List edit(StaffVO staffvo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from StaffVO where id='"+staffvo.getStaffId()+"' ");
		ls = q.list();
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}

	public void update(StaffVO staffvo) {

		
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(staffvo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	public int searchLoginid(StaffVO svo) {
		List ls= new ArrayList();
		int staffid = 0;
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from StaffVO where id='"+svo.getStaffId()+"' ");
		ls = q.list();
		session.close();
		StaffVO v=(StaffVO)ls.get(0);
		
		staffid = v.getLvo().getLoginId();
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	return staffid;
	}

	public List searchRegisterId(StaffVO svo) {
		
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from StaffVO where lvo_loginId='"+svo.getLvo().getLoginId()+"' ");
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
