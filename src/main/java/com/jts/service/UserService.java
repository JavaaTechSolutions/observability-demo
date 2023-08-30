package com.jts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jts.entity.User;
import com.jts.repository.UserRepository;

import io.micrometer.observation.annotation.Observed;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Observed(name = "add.user")
	public User addUser(User product) {
		return repository.save(product);
	}

	@Observed(name = "get.user")
	public User getUser(int id) {
		return repository.findById(id).get();
	}

	@Observed(name = "get.all.user")
	public List<User> getUsers() {
		return repository.findAll();
	}
}
