package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String cid;
	String pid;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String cid, String pid, String hid, String uid, String count, String amt, String avl) {
		super();
		this.cid = cid;
		this.pid = pid;
		this.hid = hid;
		this.uid = uid;
		this.count = count;
		this.amt = amt;
		Avl = avl;
	}
	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", pid=" + pid + ", hid=" + hid + ", uid=" + uid + ", count=" + count + ", amt="
				+ amt + ", Avl=" + Avl + "]";
	}
	String hid;
	String uid;
	String count;
	String amt;
	String Avl;
	public String getCid() {
		return cid;
	}
	public String setCid(String cid) {
		return this.cid = cid;
	}
	public String getPid() {
		return pid;
	}
	public String setPid(String pid) {
		return this.pid = pid;
	}
	public String getHid() {
		return hid;
	}
	public String setHid(String hid) {
		return this.hid = hid;
	}
	public String getUid() {
		return uid;
	}
	public String setUid(String uid) {
		return this.uid = uid;
	}
	public String getCount() {
		return count;
	}
	public String setCount(String count) {
		return this.count = count;
	}
	public String getAmt() {
		return amt;
	}
	public String setAmt(String amt) {
		return this.amt = amt;
	}
	public String getAvl() {
		return Avl;
	}
	public String setAvl(String avl) {
		return Avl = avl;
	}
	

}
