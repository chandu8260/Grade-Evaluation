/**
 * 
 */
package com.mindtree.mce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.mce.constants.ApplicationConstant;
import com.mindtree.mce.exception.ServiceException;
import com.mindtree.mce.service.GradeEvaluationService;
import com.mindtree.mce.validator.StudentValidator;
import com.mindtree.mce.vo.StudentVo;

/**
 * @author m1018211
 * 
 */
@Controller
@RequestMapping(value = ApplicationConstant.STUDENT_ACTION)
public class StudentController {
//	private static final Logger LOG = LoggerFactory
//			.getLogger(StudentController.class);

	@Autowired
	private GradeEvaluationService service;

	@Autowired
	private StudentValidator validator;

	@RequestMapping(method = RequestMethod.GET)
	public String studentEntryForm(
			@ModelAttribute("student") StudentVo student, Model model) {
		return ApplicationConstant.STUDENT_PAGE;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") StudentVo student,
			BindingResult errors, Model model) {
		validator.validate(student, errors);
		if (!errors.hasErrors()) {
			try {
				service.addStudent(student);
				model.addAttribute("msg", "STS01");
//				LOG.info("One student details with registration number: "
//						+ student.getRegdNo() + " is persisted.");
			} catch (ServiceException e) {
				//LOG.error("Unable to add student",e);
				model.addAttribute("errMsg", "EXC01");
			}
		} else {
			return ApplicationConstant.STUDENT_PAGE;
		}
		return ApplicationConstant.HOME_PAGE;
	}
}
