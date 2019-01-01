package com.lvp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.lvp.util.FacebookUtil;
import com.lvp.util.GoogleUtil;
import com.lvp.util.JBCRYPT;
//import com.restfb.types.User;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvp.dao.NV_DAO;
import com.lvp.model.FacebookUser;
import com.lvp.model.GoogleUser;
import com.lvp.model.NV_M;
import com.lvp.entity.NHANVIEN;

@Service
public class NV_SERVICE {

	@Autowired
	HttpSession session;

	@Autowired
	NV_DAO nvd;

	public NV_M GETONE(String email) {
		List<NHANVIEN> lsnv = nvd.ALL_NHANVIEN();
		NV_M mnv = new NV_M();
		for (NHANVIEN nv : lsnv) {
			if (nv.getEMAIL().equals(email)) {
				mnv.setID(nv.getID());
				mnv.setEMAIL(nv.getEMAIL());
				mnv.setPASSWORDS(nv.getPASSWORDS());
				mnv.setIMAGE(nv.getIMAGE());
				mnv.setCREATED_AT(nv.getCREATED_AT());
				mnv.setUPDATED_AT(nv.getUPDATED_AT());
				mnv.setGOOGLE(nv.getGOOGLE());
				mnv.setFACEBOOK(nv.getFACEBOOK());
				mnv.setGITHUB(nv.getGITHUB());
				return mnv;
			}
		}
		return null;
	}

	public ArrayList GETONE(String email, String passwords) { // Xử lý đăng nhập
		List<NHANVIEN> lsnv = nvd.ALL_NHANVIEN();
		NV_M mnv = new NV_M();
		ArrayList ar = new ArrayList();		
		for (NHANVIEN nv : lsnv) {
			if (nv.getEMAIL().equals(email) && nv.getFACEBOOK() == null && nv.getGOOGLE() == null && nv.getGITHUB() == null) {
				if (JBCRYPT.CHECKCODE(passwords, nv.getPASSWORDS())) {
					mnv.setID(nv.getID());
					mnv.setEMAIL(nv.getEMAIL());
					mnv.setPASSWORDS(nv.getPASSWORDS());
					mnv.setIMAGE(nv.getIMAGE());
					mnv.setCREATED_AT(nv.getCREATED_AT());
					mnv.setUPDATED_AT(nv.getUPDATED_AT());
					mnv.setGOOGLE(nv.getGOOGLE());
					mnv.setGOOGLE_IMG(nv.getGOOGLE_IMG());
					mnv.setFACEBOOK(nv.getFACEBOOK());
					mnv.setFACEBOOK_IMG(nv.getFACEBOOK_IMG());
					mnv.setGITHUB(nv.getGITHUB());
					mnv.setGITHUB_IMG(nv.getGITHUB_IMG());
					ar.add(mnv);
				} else {
					ar.add("Passwords incorrect...");
				}
			}
		}
		return ar;
	}

	public List<NV_M> GETONE_LIST(String email) {
		List<NHANVIEN> lsnv = nvd.ALL_NHANVIEN();
		List<NV_M> lsrs = new ArrayList<NV_M>();
		for (NHANVIEN nv : lsnv) {
			if (nv.getEMAIL().equals(email)) {
				NV_M mnv = new NV_M();
				mnv.setID(nv.getID());
				mnv.setEMAIL(nv.getEMAIL());
				mnv.setPASSWORDS(nv.getPASSWORDS());
				mnv.setIMAGE(nv.getIMAGE());
				mnv.setCREATED_AT(nv.getCREATED_AT());
				mnv.setUPDATED_AT(nv.getUPDATED_AT());
				mnv.setGOOGLE(nv.getGOOGLE());
				mnv.setFACEBOOK(nv.getFACEBOOK());
				mnv.setGITHUB(nv.getGITHUB());
				lsrs.add(mnv);
			}
		}
		return lsrs;
	}

