package com.sourcecode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;


import com.VO.FieldVO;
import com.VO.FormVO;

public class SourceCodeGenerator {
	public static String createJSPFile(FormVO formvo,List ls)
	{
		try
		{
		File f=new File("/Users/zeba/innoventa-workspace/final_project/WebContent/files/JSP");
		f.mkdir();
		String formName=formvo.getFormName();
		File f1=new File("/Users/zeba/innoventa-workspace/final_project/WebContent/files/JSP/"+formName+".jsp");
		FileWriter fw=new FileWriter("/Users/zeba/innoventa-workspace/final_project/WebContent/files/"+formName+".jsp");
		BufferedWriter bw=new BufferedWriter(fw);
		String path=f1.getAbsolutePath();
		bw.write("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n" + 	"    pageEncoding=\"UTF-8\"%>\n");
		bw.write("<%@taglib uri=\"http://www.springframework.org/tags/form\" prefix=\"f\" %>\n");
		bw.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" + 
				"<html>\n" + 	"<head>\n"+"<title>\n"+"</title>\n"+"</head>\n"+"<body>\n");
		bw.write("<f:form id=\"defaultForm\" method=\"post\" modelAttribute=\"data\" class=\"form-horizontal\" action=\"insert"+formName+".htm\">\n");
		int len=ls.size();
		for(int i=0;i<len;i++)
		{
			FieldVO v=(FieldVO)ls.get(i);
			//String fieldType = v.getFieldType();
			if(v.getFieldType().equals("text"))
			{
				bw.write(v.getFieldTitle()+":<f:input path=\""+v.getFieldTitle().toLowerCase()+"\" value=\"\"  />\n");
			}
			if(v.getFieldType().equals("textarea"))
			{
				bw.write(v.getFieldTitle()+":<f:textarea path=\""+v.getFieldTitle().toLowerCase()+"\" value=\"\"  />\n");
			}
			if(v.getFieldType().equals("radiobutton"))
			{
				String a=v.getFieldValue();
				String b[]=a.split(",");
				for(String str:b)
				{
				bw.write(v.getFieldTitle()+":<f:radiobutton path=\""+v.getFieldTitle().toLowerCase()+"\" value=\""+str+"\"  /> \n");
				}
				//bw.write(v.getFieldTitle()+":<f:radiobutton path=\""+v.getFieldTitle().toLowerCase()+"\" value=\""+v.getFieldValue()+"\"  /> \n");
				
			}
			if(v.getFieldType().equals("checkboxes"))
			{
				bw.write(v.getFieldTitle()+":<f:checkboxes path=\""+v.getFieldTitle().toLowerCase()+"List\" items=\"${"+v.getFieldTitle().toLowerCase()+"List}\" itemValue=\"data\" itemLabel=\"value\" />\n");
			}
			if(v.getFieldType().equals("checkbox"))
			{
				bw.write("<form:checkbox path=\""+v.getFieldTitle().toLowerCase()+"List\" label=\""+v.getFieldValue()+"\" />");
			}
		}
		bw.write("<input type=\"submit\" name=\"submit\" value=\"Click\"></input>\n");
		bw.write("</f:form>\n");
		bw.write("</body>\n");
		bw.write("</html>");
		bw.close();
		fw.close(); 
		return path;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static String createVOFile(FormVO formvo,List ls)
	{
		try
		{
		String formName=formvo.getFormName();
		File f=new File("/Users/zeba/innoventa-workspace/final_project/WebContent/files/VO");
		f.mkdir();
		File f1=new File("/Users/zeba/innoventa-workspace/final_project/WebContent/files/VO/"+formName+"VO.java");
		FileWriter fw=new FileWriter("/Users/zeba/innoventa-workspace/final_project/WebContent/files/VO/"+formName+"VO.java");
		BufferedWriter bw=new BufferedWriter(fw);
		String path=f1.getAbsolutePath();
		//FieldVO v=(FieldVO)ls.get(0);
		bw.write("package com.VO;\n");
		bw.write("import javax.persistence.Column;\n" + 
				"import javax.persistence.Entity;\n" + 
				"import javax.persistence.GeneratedValue;\n" + 
				"import javax.persistence.GenerationType;\n" + 
				"import javax.persistence.Id;\n" + 
				"import javax.persistence.Table;\n" + 
				"\n" + 
				"@Entity\n");
		bw.write("@Table(name=\""+formName+"\")\n");
		bw.write("public class "+ formName+"VO {\n" + 
				"	@Id\n" + 
				"	@GeneratedValue(strategy=GenerationType.AUTO)\n" + 
				"	private int "+ formName.toLowerCase()+"Id;\n" );
		
		int len=ls.size();
		for(int i=0;i<len;i++)
		{
			FieldVO v=(FieldVO)ls.get(i);
			bw.write("	@Column(name=\""+v.getFieldTitle().toLowerCase()+"\")\n" + 
					"	private String "+v.getFieldTitle().toLowerCase()+";\n");
			bw.write("  public String get"+v.getFieldTitle().toLowerCase()+"() {\n" + 
					"		return "+v.getFieldTitle().toLowerCase()+";\n" + 
					"	}\n" + 
					"	public void set"+v.getFieldTitle().toLowerCase()+"(String "+v.getFieldTitle().toLowerCase()+") {\n" + 
					"		this."+v.getFieldTitle().toLowerCase()+" = "+v.getFieldTitle().toLowerCase()+";\n" + 
					"	}\n");
		}
		bw.write("  public int get"+formName.toLowerCase()+"Id() {\n" + 
				"		return "+formName.toLowerCase()+"Id;\n" + 
				"	}\n" + 
				"	public void set"+formName.toLowerCase()+"Id(int "+formName.toLowerCase()+"Id) {\n" + 
				"		this."+formName.toLowerCase()+"Id = "+formName.toLowerCase()+"Id;\n" + 
				"	}\n");
		bw.write("}");
		bw.close();
		fw.close(); 
		return path;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static String createDAOFile(FormVO formvo,List ls)
	{
		try
		{
		String formName=formvo.getFormName();
		File f=new File("/Users/zeba/innoventa-workspace/final_project/WebContent/files/DAO");
		f.mkdir();
		File f1=new File("/Users/zeba/innoventa-workspace/final_project/WebContent/files/DAO/"+formName+"DAO.java");
		FileWriter fw=new FileWriter("/Users/zeba/innoventa-workspace/final_project/WebContent/files/DAO/"+formName+"DAO.java");
		String path=f1.getAbsolutePath();
		BufferedWriter bw=new BufferedWriter(fw);
		//FieldVO v=(FieldVO)ls.get(0);
		bw.write("package com.DAO;\n");
		bw.write("import java.util.ArrayList;\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import org.hibernate.Query;\n" + 
				"import org.hibernate.Session;\n" + 
				"import org.hibernate.SessionFactory;\n" + 
				"import org.hibernate.Transaction;\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\n" + 
				"import org.springframework.stereotype.Repository;\n" + 
				"\n" + 
				"import com.VO."+formName+"VO;\n" + 
				"import com.DAO."+formName+"DAO;" + 
				"\n" + 
				"@Repository\n" + 
				"public class "+formName+"DAO {\n" + 
				"	@Autowired\n" + 
				"	SessionFactory sessionfactory;\n");
		bw.write("  public void insert("+formName+"VO "+formName.toLowerCase()+"vo)\n" + 
				"	{\n" + 
				"		try\n" + 
				"		{\n"+ 
				"			Session session = sessionfactory.openSession();\n" + 
				"			Transaction tr = session.beginTransaction();\n" + 
				"			session.save("+formName.toLowerCase()+"vo);\n" + 
				"			tr.commit();\n" + 
				"			session.close();\n" + 
				"\n" + 
				"		}\n" + 
				"		catch(Exception e)\n" + 
				"		{\n" + 
				"			e.printStackTrace();\n" + 
				"		}	\n" + 
				"	}\n");
		bw.write("  public List search() {\n" + 
				"		List ls = new ArrayList();\n" + 
				"		try\n" + 
				"		{\n" + 
				"		Session session = sessionfactory.openSession();\n" + 
				"		Query q =session.createQuery(\"from "+formName+"VO\");\n" + 
				"		ls=q.list();\n" + 
				"		session.close();\n" + 
				"	}\n" + 
				"	catch(Exception e)\n" + 
				"	{\n" + 
				"		e.printStackTrace();\n" + 
				"	}\n" + 
				"		return ls;\n" + 
				"	}\n" + 
				"	");
		bw.write("  public void delete("+formName+"VO "+formName.toLowerCase()+"vo) {\n" + 
				"		try\n" + 
				"		{\n" + 
				"			Session session = sessionfactory.openSession();\n" + 
				"			Transaction tr = session.beginTransaction();\n" + 
				"			session.delete("+formName.toLowerCase()+"vo);\n" + 
				"			tr.commit();\n" + 
				"			session.close();\n" + 
				"\n" + 
				"		}\n" + 
				"		catch(Exception e)\n" + 
				"		{\n" + 
				"			e.printStackTrace();\n" + 
				"		}\n" + 
				"	}\n");
		bw.write("  public List edit("+formName+"VO "+formName.toLowerCase()+"vo) {\n" + 
				"		List ls= new ArrayList();\n" + 
				"		try\n" + 
				"		{\n" + 
				"		Session session = sessionfactory.openSession();\n" + 
				"		Query q = session.createQuery(\"from "+formName+"VO where id='\"+"+formName.toLowerCase()+"vo.get"+formName.toLowerCase()+"Id()+\"'\");\n" + 
				"		ls = q.list();\n" + 
				"		session.close();\n" +  
				"	}\n" + 
				"	catch(Exception e)\n" + 
				"	{\n" + 
				"		e.printStackTrace();\n" + 
				"	}\n" + 
				"		return ls;\n" + 
				"	}\n");
		bw.write("  public void update("+formName+"VO "+formName.toLowerCase()+"vo) {\n" + 
				"		try\n" + 
				"		{\n" + 
				"			\n" + 
				"			Session session = sessionfactory.openSession();\n" + 
				"			Transaction tr = session.beginTransaction();\n" + 
				"			session.update("+formName.toLowerCase()+"vo);\n" + 
				"			tr.commit();\n" + 
				"			session.close();\n" + 
				"\n" + 
				"		}\n" + 
				"		catch(Exception e)\n" + 
				"		{\n" + 
				"			e.printStackTrace();\n" + 
				"		}	\n" + 
				"	}\n");
		bw.write("}");
		bw.close();
		fw.close(); 
		return path;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static String createControllerFile(FormVO formvo,List ls)
	{
		try
		{
		String formName=formvo.getFormName();
		FormVO v=(FormVO)ls.get(0);
		String moduleName=v.getMvo().getModuleName();
		File f=new File("/Users/zeba/innoventa-workspace/final_project/WebContent/files/controller");
		f.mkdir();
		File f1=new File("/Users/zeba/innoventa-workspace/final_project/WebContent/files/controller/"+formName+"Controller.java");
		FileWriter fw=new FileWriter("/Users/zeba/innoventa-workspace/final_project/WebContent/files/controller/"+formName+"Controller.java");
		String path=f1.getAbsolutePath();
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("package com.controller;\n"+
				"import java.util.List;\n"+
				"import java.sql.SQLException;"+
				"import org.springframework.beans.factory.annotation.Autowired;\n" + 
				"import org.springframework.stereotype.Controller;\n" + 
				"import org.springframework.web.bind.annotation.ModelAttribute;\n" + 
				"import org.springframework.web.bind.annotation.RequestMapping;\n" + 
				"import org.springframework.web.bind.annotation.RequestMethod;\n" + 
				"import org.springframework.web.servlet.ModelAndView;\n" + 
				"import org.springframework.web.bind.annotation.RequestParam;"+
				"import com.VO."+formName+"VO;\n" + 
				"import com.DAO."+formName+"DAO;\n" + 
				"\n" + 
				"@Controller\n" + 
				"public class "+formName+"Controller {\n" + 
				"	@Autowired\n" + 
				"	"+formName+"DAO "+formName.toLowerCase()+"DAO;\n" + 
				"	@RequestMapping(method=RequestMethod.GET,value=\"load"+formName+"\")\n");
		bw.write("  public ModelAndView methodLoad1()\n" + 
				"	{\n" +
				"		return new ModelAndView(\""+moduleName+"/"+formName+"\",\"data\",new "+formName+"VO());\n" + 
				"	}\n");
		bw.write("  @RequestMapping(method=RequestMethod.POST,value=\"insert"+formName+"\")\n");
		bw.write("  public ModelAndView methodLoad2(@ModelAttribute "+formName+"VO "+formName.toLowerCase()+")\n" + 
				"	{\n" +
				"       this."+formName.toLowerCase()+"DAO.insert("+formName.toLowerCase()+");\n"+
				"		return new ModelAndView(\"redirect:/load"+formName+".htm\");\n" + 
				"	}\n");
		bw.write("  @RequestMapping(method=RequestMethod.GET,value=\"search"+formName+"\")\n");
		bw.write("  public ModelAndView methodSearch()\n");
		bw.write("{\n" + 
				"		List ls=this."+formName.toLowerCase()+"DAO.search();\n" + 
				"		return new ModelAndView(\""+moduleName+"/search"+formName+"\",\"data\",ls);\n" + 
				"	}\n");
		bw.write("  @RequestMapping(method=RequestMethod.GET,value=\"delete"+formName+"\")\n" + 
				"	public ModelAndView method14(@RequestParam(\"id\") int i) throws SQLException\n" + 
				"	{\n" + 
				"		"+formName+"VO "+formName.toLowerCase()+"vo=new "+formName+"VO();\n" + 
				"		"+formName.toLowerCase()+"vo.set"+formName.toLowerCase()+"Id(i);\n" + 
				"		this."+formName.toLowerCase()+"DAO.delete("+formName.toLowerCase()+"vo);\n" + 
				"		return new ModelAndView(\"redirect:/search"+formName+".htm\");\n" + 
				"	}\n");
		bw.write("  @RequestMapping(method=RequestMethod.GET,value=\"edit"+formName+"\")\n" + 
				"	public ModelAndView methodEdit(@RequestParam(\"id\") int i) throws SQLException\n" + 
				"	{\n" + 
				"		"+formName+"VO "+formName.toLowerCase()+"vo=new "+formName+"VO();\n" + 
				"		"+formName.toLowerCase()+"vo.set"+formName.toLowerCase()+"Id(i);\n" + 
				"		List ls=this."+formName.toLowerCase()+"DAO.edit("+formName.toLowerCase()+"vo);\n" + 
				"		return new ModelAndView(\""+moduleName+"/update"+formName+"\",\"data\",("+formName+"VO)ls.get(0)).addObject(\""+formName+"list\",ls);\n" + 
				"		\n" + 
				"	}\n" + 
				"	@RequestMapping(method=RequestMethod.POST,value=\"update"+formName+"\")\n" + 
				"	public ModelAndView methodf6(@ModelAttribute "+formName+"VO "+formName.toLowerCase()+") throws SQLException\n" + 
				"	{\n" + 
				"		this."+formName.toLowerCase()+"DAO.update("+formName.toLowerCase()+");\n" + 
				"		return new ModelAndView(\"redirect:/search"+formName+".htm\");\n" + 
				"	}\n");
		bw.write("}");
		bw.close();
		fw.close(); 
		return path;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static void createJSPHomeFile(FormVO formvo)
		{
			try {
				String formName=formvo.getFormName();
				FileWriter fw=new FileWriter("/Users/zeba/innoventa-workspace/final_project/WebContent/files/home.jsp");
				BufferedWriter bw=new BufferedWriter(fw);
				bw.write("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n" + 
						"    pageEncoding=\"UTF-8\"%>\n" + 
						"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" + 
						"<html>\n" + 
						"<head>\n" + 
						"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" + 
						"<title>Insert title here</title>\n" + 
						"</head>\n" + 
						"<body>\n" + 
						"<a href=\"load"+formName+".htm\">load"+formName+"</a>\n" + 
						"<a href=\"search"+formName+".htm\">search"+formName+"</a>\n" +
						"</body>\n" + 
						"</html>");
				bw.close();
				fw.close(); 
			}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void createJSPSearchFile(FormVO formvo,List ls)
	{
		try {
			String formName=formvo.getFormName();
			//FieldVO v=(FieldVO)ls.get(0);
			FileWriter fw=new FileWriter("/Users/zeba/innoventa-workspace/final_project/WebContent/files/search"+formName+".jsp");
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n" + 
					"    pageEncoding=\"UTF-8\"%>\n" + 
					"<%@taglib uri=\"http://java.sun.com/jstl/core_rt\" prefix=\"c\" %>\n" + 
					"\n" + 
					"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" + 
					"<html>\n" + 
					"\n" + 
					"<head>\n");
			bw.write("</head>\n");
			bw.write("<body>\n");
			bw.write("<table id=\"example\" cellspacing=\"0\" width=\"100%\" border=1>\n" + 
					"                                <thead>\n" + 
					"                                    <tr>\n" + 
					"                                        <th>"+formName+" ID</th>\n"); 
			int len=ls.size();
			for(int i=0;i<len;i++)
			{
				FieldVO v=(FieldVO)ls.get(i);
					bw.write("										<th>"+v.getFieldTitle()+"</th>\n");
			}
					bw.write("                                        <th>Action</th>\n"+
					"                                         \n" + 
					"                                    </tr>\n" + 
					"                                </thead>\n" + 
					"									<c:forEach items=\"${data}\" var=\"i\">\n" + 
					"                                \n" + 
					"                                    <tr>\n" + 
					"                                        <td>${i."+formName.toLowerCase()+"Id}</td>\n"); 
					for(int i=0;i<len;i++)
					{
						FieldVO v=(FieldVO)ls.get(i);
					bw.write("                                        <td>${i."+v.getFieldTitle().toLowerCase()+"}</td>\n");
					}
					bw.write("                                        <th><a href=\"delete"+formName+".htm?id=${i."+formName.toLowerCase()+"Id}\">Delete Record</a><a href=\"edit"+formName+".htm?id=${i."+formName.toLowerCase()+"Id}\">Edit Record</a></th>\n"+
					"                                    </tr>       \n" + 
					"                                </c:forEach>\n" +
					"                            </table>\n");
			bw.write("</body>\n");
			bw.write("</html>");
			bw.close();
			fw.close(); 
		}
	
	catch(IOException e)
	{
		e.printStackTrace();
	}
}
	public static void createJSPEditFile(FormVO formvo,List ls)
	{
		try
		{
		String formName=formvo.getFormName();
		FileWriter fw=new FileWriter("/Users/zeba/innoventa-workspace/final_project/WebContent/files/update"+formName+".jsp");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n" + 	"    pageEncoding=\"UTF-8\"%>\n");
		bw.write("<%@taglib uri=\"http://www.springframework.org/tags/form\" prefix=\"f\" %>\n");
		bw.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" + 
				"<html>\n" + 	"<head>\n"+"<title>\n"+"</title>\n"+"</head>\n"+"<body>\n");
		bw.write("<f:form id=\"defaultForm\" method=\"post\" modelAttribute=\"data\" action=\"update"+formName+".htm\">\n");
		int len=ls.size();
		bw.write("<f:input type=\"hidden\" path=\""+formName.toLowerCase()+"Id\" />\n");
		for(int i=0;i<len;i++)
		{
			FieldVO v=(FieldVO)ls.get(i);
			if(v.getFieldType().equals("text"))
			{
				bw.write(v.getFieldTitle()+":<f:input path=\""+v.getFieldTitle().toLowerCase()+"\" value=\"\"  />\n");
			}
			if(v.getFieldType().equals("textarea"))
			{
				bw.write(v.getFieldTitle()+":<f:textarea path=\""+v.getFieldTitle().toLowerCase()+"\" value=\"\"  />\n");
			}
			if(v.getFieldType().equals("radiobutton"))
			{
				String a=v.getFieldValue();
				String b[]=a.split(",");
				for(String str:b)
				{
				bw.write(v.getFieldTitle()+":<f:radiobutton path=\""+v.getFieldTitle().toLowerCase()+"\" value=\""+str+"\"  /> \n");
				}
			}
			if(v.getFieldType().equals("checkboxes"))
			{
				
				bw.write(v.getFieldTitle()+":<f:checkboxes path=\""+v.getFieldTitle().toLowerCase()+"\" items=\"${"+v.getFieldValue()+"}\" itemValue=\"data\" />\n");
			}
			if(v.getFieldType().equals("checkbox"))
			{
				bw.write("<f:checkbox path=\""+v.getFieldTitle().toLowerCase()+"\" label=\""+v.getFieldValue()+"\" />");
			}
			
		}
		bw.write("<input type=\"submit\" name=\"submit\" value=\"Click\"></input>\n");
		bw.write("</f:form>\n");
		bw.write("</body>\n");
		bw.write("</html>");
		bw.close();
		fw.close(); 
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
