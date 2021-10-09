package com.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.UserRepo;
import com.user.User;

@Service

public class UserService {
	@Autowired
	UserRepo ur;
	
	public boolean login(String email,String password) {
		if(ur.findById(email) != null) {
			if( ur.findById(password) != null) {
				Iterable<User> user1=ur.findAll();
				String details=user1.toString();
				if(details.contains(email) && details.contains(password) ) {
					return true;
				}
				
				
			}
			
		}
		return false;
		
		
	}
public String type(String email,String password) {
		
	
	if(ur.findById(email) != null) {
		if( ur.findById(password) != null) {
		Optional<User> u=ur.findById(email);
		String result=u.toString();
		if(result.contains("user")) {
			return "user";
		}
		return "Admin";
		}
		
	}
	return null;
		
	}
	
	public boolean register(String id,String email,int phone,String password,String Address,String name ) {
		String type=null;
		ur.save(new User(id,email ,phone,password,Address,name,type));
		return true;
		
	}
	public Iterable<User> getAll() {
		return ur.findAll();
		
	}
	
	

}
