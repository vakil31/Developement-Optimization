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

import com.DAO.FieldDAO;
import com.DAO.FormDAO;
import com.DAO.ModuleDAO;
import com.VO.FieldVO;
import com.VO.FormVO;
import com.VO.LoginVO;
import com.VO.ModuleVO;
import com.cloud.Manages3;
@Controller
public class StaffFormController {
	@Autowired
	FormDAO formDAO;
	@Autowired
	ModuleDAO moduleDAO;
	@Autowired
	FieldDAO fieldDAO;
	@RequestMapping(method=RequestMethod.GET,value="staffForm")
	public ModelAndView methodf1(HttpSession session,@ModelAttribute LoginVO lvo,@ModelAttribute FormVO formvo)
	{
		int loginId=(Integer)session.getAttribute("loginId");
		System.out.println("LoginID of Form:"+loginId);
		lvo.setLoginId(loginId);
		formvo.setLvo(lvo);
		List ls=this.formDAO.searchform(formvo);
		return new ModelAndView("staff/viewForm","data",ls);
	}
	@RequestMapping(method=RequestMethod.GET,value="staffAddForm")
	public ModelAndView methodf2(HttpSession session,@ModelAttribute LoginVO loginvo,@ModelAttribute ModuleVO modulevo) throws SQLException
	{
		int loginId=(Integer)session.getAttribute("loginId");
		loginvo.setLoginId(loginId);
		modulevo.setLvo(loginvo);
		List ls=this.moduleDAO.searchmodule(modulevo);
		return new ModelAndView("staff/manageForm","data",new FormVO()).addObject("moduleList",ls);
	}
	@RequestMapping(method=RequestMethod.POST,value="staffInsertForm")
	public ModelAndView methodf3(@RequestParam("formName") String formName,@ModelAttribute FormVO formvo,HttpSession session,HttpServletRequest request,@ModelAttribute LoginVO lvo) throws SQLException
	{
		/*System.out.println(file.size());
		
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
	} */ 
		
		int loginId=(Integer)session.getAttribute("loginId");
		lvo.setLoginId(loginId);
		formvo.setLvo(lvo);
		this.formDAO.insert(formvo);
		
		
		String Type1[]=request.getParameterValues("fieldType");
		String Title[]=request.getParameterValues("fieldTitle");
		String Value[]=request.getParameterValues("fieldValue"); 
		FieldVO fieldvo=new FieldVO();
		fieldvo.setFormvo(formvo);
		for(int i=0,j=0,k=0;i<Type1.length;i++,j++,k++)
		{
			System.out.println("Field Type in array:"+Type1[i]);
			fieldvo.setFieldType(Type1[i]);
			fieldvo.setFieldTitle(Title[j]);
			fieldvo.setFieldValue(Value[k]);
			this.fieldDAO.insert(fieldvo);
		}	
		
		List ls=this.formDAO.searchform(formvo);
		FormVO f=(FormVO)ls.get(0);
		String email=f.getLvo().getEmail();
		String projectName=f.getMvo().getPvo().getProjectName();
		String moduleName=f.getMvo().getModuleName();
		System.out.println("PNAme::::::::::"+projectName);
		System.out.println("MNAme::::::::::"+moduleName);
		System.out.println("FNAme::::::::::"+formName);
		Manages3 a=new Manages3();
		
		List ls2=this.fieldDAO.searchfield(fieldvo);
		String JSPFilePath=com.sourcecode.SourceCodeGenerator.createJSPFile(formvo,ls2);
		
		
		String VOFilePath=com.sourcecode.SourceCodeGenerator.createVOFile(formvo,ls2);
		if(VOFilePath.contains(".java"))
		{
			String fileType="VO";
			String url=a.fileUpload(email,projectName,fileType,VOFilePath,moduleName,formName);
			System.out.println("URL:"+url);
		}
		String DAOFilePath=com.sourcecode.SourceCodeGenerator.createDAOFile(formvo,ls2);
		List ls3=this.formDAO.searchModule(formvo);
		String controllerFilePath=com.sourcecode.SourceCodeGenerator.createControllerFile(formvo,ls3);
		System.out.println(VOFilePath+DAOFilePath+controllerFilePath);
		com.sourcecode.SourceCodeGenerator.createJSPHomeFile(formvo);
		com.sourcecode.SourceCodeGenerator.createJSPSearchFile(formvo,ls2);
		com.sourcecode.SourceCodeGenerator.createJSPEditFile(formvo,ls2);
		
		return new ModelAndView("staff/viewForm","data",ls);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="staffDeleteForm")
	public ModelAndView methodf4(@RequestParam("id") int i) throws SQLException
	{
		FormVO formvo=new FormVO();
		formvo.setFormId(i);
		this.formDAO.delete(formvo);
		return new ModelAndView("redirect:/staffForm.htm");
	}
	@RequestMapping(method=RequestMethod.GET,value="staffViewFieldDetails")
	public ModelAndView methodf41(@RequestParam("id") int i,@ModelAttribute LoginVO lvo,HttpSession session) throws SQLException
	{
		int loginId=(Integer)session.getAttribute("loginId");
		lvo.setLoginId(loginId);
		
		FormVO formvo=new FormVO();
		formvo.setFormId(i);
		formvo.setLvo(lvo);
	//	List ls=this.formDAO.searchform(formvo); 
		
		FieldVO fieldvo=new FieldVO();
		fieldvo.setFormvo(formvo);
		List ls=this.fieldDAO.searchfield(fieldvo);
		return new ModelAndView("staff/viewDetails","data",ls);
	}
	@RequestMapping(method=RequestMethod.GET,value="staffAddDetails")
	public ModelAndView methodf42() throws SQLException
	{
				return new ModelAndView("redirect:/staffForm.htm");
	}
	@RequestMapping(method=RequestMethod.GET,value="staffEditForm")
	public ModelAndView methodf5(@RequestParam("id") int i) throws SQLException
	{
		FormVO formvo=new FormVO();
		List ls=this.moduleDAO.search();
		formvo.setFormId(i);
		List ls1=this.formDAO.edit(formvo);
		return new ModelAndView("staff/updateForm","key",(FormVO)ls1.get(0)).addObject("moduleList",ls);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="staffUpdateForm")
	public ModelAndView methodf6(@ModelAttribute FormVO d) throws SQLException
	{
		this.formDAO.update(d);
		return new ModelAndView("redirect:/staffForm.htm");
	}

}
