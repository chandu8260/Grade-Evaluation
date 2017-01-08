/**
 * 
 */
package com.mindtree.mce.controllers;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.mce.constants.ApplicationConstant;
import com.mindtree.mce.exception.ServiceException;
import com.mindtree.mce.service.GradeEvaluationService;
import com.mindtree.mce.validator.ScoreValidator;
import com.mindtree.mce.vo.ScoreVo;

/**
 * @author m1018211
 * 
 */
@Controller
@RequestMapping(value = ApplicationConstant.SCORE_ACTION)
public class ScoreController {
	public void setService(GradeEvaluationService service) {
		this.service = service;
	}

	public void setValidator(ScoreValidator validator) {
		this.validator = validator;
	}

//	private static final Logger LOG = LoggerFactory
//			.getLogger(ScoreController.class);

	@Autowired
	private GradeEvaluationService service;

	@Autowired
	private ScoreValidator validator;

	@RequestMapping(method = RequestMethod.GET)
	public String scoreEntryForm(@ModelAttribute("score") ScoreVo score,
			Model model) {
		return ApplicationConstant.SCORE_PAGE;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addScore(@ModelAttribute("score") ScoreVo score,
			BindingResult errors, Model model) {
		validator.validate(score, errors);
		if (!errors.hasErrors()) {
			try {
				service.addScore(score);
				model.addAttribute("msg", "STS02");
//				LOG
//						.info("One Score detials is added for Student with regd number: "
							//	+ score.getRegdNo());
			} catch (ServiceException e) {
				//LOG.error("Unable to add score", e);
				model.addAttribute("errMsg", "EXC01");
			}
		} else {
			return ApplicationConstant.SCORE_PAGE;
		}
		return ApplicationConstant.HOME_PAGE;
	}

	/*
	 * method to retrieve all registration numbers available in backend
	 */
	@ModelAttribute("regdnos")
	public List<String> getAllRegdNos() {
		List<String> regdnos = null;
		try {
			regdnos = service.getRegdNos();
		} catch (ServiceException e) {
			//LOG
			//		.error(
				//			"Error occured while retrieving available registration numbers.",
				//			e);
		}
		return regdnos;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,
				false));
	}

}