	public boolean CHECK_GOOGLE(String email, String id) {
		List<NHANVIEN> lsnv = nvd.ALL_NHANVIEN();
		boolean rs = false;
		for (NHANVIEN nv : lsnv) {
			if (nv.getEMAIL().equals(email)) {
				if (nv.getGOOGLE() != null && nv.getGOOGLE().equals(id)) {
					rs = true;
				}
			}
		}
		return rs;
	}

	public boolean CHECK_FACEBOOK(String email, String id) {
		List<NHANVIEN> lsnv = nvd.ALL_NHANVIEN();
		boolean rs = false;
		for (NHANVIEN nv : lsnv) {
			if (nv.getEMAIL().equals(email)) {
				if (nv.getFACEBOOK() != null && nv.getFACEBOOK().equals(id)) {
					rs = true;
				}
			}
		}
		return rs;
	}

	public boolean CHECK_LOCAL(String email) {
		List<NHANVIEN> lsnv = nvd.ALL_NHANVIEN();
		boolean rs = false;
		for (NHANVIEN nv : lsnv) {
			if (nv.getEMAIL().equals(email)) {
				if (nv.getPASSWORDS() != null && nv.getFACEBOOK() == null && nv.getGOOGLE() == null && nv.getGITHUB() == null) {
					rs = true;
				}
			}
		}
		return rs;
	}

	public boolean ADDONE(NV_M mnv) {
		Date d = new Date();
		try {
			String ck = "";
			if (session.getAttribute("fb") != null) {
				ck = (String) session.getAttribute("fb");
			} else if (session.getAttribute("gg") != null) {
				ck = (String) session.getAttribute("gg");
			} else if (session.getAttribute("gh") != null) {
				ck = (String) session.getAttribute("gh");
			}
			if (mnv.getFACEBOOK() != null) {
				NHANVIEN nv = new NHANVIEN(d.getTime(), mnv.getEMAIL(), JBCRYPT.HASHCODE(mnv.getPASSWORDS()),
						mnv.getIMAGE(), d, ck, mnv.getFACEBOOK(), mnv.getFACEBOOK_IMG());
				return nvd.ADDONE(nv);
			} else if (mnv.getGOOGLE() != null) {
				NHANVIEN nv = new NHANVIEN(d.getTime(), mnv.getEMAIL(), JBCRYPT.HASHCODE(mnv.getPASSWORDS()),
						mnv.getIMAGE(), d, ck, mnv.getGOOGLE(), mnv.getGOOGLE_IMG());
				return nvd.ADDONE(nv);
			} else if (mnv.getGITHUB() != null) {
				NHANVIEN nv = new NHANVIEN(d.getTime(), mnv.getEMAIL(), JBCRYPT.HASHCODE(mnv.getPASSWORDS()),
						mnv.getIMAGE(), d, ck, mnv.getGITHUB(), mnv.getGITHUB_IMG());
				return nvd.ADDONE(nv);
			} else {
				if (mnv.getIMAGE().length != 0) {
					NHANVIEN nv = new NHANVIEN(d.getTime(), mnv.getEMAIL(), JBCRYPT.HASHCODE(mnv.getPASSWORDS()),
							mnv.getIMAGE(), d);
					return nvd.ADDONE(nv);
				} else {
					NHANVIEN nv = new NHANVIEN(d.getTime(), mnv.getEMAIL(), JBCRYPT.HASHCODE(mnv.getPASSWORDS()), d);
					return nvd.ADDONE(nv);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return false;
	}

	public FacebookUser getUserFacebook(final String code) throws ClientProtocolException, IOException {
		String accessToken = FacebookUtil.getToken(code);
		return FacebookUtil.getUserInfo(accessToken);
	}

	public GoogleUser getUserGoogle(final String code) throws ClientProtocolException, IOException {
		String accessToken = GoogleUtil.getToken(code);
		return GoogleUtil.getUserGoogle(accessToken);
	}
	
	public void TEST() {
		nvd.TEST();
	}

}
