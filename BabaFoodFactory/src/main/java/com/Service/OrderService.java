package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.OrderRepo;
import com.user.Order;

@Service
public class OrderService {
	@Autowired
	OrderRepo or;

	public Iterable<Order> getList() {
	return or.findAll();
		
	}
	
	
	

}
