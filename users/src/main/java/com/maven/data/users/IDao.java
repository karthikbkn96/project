package com.maven.data.users;

import java.util.List;
import com.maven.data.users.Users;

public interface IDao {

	List<Users> getAllData1();

	Users getUsersById(int Id);

	boolean usersExists(String name, String email);

}
