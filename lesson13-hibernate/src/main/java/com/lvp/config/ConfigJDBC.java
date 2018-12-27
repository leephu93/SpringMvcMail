package com.lvp.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lvp.model.*;

@Repository
public class ConfigJDBC {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void getListNHANVIEN() {
		String sql = "Select * from NHANVIEN";
		List<NV_M> lsNV = jdbcTemplate.query(sql, new RowMapper<NV_M>() {

			@Override
			public NV_M mapRow(ResultSet rs, int rowNum) throws SQLException {
				NV_M nv = new NV_M();
				nv.setID(rs.getInt("ID"));
				nv.setEMAIL(rs.getString("EMAIL"));
				nv.setPASSWORDS(rs.getString("PASSWORDS"));
				nv.setIMAGE(rs.getBytes("IMAGE"));
				nv.setCREATED_AT(rs.getDate("CREATED_AT"));
				nv.setUPDATED_AT(rs.getDate("UPDATED_AT"));
				return nv;
			}
			
		});
		
		for(NV_M nv : lsNV) {
			System.out.println(nv.getEMAIL());
		}
	}
	
}
