package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Hotel;
@Repository
public interface HotelRepo extends CrudRepository<Hotel, String> {
	
	
	@Query(value="SELECT * from hotel WHERE "
			+"MATCH(name, address)"
			+"AGAINST(?1)",
			nativeQuery = true)
public List<Hotel> search(String keyword);
}
