package com.lvp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/")
public class AdminController {

	@GetMapping()
	public String getINDEX() {
		return "admin/admin";
	}
	
//	@PostMapping()
//	public String postINDEX() {
//		return "admin/admin";
//	}
	
}
