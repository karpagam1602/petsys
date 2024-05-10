package com.map.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.map.bean.User;
import com.map.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserRepository userrepo;
	
	

	// to insert the data
	@PostMapping("/doUserInsert")
	public  String newUser(@RequestBody User newUser) {
		String msg="Inserted";
		 userrepo.saveAndFlush(newUser);
		return msg;

	}

	// to get all the data from the database
	@GetMapping("/getAllUserList")
	public List<User> getAllUsers() {
		return userrepo.findAll();
	}

	// get by id
		@GetMapping("/GetUserId/{userId}")
		public Optional<User> doUserFind(@PathVariable("userId") int userId) {
			return userrepo.findById(userId);
		}


	// to get all the Id
	@GetMapping("/getUserIdList")
	public List<Integer> getUserbylist() {
		return userrepo.getAllUserId();
	}

}
