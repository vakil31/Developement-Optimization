package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.VO.InnoventaVO;
import com.DAO.InnoventaDAO;

@Controller
public class InnoventaController {
	@Autowired
	InnoventaDAO innoventaDAO;
	@RequestMapping(method=RequestMethod.GET,value="loadInnoventa")
  public ModelAndView methodLoad1()
	{
		return new ModelAndView(AA/"/Innoventa","data",new InnoventaVO());
	}@RequestMapping(method=RequestMethod.POST,value="insertInnoventa")  public ModelAndView methodLoad2(@ModelAttribute InnoventaVO innoventa)
	{
       this.InnoventaDAO.insert(innoventa);		return new ModelAndView("redirect:/loadInnoventa.htm");
	}}