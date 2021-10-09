package com.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String pid;
public product(String pid, String name, String img, String price, String quantity, String des) {
	super();
	this.pid = pid;
	this.name = name;
	this.img = img;
	this.price = price;
	this.quantity = quantity;
	this.Des = des;
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getDes() {
	return Des;
}
public void setDes(String des) {
	Des = des;
}
private String name;
private String img;
private String price;
private String quantity;
private String Des;
public product() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "product [pid=" + pid + ", name=" + name + ", img=" + img + ", price=" + price + ", quantity=" + quantity
			+ ", Des=" + Des + "]";
}



}