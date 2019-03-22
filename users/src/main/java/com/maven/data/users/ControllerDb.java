package com.maven.data.users;

import com.maven.data.users.IService;
import com.maven.data.users.Service;
import com.maven.data.users.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
@Controller
@RequestMapping("use")
public class ControllerDb {
	@Autowired
	private IService Service;

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Users> getUsersById(@PathVariable("id") Integer id) {
		Users users = Service.getUsersById(id);
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}
@RequestMapping(value ="/data1",method =RequestMethod.GET)
	public ResponseEntity<List<Users>> getAllData1() {
		List<Users> list = Service.getAllData1();
		return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
	}
}
