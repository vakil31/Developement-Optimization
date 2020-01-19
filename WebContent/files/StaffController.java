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
import com.VO.StaffVO;

@Controller
public class StaffFormController {
	@Autowired
	StaffDAO staffDAO;
	@RequestMapping(method=RequestMethod.POST,value="insertStaff")
  public ModelAndView method11()
	{
		return new ModelAndView("AA/Staff","data",new StaffVO());
	}}