package com.controller;
import java.util.List;
import java.sql.SQLException;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;import com.VO.TestVO;
import com.DAO.TestDAO;

@Controller
public class TestController {
	@Autowired
	TestDAO testDAO;
	@RequestMapping(method=RequestMethod.GET,value="loadTest")
  public ModelAndView methodLoad1()
	{
		return new ModelAndView("AA/Test","data",new TestVO());
	}
  @RequestMapping(method=RequestMethod.POST,value="insertTest")
  public ModelAndView methodLoad2(@ModelAttribute TestVO test)
	{
       this.testDAO.insert(test);
		return new ModelAndView("redirect:/loadTest.htm");
	}
  @RequestMapping(method=RequestMethod.GET,value="searchTest")
  public ModelAndView methodSearch()
{
		List ls=this.testDAO.search();
		return new ModelAndView("AA/searchTest","data",ls);
	}
  @RequestMapping(method=RequestMethod.GET,value="deleteTest")
	public ModelAndView method14(@RequestParam("id") int i) throws SQLException
	{
		TestVO testvo=new TestVO();
		testvo.settestId(i);
		this.testDAO.delete(testvo);
		return new ModelAndView("redirect:/searchTest.htm");
	}
  @RequestMapping(method=RequestMethod.GET,value="editTest")
	public ModelAndView methodEdit(@RequestParam("id") int i) throws SQLException
	{
		TestVO testvo=new TestVO();
		testvo.settestId(i);
		List ls=this.testDAO.edit(testvo);
		return new ModelAndView("AA/updateTest","data",(TestVO)ls.get(0)).addObject("Testlist",ls);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="updateTest")
	public ModelAndView methodf6(@ModelAttribute TestVO test) throws SQLException
	{
		this.testDAO.update(test);
		return new ModelAndView("redirect:/searchTest.htm");
	}
}