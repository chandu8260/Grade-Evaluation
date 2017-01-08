/**
 * 
 */
package com.mindtree.mce.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mindtree.mce.vo.StudentVo;

/**
 * @author m1018211
 * 
 */
public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(StudentVo.class);
	}

	@Override
	public void validate(Object model, Errors errors) {
		String regEx = "[0-9]{10}";
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentName",
				"studentName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "regdNo",
				"regNo.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
				"address.empty");
		StudentVo student = (StudentVo) model;
		if (!String.valueOf(student.getPhoneNo()).matches(regEx)) {
			errors.rejectValue("phoneNo", "phoneNo.empty");
		}

	}

}
