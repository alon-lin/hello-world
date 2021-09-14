package com.hp.entity;

import java.io.Serializable;

import com.hp.util.PageUtil;

public class LookEntity extends PageUtil implements Serializable {
	private int kid;
	private int rid;
	private String ktime;
	private String kremark;
	private int uid;

	private String rname;
	private String uname;
	private String rcard;

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getKtime() {
		return ktime;
	}

	public void setKtime(String ktime) {
		this.ktime = ktime;
	}

	public String getKremark() {
		return kremark;
	}

	public void setKremark(String kremark) {
		this.kremark = kremark;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public String getRcard() {
		return rcard;
	}

	public void setRcard(String rcard) {
		this.rcard = rcard;
	}

}
