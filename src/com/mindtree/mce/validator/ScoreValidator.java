/**
 * 
 */
package com.mindtree.mce.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mindtree.mce.vo.ScoreVo;

/**
 * @author m1018211
 * 
 */
public class ScoreValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ScoreVo.class);
	}

	@Override
	public void validate(Object model, Errors errors) {
		ScoreVo score = (ScoreVo) model;
		if (score.getRegdNo().equalsIgnoreCase("select")) {
			errors.reject("regdNo", "regdNo.empty");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "testName",
				"testName.empty");
		if (score.getMaxScore() == null) {
			errors.reject("maxScore", "maxScore.invalid");
		} else if (score.getMaxScore().doubleValue() > 100.0
				|| score.getMaxScore().doubleValue() < 0.0) {
			errors.reject("maxScore", "maxScore.invalid");
		}
		if (score.getTestScore() == null) {
			errors.reject("testScore", "testScore.invalid");
		} else if (score.getMaxScore() == null
				&& (score.getTestScore().doubleValue() < 0.0 || score
						.getTestScore().doubleValue() > 100.0)) {
			errors.reject("testScore", "testScore.invalid");
		} else if (score.getTestScore().doubleValue() < 0.0
				|| score.getTestScore().doubleValue() > score.getMaxScore()
						.doubleValue()) {
			errors.reject("testScore", "testScore.invalid");
		}
	}

}
