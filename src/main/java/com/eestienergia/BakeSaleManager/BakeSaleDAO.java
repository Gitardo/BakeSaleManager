package com.eestienergia.BakeSaleManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BakeSaleDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<BakeSaleModel> list() {
		String sql = "SELECT * FROM BAKESALE";

		List<BakeSaleModel> listSale = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(BakeSaleModel.class));

		return listSale;
	}

}
