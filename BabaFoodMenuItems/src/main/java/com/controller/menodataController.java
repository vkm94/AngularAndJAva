package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Menu;

@RestController
public class menodataController {
	@Autowired
	public MenuController mc;
	
	@PostMapping("/addMenu")
	public String addmenu(@RequestBody Menu menu) {
		String add=mc.addMenu(menu);		
		return add;
		
	}
	
	@PutMapping("/update/{id}")
	public String addupdate(@PathVariable String id, @RequestBody Menu menu) {
		String update=mc.addUpdate(id,menu);		
		return update;
		
	}

	@DeleteMapping("/delete/{id}")
	public String DeleteMenuItems(@PathVariable String id) {
		if(mc.deleteMenuItem(id) != null) {
			return "Error";
		}
		return " Success";
	}
}
