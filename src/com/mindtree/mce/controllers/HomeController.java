/**
 * 
 */
package com.mindtree.mce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.mce.constants.ApplicationConstant;

/**
 * @author m1018211
 * 
 */
@Controller
public class HomeController {

	@RequestMapping(value = ApplicationConstant.HOME_ACTION, method = RequestMethod.GET)
	public String gotoHomePage() {
		return ApplicationConstant.HOME_PAGE;
	}
}



