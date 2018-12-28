package com.lvp.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "NHANVIEN")
public class NHANVIEN {

	@Id
	long ID;

	String EMAIL;
	String PASSWORDS;
	byte[] IMAGE;
	Date CREATED_AT;
	Date UPDATED_AT;

	// Create list SANPHAM from table SANPHAM via foreign key
	// @OneToMany(cascade=CascadeType.ALL)
	// @JoinColumn(name="ID_NV") //Enter name for foreign key from table SANPHAM
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "NV_SP", joinColumns = {
			@JoinColumn(name = "ID_NV", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_SP", referencedColumnName = "ID") })
	Set<SANPHAM> sanpham;

	public NHANVIEN() {

	}

	public NHANVIEN(long ID, String EMAIL) {
		this.ID = ID;
		this.EMAIL = EMAIL;
	}

	public NHANVIEN(long ID, String EMAIL, String PASSWORDS) {
		this.ID = ID;
		this.EMAIL = EMAIL;
		this.PASSWORDS = PASSWORDS;
	}

	public NHANVIEN(long ID, String EMAIL, String PASSWORDS, Date CREATED_AT) {
		this.ID = ID;
		this.EMAIL = EMAIL;
		this.PASSWORDS = PASSWORDS;
		this.CREATED_AT = CREATED_AT;
	}
	
	public NHANVIEN(long ID, String EMAIL, String PASSWORDS, byte[] IMAGE ,Date CREATED_AT) {
		this.ID = ID;
		this.EMAIL = EMAIL;
		this.PASSWORDS = PASSWORDS;
		this.IMAGE = IMAGE;
		this.CREATED_AT = CREATED_AT;
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

}
