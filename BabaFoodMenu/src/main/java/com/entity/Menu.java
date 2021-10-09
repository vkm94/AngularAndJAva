package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String id;
	
	String name;
	String descr;
	String price;
	String img;
	
	public Menu(String id, String name, String descr, String price, String img) {
		super();
		this.id = id;
	
		this.name = name;
		this.descr = descr;
		this.price = price;
		this.img = img;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", desc=" + descr + ", price=" + price + ", img="
				+ img + "]";
	}


}
