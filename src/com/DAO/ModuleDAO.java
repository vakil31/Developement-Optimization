package com.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.VO.ModuleVO;
import com.VO.ModuleVO1;
import com.VO.StaffVO;

import java.util.*;

@Repository
public class ModuleDAO {

	@Autowired
	SessionFactory sessionfactory;
	public void insert(ModuleVO modulevo)
	{
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(modulevo);
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
		Query q =session.createQuery("from ModuleVO");
		ls=q.list();
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}
	public void delete(ModuleVO modulevo) {

		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(modulevo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public List edit(ModuleVO modulevo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from ModuleVO where id='"+modulevo.getModuleId()+"' ");
		ls = q.list();
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	}

	public void update(ModuleVO modulevo) {
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(modulevo);
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	public List searchmodule(ModuleVO modulevo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		//System.out.println("LS --------------------"+mvo.getLvo().getLoginId());
		Query q = session.createQuery("from ModuleVO where lvo_loginId='"+modulevo.getLvo().getLoginId()+"'");
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
	
	/*public int searchLoginid(StaffVO svo) {
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
*/

