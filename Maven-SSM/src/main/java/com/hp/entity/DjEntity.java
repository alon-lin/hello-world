package com.hp.entity;

import java.io.Serializable;

import com.hp.util.PageUtil;

public class DjEntity extends PageUtil implements Serializable {
	private int did;
	private String dname;
	private int djf;
	private double dmoneyBl;
	private double dzk;

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getDjf() {
		return djf;
	}

	public void setDjf(int djf) {
		this.djf = djf;
	}

	public double getDmoneyBl() {
		return dmoneyBl;
	}

	public void setDmoneyBl(double dmoneyBl) {
		this.dmoneyBl = dmoneyBl;
	}

	public double getDzk() {
		return dzk;
	}

	public void setDzk(double dzk) {
		this.dzk = dzk;
	}

}
