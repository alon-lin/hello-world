package com.hp.entity;

import java.io.Serializable;

import com.hp.util.PageUtil;

public class ChongEntity extends PageUtil implements Serializable {
	private int oid;
	private int rid;
	private	float omoney;
	private	int yid;
	private	float osmoney;
	private	float olastmoney;
	private	int uid;
	private	String oremark;
	private	String  otime;
	
	private String rname;
	private String ytitle;
	private String uname;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public float getOmoney() {
		return omoney;
	}
	public void setOmoney(float omoney) {
		this.omoney = omoney;
	}
	public int getYid() {
		return yid;
	}
	public void setYid(int yid) {
		this.yid = yid;
	}
	public float getOsmoney() {
		return osmoney;
	}
	public void setOsmoney(float osmoney) {
		this.osmoney = osmoney;
	}
	public float getOlastmoney() {
		return olastmoney;
	}
	public void setOlastmoney(float olastmoney) {
		this.olastmoney = olastmoney;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getOremark() {
		return oremark;
	}
	public void setOremark(String oremark) {
		this.oremark = oremark;
	}
	public String getOtime() {
		return otime;
	}
	public void setOtime(String otime) {
		this.otime = otime;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getYtitle() {
		return ytitle;
	}
	public void setYtitle(String ytitle) {
		this.ytitle = ytitle;
	}
	
	
	
	
}
