package com.lvp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lvp.model.FacebookUser;
import com.lvp.model.GoogleUser;
import com.lvp.model.NV_M;
import com.lvp.service.NV_SERVICE;
import com.lvp.util.URL_IMAGE;

@Controller
@RequestMapping("/auth/")
public class OAuthController {

	@Autowired
	NV_SERVICE nvs;

	@Autowired
	HttpSession session;

	@RequestMapping("facebook")
	public String AuthFacebook(@RequestParam(value = "code", required = false, defaultValue = "") String code) {
		if (code.trim().length() == 0 || code.isEmpty() || code == null) {
			return "redirect:/signin/";
		} else {
			try {
				FacebookUser FU = nvs.getUserFacebook(code);
				NV_M nv = nvs.GETONE(FU.getEmail());
				NV_M new_nv = new NV_M();
				new_nv.setEMAIL(FU.getEmail());
				new_nv.setFACEBOOK(FU.getId());
				new_nv.setFACEBOOK_IMG(URL_IMAGE.getURL_FB(FU.getPicture()));
				if (nv == null) {
					session.setAttribute("fb", "facebook");
					boolean rs = nvs.ADDONE(new_nv);
					if (rs) {
						session.setAttribute("user", nvs.GETONE(new_nv.getEMAIL()));
						session.setAttribute("image", URL_IMAGE.getURL_FB(FU.getPicture()));
						return "redirect:/admin/";
					} else {
						return "redirect:/signin/";
					}
				} else {
					boolean ck = nvs.CHECK_FACEBOOK(FU.getEmail(), FU.getId());
					if (ck == false) {
						session.setAttribute("fb", "facebook");
						boolean rs = nvs.ADDONE(new_nv);
						if (rs) {
							session.setAttribute("user", nvs.GETONE(new_nv.getEMAIL()));
							session.setAttribute("image", URL_IMAGE.getURL_FB(FU.getPicture()));
							return "redirect:/admin/";
						} else {
							return "redirect:/signin/";
						}
					} else {
						session.setAttribute("image", URL_IMAGE.getURL_FB(FU.getPicture()));
						session.setAttribute("user", nv);
						return "redirect:/admin/";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/signin/";
	}

	@RequestMapping("google")
	public String AuthGoogle(@RequestParam(value = "code", required = false, defaultValue = "") String code) {
		if (code.trim().length() == 0 || code.isEmpty() || code == null) {
			return "redirect:/signin/";
		} else {
			try {
				GoogleUser GU = nvs.getUserGoogle(code);
				NV_M nv = nvs.GETONE(GU.getEmail());
				NV_M new_nv = new NV_M();
				new_nv.setEMAIL(GU.getEmail());
				new_nv.setGOOGLE(GU.getId());
				new_nv.setGOOGLE_IMG(GU.getPicture());
				if (nv == null) {
					session.setAttribute("gg", "google");
					boolean rs = nvs.ADDONE(new_nv);
					if (rs) {
						session.setAttribute("user", nvs.GETONE(new_nv.getEMAIL()));
						session.setAttribute("image", GU.getPicture());
						return "redirect:/admin/";
					} else {
						return "redirect:/signin/";
					}
				} else {
					boolean ck = nvs.CHECK_GOOGLE(GU.getEmail(), GU.getId());
					if (ck == false) {
						session.setAttribute("gg", "google");
						boolean rs = nvs.ADDONE(new_nv);
						if (rs) {
							session.setAttribute("user", nvs.GETONE(new_nv.getEMAIL()));
							session.setAttribute("image", GU.getPicture());
							return "redirect:/admin/";
						} else {
							return "redirect:/signin/";
						}
					} else {
						session.setAttribute("user", nv);
						session.setAttribute("image", GU.getPicture());
						return "redirect:/admin/";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/signin/";
	}

}
