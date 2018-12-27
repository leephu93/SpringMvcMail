package com.lvp.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lvp.entity.NHANVIEN;

@Controller
@RequestMapping("signin/")
public class SigninController {

	@Autowired
	HttpSession session;

	@Autowired
	SessionFactory sessionFactory;

	@GetMapping()
	public String GetSignin() {
		if (session.getAttribute("user") != null) {
			return "redirect:/admin/";
		}
		return "signin";
	}

	@PostMapping()
	@Transactional
	public String PostSignin(ModelMap model, @RequestParam("EMAIL") String email, @RequestParam("PASSWORDS") String passwords) {
		if (session.getAttribute("user") == null) {
			try {
				Session ss = sessionFactory.getCurrentSession();
				NHANVIEN obj_nv = (NHANVIEN) ss.createQuery("From NHANVIEN Where EMAIL='" + email + "'").uniqueResult();
				if (email.trim().length() != 0 && passwords.trim().length() != 0) {
					if(obj_nv != null) {
						if(obj_nv.getPASSWORDS().equals(passwords)) {
							session.setAttribute("user", obj_nv);
							return "redirect:/admin/";
						}
						else {
							model.addAttribute("alert", "Passwords incorrect...");
						}
					}
					else {
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
