package com.sobis.carparking.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
@Controller
public class LoginController extends WebMvcConfigurerAdapter {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		//System.out.println("in login controller");
		return "login";
	}

}
