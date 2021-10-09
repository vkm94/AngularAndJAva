package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.User;

@Repository

public interface UserRepo extends CrudRepository<User,String> {

}
