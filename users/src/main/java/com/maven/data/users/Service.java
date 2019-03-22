package com.maven.data.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Service implements IService {

	@Autowired
	private IDao iDao;

	@Override
	public Users getUsersById(int Id) {
		Users obj = iDao.getUsersById(Id);
		return obj;
	}

	@Override
	public List<Users> getAllData1() {
		return iDao.getAllData1();
	}
}
