package com.controller;

import java.util.Arrays;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Service.CartService;
import com.Service.OrderService;
import com.Service.ProductService;
import com.Service.UserService;
import com.user.Cart;
import com.user.Order;
import com.user.User;
import com.user.product;

@RestController
@RequestMapping("/mainApp")
//@ComponentScan("com")
public class maninapp {
	@Autowired
	private UserService us;

	@PostMapping("/loginclass")
	public boolean Login(@PathVariable String email,@PathVariable String password) {
		if(us.login(email, password)) {
			return true;
		}
		return false;
	}
	@PostMapping("/login")
	public String type(@PathVariable String email,@PathVariable String password) {
		if(us.type(email, password) != null) {
			return "user";
		}
		return "admin";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public String user() {
		
		System.out.println(us.getAll());
		
		return us.getAll().toString();
		
	}
	@Autowired
	private CartService cs;
	@RequestMapping("/cart")
	@ResponseBody
	public Iterable<Cart> cart() {
		
		return cs.getAll();
		
	}
@Autowired
private ProductService ps;
@RequestMapping("/product")

public Iterable<product> pl(){
	
	ps.getList();
	
	return ps.getList();
	
}
@Autowired
private OrderService os;
@RequestMapping("/order")
@ResponseBody
public Iterable<Order> ol(){
	os.getList();
	return os.getList();
	
}


RestTemplate restTemplate;

@RequestMapping( "/template/products")
public String getProductList() {
   HttpHeaders headers = new HttpHeaders();
   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
   HttpEntity <String> entity = new HttpEntity<String>(headers);
   
   return restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
}

	
}