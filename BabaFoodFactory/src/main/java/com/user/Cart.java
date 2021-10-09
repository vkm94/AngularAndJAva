package com.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cart")


public class Cart {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getCount() {
	return count;
}
public void setCount(String count) {
	this.count = count;
}

@Override
public String toString() {
	return "Cart [id=" + id + ", uid=" + uid + ", pid=" + pid + ", count=" + count + "]";
}
private String id;
public Cart() {
	super();
	// TODO Auto-generated constructor stub
}
public Cart(String id, String uid, String pid, String count) {
	super();
	this.id = id;
	this.uid = uid;
	this.pid = pid;
	this.count = count;
}
private String uid;
private String pid;
private String count;



}
