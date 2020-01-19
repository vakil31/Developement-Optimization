package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.VO.LJVO;
import com.DAO.LJDAO;

@Controller
public class LJController {
	@Autowired
	LJDAO ljDAO;
	@RequestMapping(method=RequestMethod.GET,value="loadLJ")
  public ModelAndView methodLoad1()
	{
		return new ModelAndView("AA/LJ","data",new LJVO());	}@RequestMapping(method=RequestMethod.POST,value="insertLJ")  public ModelAndView methodLoad2(@ModelAttribute LJVO lj)
	{
       this.ljDAO.insert(lj);
		return new ModelAndView("redirect:/loadLJ.htm");
	}}