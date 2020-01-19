package com.controller;

import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.DeptDAO;
import com.DAO.LoginDAO;
import com.DAO.StaffDAO;
import com.VO.DeptVO;
import com.VO.LoginVO;
import com.VO.StaffVO;
import com.cloud.Manages3;

@Controller
public class StaffController {
	
	@Autowired
	StaffDAO staffDAO;
	@Autowired
	DeptDAO deptDAO;
	@Autowired
	LoginDAO loginDAO;
	/*@RequestMapping(method=RequestMethod.GET,value="add")
	public ModelAndView method1()
	{
		
		return new ModelAndView("admin/index");
	} */
	@RequestMapping(method=RequestMethod.GET,value="viewstaff")
	public ModelAndView method11()
	{
		List ls=this.staffDAO.search();
		return new ModelAndView("admin/viewStaff","data",ls);
	}
	@RequestMapping(method=RequestMethod.GET,value="addStaff")
	public ModelAndView method12() throws SQLException
	{
		List ls=this.deptDAO.search();	
		return new ModelAndView("admin/manageStaff","data",new StaffVO()).addObject("deptList",ls);
	}
/*	@RequestMapping(method=RequestMethod.POST,value="insert")
	public ModelAndView method13(@ModelAttribute StaffVO c) throws SQLException
	{
		this.staffDAO.insert(c);
		List ls=this.staffDAO.search();
		return new ModelAndView("admin/viewStaff","data",ls);
	}
*/	
	@RequestMapping(method=RequestMethod.POST,value="insertStaff")
	public ModelAndView method1(@ModelAttribute StaffVO staffvo) throws SQLException
	{
		LoginVO l=new LoginVO();
		l.setEmail(staffvo.getLvo().getEmail());
		l.setPassword(staffvo.getLvo().getPassword());
		l.setRole("ROLE_STAFF");
		l.setEnable(1);
		this.loginDAO.insert(l);
		staffvo.setLvo(l);
		this.staffDAO.insert(staffvo);
		Manages3 a=new Manages3();
		a.createUser(staffvo.getLvo().getEmail());
		return new ModelAndView("redirect:/viewstaff.htm"); //("admin/viewProject","dataProject",ls)
		
	}
	@RequestMapping(method=RequestMethod.GET,value="deleteStaff")
	public ModelAndView method14(@RequestParam("id") int i) throws SQLException
	{
		StaffVO vo=new StaffVO();
		vo.setStaffId(i);
		this.staffDAO.delete(vo);
		return new ModelAndView("redirect:/viewstaff.htm");
	}
	@RequestMapping(method=RequestMethod.GET,value="editStaff")
	public ModelAndView method15(@RequestParam("id") int i) throws SQLException
	{
		StaffVO staffvo=new StaffVO();
		List ls=this.deptDAO.search();
		staffvo.setStaffId(i);
		List ls1=this.staffDAO.edit(staffvo);
		System.out.println(ls.size());
		return new ModelAndView("admin/updateStaff","key",(StaffVO)ls1.get(0)).addObject("deptList",ls);
	}
	@RequestMapping(method=RequestMethod.POST,value="updateStaff")
	public ModelAndView method16(@ModelAttribute StaffVO staffvo) throws SQLException
	{
		System.out.println(staffvo.getLvo().getEmail()+staffvo.getLvo().getLoginId());
		
		LoginVO loginvo=new LoginVO();	
		
		loginvo.setLoginId(staffvo.getLvo().getLoginId());

		loginvo.setEmail(staffvo.getLvo().getEmail());
		
		this.loginDAO.update(loginvo);
		
		staffvo.setLvo(loginvo);
		
     	this.staffDAO.update(staffvo);
		
     	return new ModelAndView("redirect:/viewstaff.htm");
	}
	@RequestMapping(method=RequestMethod.GET,value="dept")
	public ModelAndView method21()
	{
		List ls=this.deptDAO.search();
		return new ModelAndView("admin/viewDept","data",ls);
	}
	@RequestMapping(method=RequestMethod.GET,value="addDept")
	public ModelAndView method22() throws SQLException
	{
		return new ModelAndView("admin/manageDept","data",new DeptVO());
	}
	@RequestMapping(method=RequestMethod.POST,value="insertDept")
	public ModelAndView method23(@ModelAttribute DeptVO c) throws SQLException
	{
		this.deptDAO.insert(c);
		List ls=this.deptDAO.search();
		return new ModelAndView("admin/viewDept","data",ls);
	}
	@RequestMapping(method=RequestMethod.GET,value="deleteDept")
	public ModelAndView method24(@RequestParam("id") int i) throws SQLException
	{
		DeptVO vo=new DeptVO();
		vo.setDeptId(i);
		this.deptDAO.delete(vo);
		return new ModelAndView("redirect:/dept.htm");
	}
	@RequestMapping(method=RequestMethod.GET,value="editDept")
	public ModelAndView method25(@RequestParam("id") int i) throws SQLException
	{
		DeptVO vo=new DeptVO();
		vo.setDeptId(i);
		List ls=this.deptDAO.edit(vo);
		return new ModelAndView("admin/updateDept","key",(DeptVO)ls.get(0));
	}
	@RequestMapping(method=RequestMethod.POST,value="updateDept")
	public ModelAndView method26(@RequestParam("deptId") int i,@RequestParam("dept") String dept) throws SQLException
	{
		DeptVO vo=new DeptVO();
		vo.setDeptId(i);;
		vo.setDept(dept);
		this.deptDAO.update(vo);
		return new ModelAndView("redirect:/dept.htm");
	}
}
