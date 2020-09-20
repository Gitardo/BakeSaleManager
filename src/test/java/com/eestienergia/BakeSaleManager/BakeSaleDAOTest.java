package com.eestienergia.BakeSaleManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class BakeSaleDAOTest {

	private BakeSaleDAO dao;
	
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
		datasource.setUsername("SYSTEM");
		datasource.setPassword("oracle");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		dao = new BakeSaleDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<BakeSaleModel> listBakeSale = dao.list();

		assertFalse(listBakeSale.isEmpty());
	}

}
