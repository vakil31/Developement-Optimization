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

import com.DAO.AssignProjectDAO;
import com.DAO.LoginDAO;
import com.DAO.ProjectDAO;
import com.DAO.StaffDAO;
import com.VO.AssignProjectVO;
import com.VO.LoginVO;
import com.VO.ProjectVO;
import com.VO.StaffVO;
import com.cloud.Manages3;

@Controller
public class AssignProjectController {
	@Autowired
	ProjectDAO projectDAO;
	@Autowired
	StaffDAO staffDAO;
	@Autowired
	AssignProjectDAO assignProjectDAO;
	@Autowired
	LoginDAO ldao;
	
	@RequestMapping(method=RequestMethod.GET,value="assignProject")
	public ModelAndView method11()
	{
		List ls=this.assignProjectDAO.search();
		return new ModelAndView("admin/viewAssignProject","data",ls);
	}
	@RequestMapping(method=RequestMethod.GET,value="addAssignProject")
	public ModelAndView method12() throws SQLException
	{
		List ls=this.projectDAO.search();
		List ls1=this.staffDAO.search();
		return new ModelAndView("admin/manageAssignProject","data",new AssignProjectVO()).addObject("projectList",ls).addObject("staffList",ls1);
	}
	@RequestMapping(method=RequestMethod.GET,value="insertAssignProject")
	public ModelAndView method13(@ModelAttribute ProjectVO value,@ModelAttribute LoginVO lvo,@ModelAttribute AssignProjectVO c,@ModelAttribute StaffVO svo) throws SQLException
	{

		int pid = c.getPvo().getProjectId();
		int sid = c.getSvo().getStaffId();
		value.setProjectId(pid);
		
		String projectName = this.projectDAO.searchname(value);
		
		svo.setStaffId(sid);
		int loginid = this.staffDAO.searchLoginid(svo);
		lvo.setLoginId(loginid);
		String email = this.ldao.searchemail(lvo);
		
		System.out.println(projectName +" " +email+"--------------------->>>>>>>>>>>>");
		
		this.assignProjectDAO.insert(c);
		System.out.println("C Id -----------"+c.getAssignProjectId());
		
		
		Manages3 s3 = new Manages3();
		s3.createProject(email ,projectName);
		
		List ls=this.assignProjectDAO.search();
		return new ModelAndView("admin/viewAssignProject","data",ls);
	}
	@RequestMapping(method=RequestMethod.GET,value="deleteAssignProject")
	public ModelAndView method14(@RequestParam("id") int i) throws SQLException
	{
		AssignProjectVO vo=new AssignProjectVO();
		vo.setAssignProjectId(i);
		this.assignProjectDAO.delete(vo);
		return new ModelAndView("redirect:/assignProject.htm");
	}
	@RequestMapping(method=RequestMethod.GET,value="editAssignProject")
	public ModelAndView method15(@RequestParam("id") int i) throws SQLException
	{
		AssignProjectVO assignvo=new AssignProjectVO();
		List ls=this.projectDAO.search();
		List ls1=this.projectDAO.search();
		assignvo.setAssignProjectId(i);
		List ls2=this.assignProjectDAO.edit(assignvo);
		System.out.println(ls.size());
		return new ModelAndView("admin/updateAssignProject","key",(AssignProjectVO)ls.get(0)).addObject("projectList",ls1).addObject("staffList",ls2);
	}
	@RequestMapping(method=RequestMethod.GET,value="updateAssignProject")
	public ModelAndView method16(@ModelAttribute AssignProjectVO d) throws SQLException
	{
		this.assignProjectDAO.update(d);
		return new ModelAndView("redirect:/assignProject.htm");
	}

}
