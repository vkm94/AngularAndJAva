package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.repo.UserRepo;

@RestController
public class UserController {
	@Autowired
	UserRepo ur;

	public String login( User user) {
		String email=user.getEmail();
		if(ur.findAll().toString().contains(email)) {
			User details=ur.findByEmail(email);
			if(details.getEmail().equals(user.getEmail())&&details.getPass().equals(user.getPass())) {
				return details.getType().toString();
			}
			return "Invalid Credencials";
		}
		return "Please Enter valid Email";
				
	}

	public String regiser(User user) {
		String email=user.getEmail();
		if(ur.findAll().toString().contains(email)) {
			return "This email is already Exists Please Login.. ";
		// TODO Auto-generated method stub
		}
		
		if(ur.save(user) != null) {
			return "Success";
		}
		
		return "Error";
	}

	public String UpdateData(String id, User user) {
		User use=ur.findById(id).orElse(null);
		use.setEmail(user.getEmail());
		use.setName(user.getName());
		use.setPass(user.getPass());
		use.setPhno(user.getPhno());
		use.setType(user.getType());
		use.setStatus(user.getStatus());
		use.setAddress(user.getAddress());
	if(ur.save(use) != null) {
		return "Success";
	}
		return "Error While Adding";
	}
	
	
}
