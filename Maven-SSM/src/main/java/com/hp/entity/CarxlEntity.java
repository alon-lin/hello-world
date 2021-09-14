package com.hp.entity;

import java.io.Serializable;

import com.hp.util.PageUtil;

public class CarxlEntity extends PageUtil implements Serializable {
	private int xid;
	private int aid;
	private String xname;
	private String aname;
	public int getXid() {
		return xid;
	}
	public void setXid(int xid) {
		this.xid = xid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getXname() {
		return xname;
	}
	public void setXname(String xname) {
		this.xname = xname;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
}
