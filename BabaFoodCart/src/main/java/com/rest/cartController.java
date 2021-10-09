package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cart;
import com.repo.CartRepo;

@RestController
public class cartController {
	@Autowired
	CartOperations co;
	@PostMapping("/addToCart")
	public String AddTocart(@RequestBody Cart cart) {
		String c=co.addToCart(cart);
		return c;
	}
	
	@PutMapping("/UpdateCart/{id}")
	public String Updatecart(@PathVariable String id, @RequestBody Cart cart) {
		String update=co.Updatecart(id,cart);
		return update;
	}

	@DeleteMapping("/DeleteCart/{cid}")
	public String deleteCart(@PathVariable String cid) {
	
		String delete=co.DeleteCart(cid);
		return delete;
	}
}
