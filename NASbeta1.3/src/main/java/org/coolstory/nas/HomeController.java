package org.coolstory.nas;

import org.coolstory.nas.dao.DetailsService;
import org.coolstory.nas.dto.StudentSportsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	private DetailsService detailsService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	*/
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public StudentSportsDto getStudent(@RequestParam(required=true, value="studentId")Integer studentId) {
		logger.info("Request Coming for details for Student Id: "+studentId);
		StudentSportsDto studentSportsDto=detailsService.getStudentSportsDetails(studentId);
		return studentSportsDto;
	}
	
}
