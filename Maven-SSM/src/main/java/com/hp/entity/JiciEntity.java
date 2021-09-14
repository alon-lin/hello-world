package com.hp.entity;

import java.io.Serializable;

import com.hp.util.PageUtil;

public class JiciEntity extends PageUtil implements Serializable {
	private int jid;
	private int rid;
	private String jtime;
	private int sid;
	private float jmoney;
	private int uid;

	
	private String rcard;
	private float rmoney;
	private String rname;
	private String uname;
	private String sname;
	
	
	

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getRcard() {
		return rcard;
	}

	public void setRcard(String rcard) {
		this.rcard = rcard;
	}

	public float getRmoney() {
		return rmoney;
	}

	public void setRmoney(float rmoney) {
		this.rmoney = rmoney;
	}

	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getJtime() {
		return jtime;
	}

	public void setJtime(String jtime) {
		this.jtime = jtime;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public float getJmoney() {
		return jmoney;
	}

	public void setJmoney(float jmoney) {
		this.jmoney = jmoney;
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

}
