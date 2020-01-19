package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.FieldDAO;
import com.DAO.FormDAO;
import com.DAO.ModuleDAO;
import com.VO.FieldVO;
import com.VO.FormVO;
import com.VO.ModuleVO;

@Controller
public class FormController {
	@Autowired
	FormDAO formDAO;
	@Autowired
	ModuleDAO moduleDAO;
	@Autowired
	FieldDAO fieldDAO;
	@RequestMapping(method=RequestMethod.GET,value="form")
	public ModelAndView methodf11()
	{
		List ls=this.formDAO.search();
		return new ModelAndView("admin/viewForm","data",ls);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="addForm")
	public ModelAndView methodf21() throws SQLException
	{
		List ls=this.moduleDAO.search();
		return new ModelAndView("admin/manageForm","data",new FormVO()).addObject("moduleList",ls);
	}
	@RequestMapping(method=RequestMethod.POST,value="/insertForm")
	public ModelAndView methodf31(@ModelAttribute FormVO c,HttpSession session,HttpServletRequest request)
	{   
		this.formDAO.insert(c);
	
	
		String Type1[]=request.getParameterValues("fieldType");
		String Title[]=request.getParameterValues("fieldTitle");
		String Value[]=request.getParameterValues("fieldValue"); 
		FieldVO fieldvo=new FieldVO();
		fieldvo.setFormvo(c);
		for(int i=0,j=0,k=0;i<Type1.length;i++,j++,k++)
		{
			System.out.println("Field Type in array:"+Type1[i]);
			fieldvo.setFieldType(Type1[i]);
			fieldvo.setFieldTitle(Title[j]);
			fieldvo.setFieldValue(Value[k]);
			this.fieldDAO.insert(fieldvo);

		} 
			
	/*  for(String s:Type1)
		{
			System.out.println("Field Type in array:"+s);
			fieldvo.setFieldType(s);
			//this.fieldDAO.insert(fieldvo);

		} 
		
		for(String K:Title)
		{
			System.out.println("Field Title in array:"+K);
			fieldvo.setFieldTitle(K);
			//this.fieldDAO.insert(fieldvo);
		}
		for(String J:Value)
		{
			System.out.println("Field Value in array:"+J);
			fieldvo.setFieldValue(J);
			//this.fieldDAO.insert(fieldvo);
		}
		fieldvo.setFormvo(c);
		this.fieldDAO.insert(fieldvo);  */
	    List ls=this.formDAO.search();
		return new ModelAndView("admin/viewForm","data",ls);
		
	/*	System.out.println(file.size());
		for(int j=0;j<file.size();j++)
		{
		String path=session.getServletContext().getRealPath("/");
		
		String pathFInal=path+"\\doc";
		System.out.println("path---------------------"+pathFInal);
		
		
        String filename=file.get(j).getOriginalFilename();  
        System.out.println(filename);
        System.out.println("file name........!!!!"+filename);
        
        System.out.println(path+" "+filename);  
        try{  
        byte barr[]=file.get(j).getBytes();  
          
        BufferedOutputStream bout=new BufferedOutputStream(  
                 new FileOutputStream(pathFInal+"\\"+filename));  
        bout.write(barr);  
        bout.flush();  
        bout.close();  
          
        }catch(Exception e){
        	System.out.println(e);
        	}
        c.setFileName(filename);
        c.setFilePath(pathFInal);
        
        this.formDAO.insert(c);
		
		}*/	
	}
	@RequestMapping(method=RequestMethod.GET,value="deleteForm")
	public ModelAndView method401(@RequestParam("id") int i) throws SQLException
	{
		FormVO formvo=new FormVO();
		formvo.setFormId(i);
		this.formDAO.delete(formvo);
		return new ModelAndView("redirect:/form.htm");
	}
	@RequestMapping(method=RequestMethod.GET,value="viewFieldDetails")
	public ModelAndView methodf411(@RequestParam("id") int i) throws SQLException
	{
		FormVO formvo=new FormVO();
		formvo.setFormId(i);
		FieldVO fieldvo=new FieldVO();
		fieldvo.setFormvo(formvo);
		List ls=this.fieldDAO.search();
		return new ModelAndView("admin/viewDetails","data",ls);
	}
	@RequestMapping(method=RequestMethod.GET,value="addDetails")
	public ModelAndView methodf421() throws SQLException
	{
				return new ModelAndView("redirect:/form.htm");
	}
	@RequestMapping(method=RequestMethod.GET,value="editForm")
	public ModelAndView methodf51(@RequestParam("id") int i) throws SQLException
	{
		FormVO formvo=new FormVO();
		List ls=this.moduleDAO.search();
		formvo.setFormId(i);
		List ls1=this.formDAO.edit(formvo);
		return new ModelAndView("admin/updateForm","key",(FormVO)ls1.get(0)).addObject("moduleList",ls);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="updateForm")
	public ModelAndView methodf61(@ModelAttribute FormVO d) throws SQLException
	{
		this.formDAO.update(d);
		return new ModelAndView("redirect:/form.htm");
	}

}
