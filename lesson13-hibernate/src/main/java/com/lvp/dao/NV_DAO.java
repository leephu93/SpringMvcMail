package com.lvp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.lvp.entity.NHANVIEN;
import com.lvp.implement.NV_IMPLEMENT;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NV_DAO implements NV_IMPLEMENT{
	
	@Autowired
	SessionFactory sessionFactory; // Tên biến phải được đặt đúng với id của bean trong IOC.xml

	@Override
	@Transactional
	public void getNHANVIEN() {
		System.out.println("Triệu gọi NV_DAO");
		Session ss = sessionFactory.getCurrentSession();
		String sql = "from NHANVIEN";
		List<NHANVIEN> lsNV = (List<NHANVIEN>) ss.createQuery(sql).getResultList();
		for(NHANVIEN nv : lsNV) {
			System.out.println(nv.getEMAIL());
		}
	}
	
	
}
