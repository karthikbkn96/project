package com.maven.data.users;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapUsers implements RowMapper<Users>  {
	
	@Override
	public Users mapRow(ResultSet row, int rowNum) throws SQLException {
		Users users = new Users();
		users.setId(row.getInt("userId"));
		users.setName(row.getString("name"));
		users.setEmail(row.getString("email"));
		return users;
	}

}
