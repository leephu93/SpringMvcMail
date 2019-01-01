package com.lvp.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("MODEL_NHANVIEN")
public class NV_M {

	long ID;
	String EMAIL;
	String PASSWORDS;
	byte[] IMAGE;
	Date CREATED_AT;
	Date UPDATED_AT;
	String GOOGLE;
	String GOOGLE_IMG;
	String FACEBOOK;
	String FACEBOOK_IMG;
	String GITHUB;
	String GITHUB_IMG;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPASSWORDS() {
		return PASSWORDS;
	}

	public void setPASSWORDS(String pASSWORDS) {
		PASSWORDS = pASSWORDS;
	}

	public byte[] getIMAGE() {
		return IMAGE;
	}

	public void setIMAGE(byte[] iMAGE) {
		IMAGE = iMAGE;
	}

	public Date getCREATED_AT() {
		return CREATED_AT;
	}

	public void setCREATED_AT(Date cREATED_AT) {
		CREATED_AT = cREATED_AT;
	}

	public Date getUPDATED_AT() {
		return UPDATED_AT;
	}

	public void setUPDATED_AT(Date uPDATED_AT) {
		UPDATED_AT = uPDATED_AT;
	}

	public String getGOOGLE() {
		return GOOGLE;
	}

	public void setGOOGLE(String gOOGLE) {
		GOOGLE = gOOGLE;
	}

	public String getFACEBOOK() {
		return FACEBOOK;
	}

	public void setFACEBOOK(String fACEBOOK) {
		FACEBOOK = fACEBOOK;
	}

	public String getGITHUB() {
		return GITHUB;
	}

	public void setGITHUB(String gITHUB) {
		GITHUB = gITHUB;
	}

	public String getGOOGLE_IMG() {
		return GOOGLE_IMG;
	}

	public void setGOOGLE_IMG(String gOOGLE_IMG) {
		GOOGLE_IMG = gOOGLE_IMG;
	}

	public String getFACEBOOK_IMG() {
		return FACEBOOK_IMG;
	}
	
	public void setFACEBOOK_IMG(String fACEBOOK_IMG) {
		FACEBOOK_IMG = fACEBOOK_IMG;
	}

	public String getGITHUB_IMG() {
		return GITHUB_IMG;
	}

	public void setGITHUB_IMG(String gITHUB_IMG) {
		GITHUB_IMG = gITHUB_IMG;
	}

}
