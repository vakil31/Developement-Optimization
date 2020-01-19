package com.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.LoginDAO;
import com.DAO.StaffDAO;
import com.VO.LoginVO;
import com.VO.StaffVO;

@Controller
public class MainController
	{

		@Autowired 
		LoginDAO logindao;
		
		@Autowired
		StaffDAO staffDAO;
	
		@RequestMapping(value={"/","index.htm"},method=RequestMethod.GET)
		public ModelAndView loadIndex() 
			{
				return new ModelAndView("admin/login");
			}
	
	
		@RequestMapping(value = "login.htm",method=RequestMethod.GET)
		public String loadLogin() 
			{
				return "admin/login";
			}
		
		@RequestMapping(value="admin.htm",method=RequestMethod.GET)
		public String admin() 
			{
				return "admin/index";
			}
		
		@RequestMapping(value = "loadstaff.htm",method=RequestMethod.GET)
		public String user(HttpSession session,@ModelAttribute LoginVO loginVO,HttpServletRequest request,@ModelAttribute StaffVO svo)
			{
			
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
				
				User user=(User)auth.getPrincipal();
				
				String userName=user.getUsername();
				
				System.out.println("userName:"+userName);
				
				LoginVO vo = (LoginVO) this.logindao.searchLoginid(userName);
				
				System.out.println("In main Controller loginId:"+ vo.getLoginId());
				session.setAttribute("email",userName);
				session.setAttribute("loginId",vo.getLoginId());
				
				LoginVO v = new LoginVO();
				v.setLoginId(vo.getLoginId());
				
				svo.setLvo(v);
				
				List staff = this.staffDAO.searchRegisterId(svo);
				
				StaffVO sv1 = (StaffVO)staff.get(0);
				
				int Staffid = sv1.getStaffId();
				
				session.setAttribute("staffid", Staffid);
				
				return "staff/indexStaff";
			}
	
		@RequestMapping(value = "403page.htm",method=RequestMethod.GET)
		public String AccessDenied()
			{
				return "staff/403page";
			}
		
		@RequestMapping(value="logout.htm",method=RequestMethod.GET)
		public String logout()
			{
				return "admin/login";
			}
}
