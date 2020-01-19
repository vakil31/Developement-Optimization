package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.ProjectDAO;
import com.VO.ProjectVO;
import com.VO.StaffVO;


@Controller
public class ProjectController {

	@Autowired
	ProjectDAO projectDAO;
	/*@RequestMapping(method=RequestMethod.GET,value="add")
	public ModelAndView method1()
	{
		
		return new ModelAndView("admin/index");
	} */
	@RequestMapping(method=RequestMethod.GET,value="project")
	public ModelAndView method11()
	{
		List ls=this.projectDAO.search();
		return new ModelAndView("admin/viewProject","dataProject",ls);
	}
	@RequestMapping(method=RequestMethod.GET,value="addProject")
	public ModelAndView method12() throws SQLException
	{
		return new ModelAndView("admin/manageProject","dataProject",new ProjectVO());
	}
	@RequestMapping(method=RequestMethod.POST,value="insertProject")
	public ModelAndView method13(@ModelAttribute ProjectVO c) throws SQLException
	{
		System.out.println(c.getProjectName() + " "+c.getProjectDetails() + ""+c.getProjectId());
		this.projectDAO.insert(c);
		List ls=this.projectDAO.search();
		return new ModelAndView("admin/viewProject","dataProject",ls);
	}
	@RequestMapping(method=RequestMethod.GET,value="deleteProject")
	public ModelAndView method14(@RequestParam("id") int i) throws SQLException
	{
		ProjectVO vo=new ProjectVO();
		vo.setProjectId(i);
		this.projectDAO.delete(vo);
		return new ModelAndView("redirect:/project.htm");
	}
	@RequestMapping(method=RequestMethod.GET,value="editProject")
	public ModelAndView method15(@RequestParam("id") int i) throws SQLException
	{
		ProjectVO vo=new ProjectVO();
		vo.setProjectId(i);
		List ls=this.projectDAO.edit(vo);
		return new ModelAndView("admin/updateProject","key",(ProjectVO)ls.get(0));
		
	}
	@RequestMapping(method=RequestMethod.POST,value="updateProject")
	public ModelAndView method16(@ModelAttribute ProjectVO d) throws SQLException
	{
		this.projectDAO.update(d);
		return new ModelAndView("redirect:/project.htm");
	}
	
}
