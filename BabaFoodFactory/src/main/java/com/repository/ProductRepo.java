package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.product;
@Repository
public interface ProductRepo extends CrudRepository<product,String> {

}
