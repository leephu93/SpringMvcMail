package com.lvp.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "NHANVIEN")
public class NHANVIEN {

	@Id
	long ID;

	String EMAIL;
	String PASSWORDS;

	@Lob
	@Column(name = "IMAGE", nullable = true, columnDefinition = "mediumblob")
	byte[] IMAGE;

	Date CREATED_AT;
	Date UPDATED_AT;
	String GOOGLE;
	String GOOGLE_IMG;
	String FACEBOOK;
	String FACEBOOK_IMG;
	String GITHUB;
	String GITHUB_IMG;

	// @OneToMany(cascade=CascadeType.ALL) // Create list SANPHAM from table SANPHAM
	// via foreign key
	// @JoinColumn(name="ID_NV") //Enter name for foreign key from table SANPHAM

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "NV_SP", joinColumns = {
			@JoinColumn(name = "ID_NV", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_SP", referencedColumnName = "ID") })
	Set<SANPHAM> sanpham;

	public NHANVIEN() {

	}

	public NHANVIEN(long ID, String EMAIL, String PASSWORDS, Date CREATED_AT) {
		this.ID = ID;
		this.EMAIL = EMAIL;
		this.PASSWORDS = PASSWORDS;
		this.CREATED_AT = CREATED_AT;
	}

	public NHANVIEN(long ID, String EMAIL, String PASSWORDS, byte[] IMAGE, Date CREATED_AT) {
		this.ID = ID;
		this.EMAIL = EMAIL;
		this.PASSWORDS = PASSWORDS;
		this.IMAGE = IMAGE;
		this.CREATED_AT = CREATED_AT;
	}

	public NHANVIEN(long ID, String EMAIL, String PASSWORDS, byte[] IMAGE, Date CREATED_AT, String CK, String SN_ID, String SN_IMAGE) {
		this.ID = ID;
		this.EMAIL = EMAIL;
		this.PASSWORDS = PASSWORDS;
		this.IMAGE = IMAGE;
		this.CREATED_AT = CREATED_AT;
		switch (CK) {
		case "facebook":
			this.FACEBOOK = SN_ID;
			this.FACEBOOK_IMG = SN_IMAGE;
			break;
		case "google":
			this.GOOGLE = SN_ID;
			this.GOOGLE_IMG = SN_IMAGE;
			break;
		case "github":
			this.GITHUB = SN_ID;
			this.GITHUB_IMG = SN_IMAGE;
			break;
		}
		
	}

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

	public Set<SANPHAM> getSanpham() {
		return sanpham;
	}

	public void setSanpham(Set<SANPHAM> sanpham) {
		this.sanpham = sanpham;
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
