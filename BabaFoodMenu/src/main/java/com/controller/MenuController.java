package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Menu;
import com.repo.MenuRepo;

@RestController
public class MenuController {
	@Autowired
	public MenuRepo mr;

	public String addMenu(Menu menu) {
		 if(mr.save(menu) != null) {
			 return "Added";
			 }
		 
		return "Error While Adding";
	}
	

}
