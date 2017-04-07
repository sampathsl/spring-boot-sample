package com.sampath.restful.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {
	
	/*@RequestMapping(value = "/home1", method = RequestMethod.GET)
	public String index() {
		return "Greetings from Spring Boot!";
	}*/

	/*@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "index";
	}*/
	
	@RequestMapping("/home")
	public ModelAndView index() {
        return new ModelAndView("index");
    }

}
