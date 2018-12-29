package com.lvp.controller;

import org.json.JSONString;
import org.json.JSONStringer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lvp.service.NV_SERVICE;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	NV_SERVICE nvs;
	
	@GetMapping
	public String home(ModelMap model) {
		String json = new JSONStringer().object().key("JSON").value("Hello, World!").endObject().toString();
		System.out.println(json);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("IOC.xml");
		return "home";
	}
	
	

}
