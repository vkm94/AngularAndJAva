package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

}
