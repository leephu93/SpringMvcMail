package com.lvp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity(name = "SANPHAM")
public class SANPHAM {

	@Id
	String ID;

	String PRODUCT;
	String DETAIL;
	byte[] IMAGE;

	// Column ID_NV of table SANPHAM
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "ID_NV") // Enter name of foreign key at here
	//NHANVIEN nhanvien;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "NV_SP", joinColumns = {
			@JoinColumn(name = "ID_SP", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_NV", referencedColumnName = "ID") })
	Set<NHANVIEN> nhanvien;

	public SANPHAM() {

	}

	public SANPHAM(String ID, String PRODUCT) {
		this.ID = ID;
		this.PRODUCT = PRODUCT;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPRODUCT() {
		return PRODUCT;
	}

	public void setPRODUCT(String pRODUCT) {
		PRODUCT = pRODUCT;
	}

	public String getDETAIL() {
		return DETAIL;
	}

	public void setDETAIL(String dETAIL) {
		DETAIL = dETAIL;
	}

	public byte[] getIMAGE() {
		return IMAGE;
	}

	public void setIMAGE(byte[] iMAGE) {
		IMAGE = iMAGE;
	}
	
	public Set<NHANVIEN> getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(Set<NHANVIEN> nhanvien) {
		this.nhanvien = nhanvien;
	}

}
