package com.repo;

import org.springframework.data.repository.CrudRepository;

import com.entity.Menu;

public interface MenuRepo extends CrudRepository<Menu, String> {

}
