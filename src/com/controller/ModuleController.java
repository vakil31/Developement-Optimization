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

import com.DAO.ModuleDAO;
import com.DAO.ProjectDAO;
import com.VO.FormVO;
import com.VO.ModuleVO;
import com.VO.ProjectVO;
import com.VO.StaffVO;


@Controller
public class ModuleController {
	
	@Autowired
	ModuleDAO moduleDAO;
	@Autowired
	ProjectDAO projectDAO;
	@RequestMapping(method=RequestMethod.GET,value="module")
	public ModelAndView method11()
	{
		List ls=this.moduleDAO.search();
		return new ModelAndView("admin/viewModule","data",ls);
	}
	@RequestMapping(method=RequestMethod.GET,value="addModule")
	public ModelAndView method12() throws SQLException
	{
		List ls=this.projectDAO.search();
		return new ModelAndView("admin/manageModule","data",new ModuleVO()).addObject("projectList",ls);
	}
	@RequestMapping(method=RequestMethod.POST,value="insertModule")
	public ModelAndView method13(@ModelAttribute ModuleVO c) throws SQLException
	{
		this.moduleDAO.insert(c);
		List ls=this.moduleDAO.search();
		return new ModelAndView("admin/viewModule","data",ls);
	}
	@RequestMapping(method=RequestMethod.GET,value="deleteModule")
	public ModelAndView method14(@RequestParam("id") int i) throws SQLException
	{
		ModuleVO vo=new ModuleVO();
		vo.setModuleId(i);
		this.moduleDAO.delete(vo);
		return new ModelAndView("redirect:/module.htm");
	}
	@RequestMapping(method=RequestMethod.GET,value="editModule")
	public ModelAndView method15(@RequestParam("id") int i) throws SQLException
	{
		ModuleVO vo=new ModuleVO();
		vo.setModuleId(i);
		List ls=this.moduleDAO.edit(vo);
		System.out.println(ls.size());
		return new ModelAndView("admin/updateModule","key",(ModuleVO)ls.get(0)).addObject("projectList",ls);
	}
	@RequestMapping(method=RequestMethod.POST,value="updateModule")
	public ModelAndView method16(@ModelAttribute ModuleVO d) throws SQLException
	{
		this.moduleDAO.update(d);
		return new ModelAndView("redirect:/module.htm");
	}
	
}
