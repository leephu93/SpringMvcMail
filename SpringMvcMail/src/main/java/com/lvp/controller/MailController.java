package com.lvp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvp.mail.MailAPI;

@RestController
public class MailController {
	
	@Autowired
	ApplicationContext context;
	
	@GetMapping("/")
	public String MAIL() {
		
		context = new ClassPathXmlApplicationContext("IOC.xml");
		MailAPI mailAPI = (MailAPI) context.getBean("MailAPI");
		String from = "lee.phu93@gmail.com";
		String to = "leephu.apple@gmail.com";
		String subject = "DEMO MAIL";
		String body = "<h1>Only test application...</h1>";
		mailAPI.ReadyToSendMail(from, to, subject, body);
		
		return "MAIL...!";
	}

}
