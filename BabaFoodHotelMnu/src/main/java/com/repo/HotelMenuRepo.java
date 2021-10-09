package com.repo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.HotelMenu;
@Repository
public interface HotelMenuRepo extends CrudRepository<HotelMenu, String> {
	@ManyToMany(cascade = CascadeType.ALL)
	
	@Query(value="SELECT hotelmenu.id,hotelmenu.hid,hotelmenu.pid,hotelmenu.price,hotelmenu.status,hotel.name FROM hotelmenu join menu \r\n" + 
			"   ON hotelmenu.pid=menu.id\r\n" + 
			"   JOIN hotel on hotelmenu.hid=hotel.id ",nativeQuery = true)
	public List<HotelMenu> GetList();

}
