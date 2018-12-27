package com.lvp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.lvp.dao.NV_DAO;
import com.lvp.implement.NV_IMPLEMENT;

@Service
public class NV_SERVICE implements NV_IMPLEMENT {

	@Autowired
	NV_DAO nvd;

	@Override
	public void getNHANVIEN() {
		System.out.println("Triệu gọi NV_SERVICE");
		nvd.getNHANVIEN();
	}

}
