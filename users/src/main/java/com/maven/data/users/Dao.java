package com.maven.data.users;

import java.util.List;
import com.maven.data.users.IDao;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class Dao implements IDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Users getUsersById(int Id) {

		String sql = "SELECT id , name, email FROM data WHERE Id = ?";
		RowMapper<Users> rowMapper = new BeanPropertyRowMapper<Users>(Users.class);
		Users users = jdbcTemplate.queryForObject(sql, rowMapper, Id);
		return users;

	}

	@Override
	public List<Users> getAllData1() {
		String sql = "SELECT Id, name, email FROM data1";

		RowMapper<Users> rowMapper = new RowMapUsers();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public boolean usersExists(String name, String email) {
		String sql = "SELECT count(*) FROM data1 WHERE name = ? and email=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, name, email);
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
}
