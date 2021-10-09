package com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.HotelMenu;

@RestController
public class HotelMenuController {
	
	@Autowired
	public  HotelMenuOperations hc;
	@PostMapping("/addMenuItems")
	public String addMenu(@RequestBody HotelMenu menu)
	{
		String add=hc.AddItems(menu);
		return add;
		
	}
	@PutMapping("/UpdateMenuItems/{id}")
	public String UpdateItems(@PathVariable String id, @RequestBody HotelMenu menu)
	{
	String up=	hc.UpdateItems(id,menu);
		return up;
		
	}
	@GetMapping("/getItems")
	public List<HotelMenu> getItems()
	{
	List<HotelMenu> up=	hc.getList();
	System.out.println(hc.getList());
		return hc.getList();
		
	}

}
