package com.lvp.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lvp.service.NV_SERVICE;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	NV_SERVICE nvs;
	
	@GetMapping
	public String home(ModelMap model) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("IOC.xml");
		return "home";
	}
	
	

}
