package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.CartRepo;
import com.user.Cart;


@Service
public class CartService {
	@Autowired
	CartRepo cr;
	
	public String addTOCart(String id,String uid,String pid,String count ) {
		Cart c=new Cart(id,uid,pid,count);
		cr.save(c);
		return null;
		}
	public String delerte(String id,String uid,String pid,String count ) {
		Cart c=new Cart(id,uid,pid,count);
		cr.deleteById(id);
		return null;
		}
	public Iterable<Cart>  getAll() {
		//cr.findAll();
		return cr.findAll();
	}
	
	
	
	}