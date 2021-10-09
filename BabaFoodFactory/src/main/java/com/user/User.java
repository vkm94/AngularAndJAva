package com.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private String name;
private String email;
private int phno;
private String address;
private String password;
private String type;
private String id;
public User(String name, String email, int phno, String address, String password, String type, String id) {
	super();
	this.name = name;
	this.email = email;
	this.phno = phno;
	this.address = address;
	this.password = password;
	this.type = type;
	this.id = id;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getPhno() {
	return phno;
}
public void setPhno(int phno) {
	this.phno = phno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


public User() {
	super();
	
}

@Override
public String toString() {
	return "User [name=" + name + ", email=" + email + ", phno=" + phno + ", address=" + address + ", password="
			+ password + ", type=" + type + ", id=" + id + "]";
}


}
