package com.lvp.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("MODEL_NHANVIEN")
public class NV_M {
	private long ID;
	private String EMAIL;
	private String PASSWORDS;
	private byte[] IMAGE;
	private Date CREATED_AT;
	private Date UPDATED_AT;

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

}
