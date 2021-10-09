package com.AppDelegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.entity.Hotel;
import com.repo.HotelRepo;

@Service
@RestController
public class AppDelegate {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();

	}

	@Autowired
	private RestTemplate restTemplate;

	
	 public String getHotels(String name) {
	  
	 String response = restTemplate.exchange("http://hotel-client/hotels/{name}",
	  HttpMethod.GET, null, new ParameterizedTypeReference<String>() { },
	  name).getBody(); return name + "" + response;
	 
	  }
	 
	  public String addHotel( @RequestBody Hotel newHotel) {
	  
	  
	  ResponseEntity<String> response=restTemplate.exchange(
	  "http://hotel-client/addHotel",
	  HttpMethod.POST, null,new ParameterizedTypeReference<String>() {
		},newHotel);
	  if(response.equals(200)) { return "Success"; }
	  
	  
	  
	  return "Failed";
	  
	  //return "Success";
	  
	  }
	
	 

}
