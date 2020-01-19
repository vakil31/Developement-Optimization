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
import com.VO.LoginVO;
import com.VO.StaffVO;



@Repository
public class LoginDAO {
	@Autowired
	SessionFactory sessionfactory;
	public void insert(LoginVO loginvo)
	{
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			//LoginVO.setRole("");
			session.save(loginvo);
			tr.commit();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
/*	public List edit(LoginVO loginvo) {
		List ls= new ArrayList();
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from LoginVO where id='"+loginvo.getLoginId()+"' ");
		ls = q.list();
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return ls;
	} */

    public void update(LoginVO loginvo) {

		
		try
		{
			
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			Query query=session.createQuery("update LoginVO set email='"+loginvo.getEmail()+"' where loginId='"+loginvo.getLoginId()+"'");
			query.executeUpdate();
			tr.commit();
			session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	public String searchemail(LoginVO lvo) {
		
		List ls= new ArrayList();
		String staffid = "";
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from LoginVO where loginid='"+lvo.getLoginId()+"' ");
		ls = q.list();
		session.close();
		LoginVO v=(LoginVO)ls.get(0);
		
		staffid = v.getEmail();
		
		System.out.println(staffid);
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	return staffid;
		
	}

	/*public List getLoginId(LoginVO loginVO) {
		// TODO Auto-generated method stub
		List ls= new ArrayList();
		
		try
		{
			Session session = sessionfactory.openSession();
			Query q = session.createQuery("from LoginVO where email='"+loginVO.getEmail()+"' ");
			ls = q.list();
			session.close();
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	return ls;
	} */
	public LoginVO searchLoginid(String userName) {
		List ls;
		try
		{
		Session session = sessionfactory.openSession();
		Query q = session.createQuery("from LoginVO where email='"+ userName+"' ");
		ls = q.list();
		session.close();
		LoginVO v=(LoginVO)ls.get(0);
		return v;
		}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
	}
}
