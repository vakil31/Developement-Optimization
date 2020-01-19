package com.controller;
import java.util.List;
import java.sql.SQLException;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;import com.VO.BoreVO;
import com.DAO.BoreDAO;

@Controller
public class BoreController {
	@Autowired
	BoreDAO boreDAO;
	@RequestMapping(method=RequestMethod.GET,value="loadBore")
  public ModelAndView methodLoad1()
	{
		return new ModelAndView("AA/Bore","data",new BoreVO());
	}
  @RequestMapping(method=RequestMethod.POST,value="insertBore")
  public ModelAndView methodLoad2(@ModelAttribute BoreVO bore)
	{
       this.boreDAO.insert(bore);
		return new ModelAndView("redirect:/loadBore.htm");
	}
  @RequestMapping(method=RequestMethod.GET,value="searchBore")
  public ModelAndView methodSearch()
{
		List ls=this.boreDAO.search();
		return new ModelAndView("AA/searchBore","data",ls);
	}
  @RequestMapping(method=RequestMethod.GET,value="deleteBore")
	public ModelAndView method14(@RequestParam("id") int i) throws SQLException
	{
		BoreVO borevo=new BoreVO();
		borevo.setboreId(i);
		this.boreDAO.delete(borevo);
		return new ModelAndView("redirect:/searchBore.htm");
	}
  @RequestMapping(method=RequestMethod.GET,value="editBore")
	public ModelAndView methodEdit(@RequestParam("id") int i) throws SQLException
	{
		BoreVO borevo=new BoreVO();
		borevo.setboreId(i);
		List ls=this.boreDAO.edit(borevo);
		return new ModelAndView("AA/updateBore","data",(BoreVO)ls.get(0)).addObject("Borelist",ls);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="updateBore")
	public ModelAndView methodf6(@ModelAttribute BoreVO bore) throws SQLException
	{
		this.boreDAO.update(bore);
		return new ModelAndView("redirect:/searchBore.htm");
	}
}