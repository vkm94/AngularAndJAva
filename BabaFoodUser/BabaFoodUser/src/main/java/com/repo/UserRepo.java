package com.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.entity.User;

public interface UserRepo extends CrudRepository<User, String> {
	  @Query("SELECT u FROM User u WHERE u.email = ?1")
	    public User findByEmail(String email);

}
