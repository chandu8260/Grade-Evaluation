/**
 * 
 */
package com.mindtree.mce.controllers;

import java.util.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.mce.constants.ApplicationConstant;
import com.mindtree.mce.exception.ServiceException;
import com.mindtree.mce.service.GradeEvaluationService;
import com.mindtree.mce.vo.ResultVo;
import com.mindtree.mce.vo.ScoreVo;

/**
 * @author m1018211
 * 
 */
@Controller
public class ResultController {
	public void setService(GradeEvaluationService service) {
		this.service = service;
	}

//	private static final Logger LOG = LoggerFactory
//			.getLogger(ResultController.class);

	@Autowired
	private GradeEvaluationService service;

	@RequestMapping(value = ApplicationConstant.RESULT_ACTION, method = RequestMethod.GET)
	public String gotoStudentResultPage(Model model) {
		getAllGrades(model);
		return ApplicationConstant.RESULT_PAGE;
	}

	@RequestMapping(value = ApplicationConstant.SHOWTEST_ACTION, method = RequestMethod.GET)
	public String showAllScores(@RequestParam("regdno") String regdno,
			Model model) {
		Collection<ScoreVo> scores = null;
		try {
			scores = service.getAllTests(regdno);
			model.addAttribute("scores", scores);
			//LOG
					//.info("All Score details are fetched for Student with registration number: "
							//+ regdno);
		} catch (ServiceException e) {
			//LOG.error("Unable to retrieve tests appeared by Regd No: ."
					//+ regdno + " Student", e);
		}
		getAllGrades(model);
		return ApplicationConstant.RESULT_PAGE;
	}

	/*
	 * A common method used in above two methods for retrieving all students
	 * with their corresponding grades.
	 */
	private void getAllGrades(Model model) {
		List<ResultVo> results = null;
		try {
			results = service.getAllGrades(0, 0);
			model.addAttribute("results", results);
		} catch (ServiceException e) {
			//LOG.error("Unable to retrieve all students grade.", e);
		}
	}
}
