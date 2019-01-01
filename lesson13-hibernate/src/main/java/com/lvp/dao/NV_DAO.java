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
	public List<NHANVIEN> ALL_NHANVIEN() {
		Session ss = sessionFactory.getCurrentSession();
		String sql = "FROM NHANVIEN";
		return ss.createQuery(sql).getResultList();
	}
	
	@Transactional
	public NHANVIEN GETONE(String email) {
		Session ss = sessionFactory.getCurrentSession();
		return null;
	}
	
	@Transactional
	public boolean ADDONE(NHANVIEN nv) {
		try {
			Session ss = sessionFactory.getCurrentSession();
			ss.save(nv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public void TEST() {
		Session ss = sessionFactory.getCurrentSession();
		String sql = "FROM NHANVIEN";
		List<NHANVIEN> ls = ss.createQuery(sql, NHANVIEN.class).getResultList();
		for(NHANVIEN nv : ls) {
			System.out.println(nv.getID());
			System.out.println(nv.getEMAIL());
			if(nv.getIMAGE() != null) {
				byte[] image = nv.getIMAGE();
				System.out.println(image);
			}			
			System.out.println("********************************");
		}
	}
	
	
}
