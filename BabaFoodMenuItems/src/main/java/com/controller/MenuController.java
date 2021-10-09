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

	public String addUpdate(String id, Menu menu) {
		Menu m =mr.findById(id).orElse(null);
		m.setName(menu.getName());
		
		m.setImg(menu.getImg());
		m.setDescr(menu.getDescr());
		if(mr.save(m) != null) {
			return "Success";
		}
		return "Error";
	}

	public String deleteMenuItem(String id) {
		if(mr.existsById(id)) {
			Menu delete=mr.findById(id).orElse(null);
			mr.delete(delete);
				return "Success";
		}
		return "Data Not Found";
	}
	

}
