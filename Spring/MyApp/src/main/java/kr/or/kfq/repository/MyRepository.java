package kr.or.kfq.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int getTotalCount() {
		String sql = "select count(*) from employees";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
