package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cart;
import com.repo.CartRepo;

@RestController
public class CartOperations {
	@Autowired
	public CartRepo cr;

	public String addToCart(Cart cart) {
		if(cr.save(cart) != null) {
			return "Success";
		}
		return "Error";
		
	}

	public String Updatecart(String id, Cart cart) {
		Cart c=cr.findById(id).orElse(null);
	
		c.setPid(cart.getPid());
		c.setAmt(cart.getAmt());
		c.setHid(cart.getHid());
		c.setCount(cart.getCount());
		c.setAvl(cart.getAvl());
		
		  if(cr.save(c) != null) { return "Success"; }
		 
		return "Error";
	}

	public String DeleteCart(String cid) {
		if(cr.existsById(cid)) {
			Cart c=cr.findById(cid).orElse(null);
			cr.delete(c);
			return "Success";
		}
		
		return "Empty";
	}
	
	
}
