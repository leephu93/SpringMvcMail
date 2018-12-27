package com.lvp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("signout/")
public class SignoutController {
	
	@Autowired
	HttpSession ss;
	
	@GetMapping()
	public String postSignout() {
		ss.removeAttribute("user");
		return "redirect:/signin/";
	}
	
}
