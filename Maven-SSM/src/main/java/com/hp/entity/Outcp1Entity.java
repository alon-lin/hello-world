package com.hp.entity;

import java.io.Serializable;

import com.hp.util.PageUtil;

public class Outcp1Entity extends PageUtil implements Serializable {
	private int wid;
	private int fid;
	private int wcount;
	private String wname;
	private String wtel;
	private int uid;
	private String wtime;
	//产品售价
	private float foutprice;
	
	//小计
	private float price;
	//产品名称
	private String fname;
	//产品类别
	private String cname;
	private String uname;
	
	
	public float getFoutprice() {
		return foutprice;
	}
	public void setFoutprice(float foutprice) {
		this.foutprice = foutprice;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getWcount() {
		return wcount;
	}
	public void setWcount(int wcount) {
		this.wcount = wcount;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getWtel() {
		return wtel;
	}
	public void setWtel(String wtel) {
		this.wtel = wtel;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getWtime() {
		return wtime;
	}
	public void setWtime(String wtime) {
		this.wtime = wtime;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	

}
