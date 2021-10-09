package com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.entity.HotelMenu;
import com.repo.HotelMenuRepo;
@RestController 
public class HotelMenuOperations {
@Autowired
	public HotelMenuRepo hr;
	public String AddItems(HotelMenu menu) {
		if(hr.save(menu) != null) {
			return "Success";
		}
		return "Fsiled";
		
	}
	public String UpdateItems(String id, HotelMenu menu) {
		
		HotelMenu hm=hr.findById(id).orElse(null);
		hm.setStatus(menu.getStatus());
		hm.setPrice(menu.getPrice());
		if(hr.save(hm) != null) {
			return "Success";
			
		}
		return"Failed";
	}
	public List<HotelMenu> getList() {
		
		return hr.GetList();
	}

}
