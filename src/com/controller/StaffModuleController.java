package com.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.AssignProjectDAO;
import com.DAO.LoginDAO;
import com.DAO.ModuleDAO;
import com.DAO.ProjectDAO;
import com.DAO.StaffDAO;
import com.VO.AssignProjectVO;
import com.VO.LoginVO;
import com.VO.ModuleVO;
import com.VO.ProjectVO;
import com.VO.StaffVO;
import com.cloud.Manages3;

@Controller
public class StaffModuleController {
	@Autowired
	ModuleDAO moduleDAO;
	@Autowired
	ProjectDAO projectDAO;
	@Autowired
	LoginDAO loginDAO;
	@Autowired
	StaffDAO staffDAO;
	@Autowired
	AssignProjectDAO assignprojectDAO;
	@RequestMapping(method=RequestMethod.GET,value="staffModule")
	public ModelAndView method11(HttpSession session,@ModelAttribute ModuleVO modulevo,@ModelAttribute LoginVO lvo)
	{
		int loginId=(Integer)session.getAttribute("loginId");
		System.out.println("loginID to check:"+loginId);
		lvo.setLoginId(loginId);
		modulevo.setLvo(lvo);
		List ls=this.moduleDAO.searchmodule(modulevo);
		return new ModelAndView("staff/viewModule","data",ls);
	}
	@RequestMapping(method=RequestMethod.GET,value="staffAddModule")
	public ModelAndView method12(HttpSession session,@ModelAttribute AssignProjectVO asv,@ModelAttribute LoginVO lvo,@ModelAttribute ModuleVO mvo,@ModelAttribute StaffVO staffVO) throws SQLException
	{
		int staffid = (Integer)session.getAttribute("staffid");
		System.out.println("StaffId:"+staffid);
		staffVO.setStaffId(staffid);
		asv.setSvo(staffVO);
		List ls=this.assignprojectDAO.searchproject(asv);
		return new ModelAndView("staff/manageModule","data",new ModuleVO()).addObject("projectList",ls);
	}
	@RequestMapping(method=RequestMethod.POST,value="staffInsertModule")
	public ModelAndView method13(HttpSession session,@ModelAttribute ModuleVO modulevo,@ModelAttribute ProjectVO value,@ModelAttribute LoginVO lvo,@ModelAttribute AssignProjectVO c,@ModelAttribute StaffVO svo,HttpServletRequest request) throws SQLException
	{
		int loginId=(Integer)session.getAttribute("loginId");
		System.out.println("loginID to check:"+loginId);
		lvo.setLoginId(loginId);
		modulevo.setLvo(lvo);
		this.moduleDAO.insert(modulevo);	
		List ls2=this.moduleDAO.searchmodule(modulevo);

		session = request.getSession();
		String s1=(String) session.getAttribute("email");
		System.out.println("Email:"+s1);
		Manages3 a=new Manages3();
		int pid = modulevo.getPvo().getProjectId();
		value.setProjectId(pid);	
		String projectName = this.projectDAO.searchname(value);		
		a.createModule(s1,projectName,modulevo.getModuleName());
		
		return new ModelAndView("staff/viewModule","data",ls2);
	}
	@RequestMapping(method=RequestMethod.GET,value="staffDeleteModule")
	public ModelAndView method14(@RequestParam("id") int i) throws SQLException
	{
		ModuleVO vo=new ModuleVO();
		vo.setModuleId(i);
		this.moduleDAO.delete(vo);
		return new ModelAndView("redirect:/staffModule.htm");
	}
	@RequestMapping(method=RequestMethod.GET,value="staffEditModule")
	public ModelAndView method15(@RequestParam("id") int i) throws SQLException
	{
		ModuleVO vo=new ModuleVO();
		vo.setModuleId(i);
		List ls=this.moduleDAO.edit(vo);
		System.out.println(ls.size());
		return new ModelAndView("staff/updateModule","key",(ModuleVO)ls.get(0)).addObject("projectList",ls);
	}
	@RequestMapping(method=RequestMethod.POST,value="staffUpdateModule")
	public ModelAndView method16(@ModelAttribute ModuleVO d) throws SQLException
	{
		this.moduleDAO.update(d);
		return new ModelAndView("redirect:/staffModule.htm");
	}

}
