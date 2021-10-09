package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table(name="hotel")
public class Hotel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	String Id;
	String name;
	
	String cno;
	String Address;
	public Hotel(String name, String cno, String address, String classes, String supply, String rating) {
		super();
		this.name = name;
		
		this.cno = cno;
		this.Address = address;
		this.classes = classes;
		this.Supply = supply;
		this.rating = rating;
	}
	String classes;
	String Supply;
	String rating;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getSupply() {
		return Supply;
	}
	public void setSupply(String supply) {
		Supply = supply;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Hotel [name=" + name + ", Id=" + Id + ", cno=" + cno + ", Address=" + Address + ", classes=" + classes
				+ ", Supply=" + Supply + ", rating=" + rating + "]";
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
