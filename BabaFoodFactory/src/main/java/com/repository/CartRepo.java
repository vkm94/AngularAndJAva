package com.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.Cart;
@Repository
public interface CartRepo extends CrudRepository<Cart,String> {

}
