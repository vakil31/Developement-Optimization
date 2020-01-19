package com.controller;
import java.util.List;
import java.sql.SQLException;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;import com.VO.VO;
import com.DAO.DAO;

@Controller
public class Controller {
	@Autowired
	DAO DAO;
	@RequestMapping(method=RequestMethod.GET,value="load")
  public ModelAndView methodLoad1()
	{
		return new ModelAndView("FF/","data",new VO());
	}
  @RequestMapping(method=RequestMethod.POST,value="insert")
  public ModelAndView methodLoad2(@ModelAttribute VO )
	{
       this.DAO.insert();
		return new ModelAndView("redirect:/load.htm");
	}
  @RequestMapping(method=RequestMethod.GET,value="search")
  public ModelAndView methodSearch()
{
		List ls=this.DAO.search();
		return new ModelAndView("FF/search","data",ls);
	}
  @RequestMapping(method=RequestMethod.GET,value="delete")
	public ModelAndView method14(@RequestParam("id") int i) throws SQLException
	{
		VO vo=new VO();
		vo.setId(i);
		this.DAO.delete(vo);
		return new ModelAndView("redirect:/search.htm");
	}
  @RequestMapping(method=RequestMethod.GET,value="edit")
	public ModelAndView methodEdit(@RequestParam("id") int i) throws SQLException
	{
		VO vo=new VO();
		vo.setId(i);
		List ls=this.DAO.edit(vo);
		return new ModelAndView("FF/update","data",(VO)ls.get(0)).addObject("list",ls);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="update")
	public ModelAndView methodf6(@ModelAttribute VO ) throws SQLException
	{
		this.DAO.update();
		return new ModelAndView("redirect:/search.htm");
	}
}