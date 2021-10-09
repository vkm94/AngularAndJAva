package com.servise;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Hotel;
import com.repo.HotelRepo;

@RestController
public class HotelSevice {
	@Autowired	
public HotelRepo hr;

	
	  public Hotel hotel;
	  
	 
	@GetMapping("/hotels/{keyword}")
	  
	  @ResponseBody 
	  public List<Hotel>search(@PathVariable("keyword") String keyword) {
		return hr.search(keyword) ;
		
		
	  
	  }
	  
	  @GetMapping("/hotels") 
	  @ResponseBody 
	  public List<Hotel> getAllHotels() {
	  
	  ArrayList<Hotel> al=(ArrayList<Hotel>) hr.findAll();
	  //System.out.println(al); 
	  return al;
	  }
	 
	@PostMapping("/addHotel")
	
	//@ResponseBody
	public String addHotels(@RequestBody Hotel newHotel) {
		System.out.println(newHotel.toString());
		String name =newHotel.getName();
		String address =newHotel.getAddress();
		String cno =newHotel.getCno();
		String id =newHotel.getId();
		String rating =newHotel.getRating();
		String supply =newHotel.getSupply();
		String classes =newHotel.getClasses();
		newHotel.setName(name );
		hr.save(newHotel);
		//hr.save(new Hotel( name,address,cno,rating,supply, classes ));
		
		return "Success";
		
	}
	
	@PutMapping(path="/update/{id}")
	
	//@ResponseBody
	public String updateHotel(@PathVariable("id") String id,@RequestBody Hotel newHotel) {
		Hotel hotel = null;
	
		Hotel h=hr.findById(id).orElse(null);
		h.setName(newHotel.getName());
		h.setCno(newHotel.getCno());
		h.setAddress(newHotel.getAddress());
		h.setClasses(newHotel.getClasses());
		h.setRating(newHotel.getRating());
		h.setSupply(newHotel.getSupply());
		
		hr.save(h);
	
		//hr.save(new Hotel( name,address,cno,rating,supply, classes ));
		
		return "Success";
		
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		Hotel h=hr.findById(id).orElse(null);
		hr.delete(h);
		return "Success";
		
	}
}
