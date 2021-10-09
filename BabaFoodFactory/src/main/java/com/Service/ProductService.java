package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.ProductRepo;
import com.user.product;
@Service
public class ProductService {
	@Autowired
	ProductRepo pr;
	
	
	public Iterable<product> getList() {
		pr.findAll();
		
		
		return pr.findAll();
		
	}
	
	
	
	
	
	
	
}