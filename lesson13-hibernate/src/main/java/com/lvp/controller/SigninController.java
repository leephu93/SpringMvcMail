package com.lvp.controller;

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
import com.lvp.util.JBCRYPT;

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
				NV_M nv = nvs.GETONE(email);
				if (email.trim().length() != 0 && passwords.trim().length() != 0) {
					if (nv != null) {
						if (JBCRYPT.CHECKCODE(passwords, nv.getPASSWORDS())) {
							session.setAttribute("user", nv);
							if (nv.getIMAGE() != null) {
								String image = "data:image/*;base64,"
										+ Base64.getEncoder().encodeToString(nv.getIMAGE());
								session.setAttribute("image", image);
							}
							return "redirect:/admin/";
						} else {
							model.addAttribute("alert", "Passwords incorrect...");
						}
					} else {
						model.addAttribute("alert", "This account is not exist in our system...");
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
