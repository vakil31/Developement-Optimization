package com.controller;
import java.util.List;
import java.sql.SQLException;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;import com.VO.DemoVO;
import com.DAO.DemoDAO;

@Controller
public class DemoController {
	@Autowired
	DemoDAO demoDAO;
	@RequestMapping(method=RequestMethod.GET,value="loadDemo")
  public ModelAndView methodLoad1()
	{
		return new ModelAndView("AA/Demo","data",new DemoVO());
	}
  @RequestMapping(method=RequestMethod.POST,value="insertDemo")
  public ModelAndView methodLoad2(@ModelAttribute DemoVO demo)
	{
       this.demoDAO.insert(demo);
		return new ModelAndView("redirect:/loadDemo.htm");
	}
  @RequestMapping(method=RequestMethod.GET,value="searchDemo")
  public ModelAndView methodSearch()
{
		List ls=this.demoDAO.search();
		return new ModelAndView("AA/searchDemo","data",ls);
	}
  @RequestMapping(method=RequestMethod.GET,value="deleteDemo")
	public ModelAndView method14(@RequestParam("id") int i) throws SQLException
	{
		DemoVO demovo=new DemoVO();
		demovo.setdemoId(i);
		this.demoDAO.delete(demovo);
		return new ModelAndView("redirect:/searchDemo.htm");
	}
  @RequestMapping(method=RequestMethod.GET,value="editDemo")
	public ModelAndView methodEdit(@RequestParam("id") int i) throws SQLException
	{
		DemoVO demovo=new DemoVO();
		demovo.setdemoId(i);
		List ls=this.demoDAO.edit(demovo);
		return new ModelAndView("AA/updateDemo","data",(DemoVO)ls.get(0)).addObject("Demolist",ls);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="updateDemo")
	public ModelAndView methodf6(@ModelAttribute DemoVO demo) throws SQLException
	{
		this.demoDAO.update(demo);
		return new ModelAndView("redirect:/searchDemo.htm");
	}
}