package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.controller.UserController;
import com.entity.User;

@Service
public class UserServce {
	@Autowired
private UserController uc;
	@PostMapping("/login")
	private String login(@RequestBody User user) {
		uc.login(user);
		return null;
		
	}

}
