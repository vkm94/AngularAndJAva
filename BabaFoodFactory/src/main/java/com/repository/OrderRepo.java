package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.user.Order;

public interface OrderRepo extends CrudRepository<Order,String> {

}
