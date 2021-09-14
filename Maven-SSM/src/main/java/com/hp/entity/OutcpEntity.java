package com.hp.entity;

import java.io.Serializable;

import com.hp.util.PageUtil;

public class OutcpEntity extends PageUtil implements Serializable {
	private int tid;
	private int rid;
	private int fid;
	private int xcount;
	private int uid;
	private String ttime;
	private int tflag;

	private String cname;
	private float foutprice;
	
	private float dzk;

	// 折扣价
	private float price;

	// 小计
	private float allPrice;

	/* 会员名称 */
	private String rname;
	/* 产品名称 */
	private String fname;
	/* 管理员名称 */
	private String uname;
	
	

	public float getDzk() {
		return dzk;
	}

	public void setDzk(float dzk) {
		this.dzk = dzk;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(float allPrice) {
		this.allPrice = allPrice;
	}

	public float getFoutprice() {
		return foutprice;
	}

	public void setFoutprice(float foutprice) {
		this.foutprice = foutprice;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTtime() {
		return ttime;
	}

	public void setTtime(String ttime) {
		this.ttime = ttime;
	}

	public int getTflag() {
		return tflag;
	}

	public void setTflag(int tflag) {
		this.tflag = tflag;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

}
