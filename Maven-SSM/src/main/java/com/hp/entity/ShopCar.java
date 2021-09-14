package com.hp.entity;

import java.io.Serializable;

public class ShopCar implements Serializable {
	// 会员卡号
private String rcard;

	private int id;

	private int cid;
	private int fid;

	// 购买数量
	private int xcount;
	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRcard() {
		return rcard;
	}

	public void setRcard(String rcard) {
		this.rcard = rcard;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getXcount() {
		return xcount;
	}

	public void setXcount(int xcount) {
		this.xcount = xcount;
	}

}
