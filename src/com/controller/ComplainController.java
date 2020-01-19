//package com.controller;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//
//public class ComplainController {
//	@RequestMapping(method=RequestMethod.GET,value="complain")
//	public ModelAndView method21()
//	{
//		List ls=this.deptDAO.search();
//		return new ModelAndView("admin/viewDept","data",ls);
//	}
//	@RequestMapping(method=RequestMethod.GET,value="addDept")
//	public ModelAndView method22() throws SQLException
//	{
//		return new ModelAndView("admin/manageDept","data",new DeptVO());
//	}
//	@RequestMapping(method=RequestMethod.POST,value="insertDept")
//	public ModelAndView method23(@ModelAttribute DeptVO c) throws SQLException
//	{
//		this.deptDAO.insert(c);
//		List ls=this.deptDAO.search();
//		return new ModelAndView("admin/viewDept","data",ls);
//	}
//	@RequestMapping(method=RequestMethod.GET,value="deleteDept")
//	public ModelAndView method24(@RequestParam("id") int i) throws SQLException
//	{
//		DeptVO vo=new DeptVO();
//		vo.setDeptId(i);
//		this.deptDAO.delete(vo);
//		return new ModelAndView("redirect:/dept.htm");
//	}
//	@RequestMapping(method=RequestMethod.GET,value="editDept")
//	public ModelAndView method25(@RequestParam("id") int i) throws SQLException
//	{
//		DeptVO vo=new DeptVO();
//		vo.setDeptId(i);
//		List ls=this.deptDAO.edit(vo);
//		return new ModelAndView("admin/updateDept","key",(DeptVO)ls.get(0));
//	}
//	@RequestMapping(method=RequestMethod.POST,value="updateDept")
//	public ModelAndView method26(@RequestParam("deptId") int i,@RequestParam("dept") String dept) throws SQLException
//	{
//		DeptVO vo=new DeptVO();
//		vo.setDeptId(i);;
//		vo.setDept(dept);
//		this.deptDAO.update(vo);
//		return new ModelAndView("redirect:/dept.htm");
//	}
//
//
//}
