package com.jts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jts.entity.User;
import com.jts.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}

	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable int id) {
		return service.getUser(id);
	}

	@GetMapping("/getAllUser")
	public List<User> getUsers() {
		return service.getUsers();
	}
}
