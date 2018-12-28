package com.lvp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvp.dao.NV_DAO;
import com.lvp.model.NV_M;
import com.lvp.entity.NHANVIEN;

@Service
public class NV_SERVICE {

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
				return mnv;
			}
		}
		return null;
	}

	public boolean ADDONE(NV_M mnv) {
		Date d = new Date();
		if (mnv.getIMAGE().length == 0) {
			NHANVIEN nv = new NHANVIEN(d.getTime(), mnv.getEMAIL(), mnv.getPASSWORDS(), d);
			return nvd.ADDONE(nv);
		} else {
			NHANVIEN nv = new NHANVIEN(d.getTime(), mnv.getEMAIL(), mnv.getPASSWORDS(), mnv.getIMAGE(), d);
			return nvd.ADDONE(nv);
		}
	}

}
