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
import com.VO.DoctorVO;
import com.DAO.DoctorDAO;

@Controller
public class DoctorController {
	@Autowired
	DoctorDAO doctorDAO;
	@RequestMapping(method=RequestMethod.POST,value="insertDoctor")
  public ModelAndView method11()
	{
		return new ModelAndView("AA/Doctor","data",new DoctorVO());
	}}