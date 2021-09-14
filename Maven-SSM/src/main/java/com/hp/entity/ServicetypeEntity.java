package com.hp.entity;

import java.io.Serializable;

import com.hp.util.PageUtil;

public class ServicetypeEntity extends PageUtil implements Serializable {
	private int sid;
	private String sname;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
