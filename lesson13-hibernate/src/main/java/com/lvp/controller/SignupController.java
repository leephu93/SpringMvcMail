package com.lvp.controller;

import java.util.Date;

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
import org.springframework.web.multipart.MultipartFile;

import com.lvp.entity.NHANVIEN;

@Controller
@RequestMapping("signup/")
public class SignupController {

	@Autowired
	SessionFactory sessionFactory;

	@GetMapping()
	public String GetSignup() {

		return "signup";
	}

	@PostMapping()
	@Transactional
	public String PostSignup(ModelMap model, @RequestParam("EMAIL") String email,
			@RequestParam("PASSWORDS") String passwords, @RequestParam("RE_PASSWORDS") String re_passwords) {
		if (email.trim().length() != 0 && passwords.trim().length() != 0 && re_passwords.trim().length() != 0) {
			if (passwords.equals(re_passwords)) {
				try {
					Session ss = sessionFactory.getCurrentSession();
					Date d = new Date();
					NHANVIEN nv = new NHANVIEN(d.getTime(), email, passwords, d);
					ss.save(nv);
					return "redirect:/signin/";
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("alert", "Register unsuccessful...");
				}
			} else {
				model.addAttribute("alert", "Passwords and re_passwords are not equally...");
			}
		} else if (email.trim().length() == 0 && passwords.trim().length() == 0 && re_passwords.trim().length() == 0) {
			model.addAttribute("alert", "Please! Enter full information...");
			model.addAttribute("alert_email", "Email not empty...");
			model.addAttribute("alert_passwords", "Passwords not empty...");
			model.addAttribute("alert_re_passwords", "Re_passwords not empty...");
		} else if (email.trim().length() != 0 && passwords.trim().length() == 0 && re_passwords.trim().length() == 0) {
			model.addAttribute("alert", "Please! Enter full information...");
			model.addAttribute("alert_passwords", "Passwords not empty...");
			model.addAttribute("alert_re_passwords", "Re_passwords not empty...");
		} else if (email.trim().length() == 0 && passwords.trim().length() != 0 && re_passwords.trim().length() == 0) {
			model.addAttribute("alert", "Please! Enter full information...");
			model.addAttribute("alert_email", "Email not empty...");
			model.addAttribute("alert_re_passwords", "Re_passwords not empty...");
		} else if (email.trim().length() == 0 && passwords.trim().length() == 0 && re_passwords.trim().length() != 0) {
			model.addAttribute("alert", "Please! Enter full information...");
			model.addAttribute("alert_email", "Email not empty...");
			model.addAttribute("alert_passwords", "Passwords not empty...");
		} else if (email.trim().length() != 0 && passwords.trim().length() != 0 && re_passwords.trim().length() == 0) {
			model.addAttribute("alert", "Please! Enter full information...");
			model.addAttribute("alert_re_passwords", "Re_passwords not empty...");
		} else if (email.trim().length() != 0 && passwords.trim().length() != 0 && re_passwords.trim().length() == 0) {
			model.addAttribute("alert", "Please! Enter full information...");
			model.addAttribute("alert_re_passwords", "Re_passwords not empty...");
		} else if (email.trim().length() == 0 && passwords.trim().length() != 0 && re_passwords.trim().length() != 0) {
			model.addAttribute("alert", "Please! Enter full information...");
			model.addAttribute("alert_email", "Email not empty...");
		} else if (email.trim().length() != 0 && passwords.trim().length() == 0 && re_passwords.trim().length() != 0) {
			model.addAttribute("alert", "Please! Enter full information...");
			model.addAttribute("alert_passwords", "Passwords not empty...");
		}
		return "signup";
	}

}
