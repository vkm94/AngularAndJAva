package com.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Cart;
@Repository
public interface CartRepo extends CrudRepository<Cart, String> {
	
	

}
