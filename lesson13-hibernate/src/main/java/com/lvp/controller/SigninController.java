package com.lvp.controller;

import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lvp.model.NV_M;
import com.lvp.service.NV_SERVICE;

@Controller
@RequestMapping("signin/")
public class SigninController {

	@Autowired
	HttpSession session;

	@Autowired
	NV_SERVICE nvs;

	@GetMapping()
	public String GetSignin() {
		if (session.getAttribute("user") != null) {
			return "redirect:/admin/";
		}
		return "signin";
	}

	@PostMapping()
	public String PostSignin(ModelMap model, @RequestParam("EMAIL") String email,
			@RequestParam("PASSWORDS") String passwords) {
		if (session.getAttribute("user") == null) {
			try {
				if (email.trim().length() != 0 && passwords.trim().length() != 0) {
					ArrayList<?> nv = nvs.GETONE(email, passwords);
					if (nv.size() == 0) {
						model.addAttribute("alert", "This account is not exist in our system...");
					} else {
						if (nv.get(0) instanceof String) {
							model.addAttribute("alert", nv.get(0).toString());
						} else if (nv.get(0) instanceof NV_M) {
							session.setAttribute("user", ((NV_M) nv.get(0)));
							session.setAttribute("image", "data:image/*;base64," + Base64.getEncoder().encodeToString(((NV_M) nv.get(0)).getIMAGE()));
							return "redirect:/admin/";
						}
					}
				} else if (email.trim().length() != 0 && passwords.trim().length() == 0) {
					model.addAttribute("alert", "Passwords not empty...!");
				} else if (email.trim().length() == 0 && passwords.trim().length() != 0) {
					model.addAttribute("alert", "Email not empty...!");
				} else {
					model.addAttribute("alert", "Please! Enter full information...");
				}
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("alert", "Sign in unsuccessful...!");
			}
		} else {
			return "redirect:/admin/";
		}
		return "signin";
	}

}
