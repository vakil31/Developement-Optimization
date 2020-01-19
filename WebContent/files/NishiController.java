package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.VO.NishiVO;
import com.DAO.NishiDAO;

@Controller
public class NishiController {
	@Autowired
	NishiDAO nishiDAO;
	@RequestMapping(method=RequestMethod.GET,value="loadNishi")
  public ModelAndView methodLoad1()
	{
		return new ModelAndView("AA/Nishi","data",new NishiVO());	}@RequestMapping(method=RequestMethod.POST,value="insertNishi")  public ModelAndView methodLoad2(@ModelAttribute NishiVO nishi)
	{
       this.nishiDAO.insert(nishi);
		return new ModelAndView("redirect:/loadNishi.htm");
	}}