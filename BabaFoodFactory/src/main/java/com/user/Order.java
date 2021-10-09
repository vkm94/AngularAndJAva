package com.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="Order_Table")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String oid;
	private String uid;
	private String amt;
	private String addr;
	private String quan;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getQuan() {
		return quan;
	}
	public void setQuan(String quan) {
		this.quan = quan;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", amt=" + amt + ", addr=" + addr + ", quan=" + quan + "]";
	}
	public Order(String oid, String uid, String amt, String addr, String quan) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.amt = amt;
		this.addr = addr;
		this.quan = quan;
	}
	public Order() {
		super();
		
	}
	
	}