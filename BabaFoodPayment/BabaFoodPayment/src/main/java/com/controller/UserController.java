package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.repo.UserRepo;
@RestController
public class UserController {
	@Autowired
	UserRepo ur;
	public String login(User user) {
	Iterable<User> data=	ur.findAll();
	String email=user.getEmail();
	String password=user.getPass();
	if(data.toString().contains(email)&&data.toString().contains(password)) {
		return data.toString();
	}
	return password;
		
		
	}

	

}
