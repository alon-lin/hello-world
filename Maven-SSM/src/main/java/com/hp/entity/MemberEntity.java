package com.hp.entity;

import java.io.Serializable;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hp.util.PageUtil;

public class MemberEntity extends PageUtil implements Serializable {
	private int rid;
	private String rcard;
	private String rname;
	private String rpsw;

	private String rtel;

	private String rbirthday;

	private double rjf;
	private String rcarnum;

	private String rcolor;
	private float rway;

	private String rnum;
	private String raddress;
	private String rremark;
	private String rtime;
	private float rmoney;
	
	private float dmoneyBl;
	
	private int count;
	
	private int tt;
	
	
	
	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	private int onejf;
	private int twojf;
	private int threejf;
	
	
	
	
	
	public int getOnejf() {
		return onejf;
	}

	public void setOnejf(int onejf) {
		this.onejf = onejf;
	}

	public int getTwojf() {
		return twojf;
	}

	public void setTwojf(int twojf) {
		this.twojf = twojf;
	}

	public int getThreejf() {
		return threejf;
	}

	public void setThreejf(int threejf) {
		this.threejf = threejf;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float getDmoneyBl() {
		return dmoneyBl;
	}

	public void setDmoneyBl(float dmoneyBl) {
		this.dmoneyBl = dmoneyBl;
	}

	private CommonsMultipartFile img;
	
	//会员折扣
	private float dzk;
	// 凭证编号
	private int zid;
	private String zname;
	// 汽车系列编号
	private int xid;
	private String xname;
	// 等级编号
	private int did;
	private String dname;
	// 性别
	private int rsex;
	private String sex;
	// 卡状态
	private int rstatus;
	private String status;
	// 图片
	private String rimg;
	private String aname;
	
	
	

	public float getDzk() {
		return dzk;
	}

	public void setDzk(float dzk) {
		this.dzk = dzk;
	}

	public CommonsMultipartFile getImg() {
		return img;
	}

	public void setImg(CommonsMultipartFile img) {
		this.img = img;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRcard() {
		return rcard;
	}

	public void setRcard(String rcard) {
		this.rcard = rcard;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRpsw() {
		return rpsw;
	}

	public void setRpsw(String rpsw) {
		this.rpsw = rpsw;
	}

	public String getRtel() {
		return rtel;
	}

	public void setRtel(String rtel) {
		this.rtel = rtel;
	}

	public String getRbirthday() {
		return rbirthday;
	}

	public void setRbirthday(String rbirthday) {
		this.rbirthday = rbirthday;
	}

	public double getRjf() {
		return rjf;
	}

	public void setRjf(double rjf) {
		this.rjf = rjf;
	}

	public String getRcarnum() {
		return rcarnum;
	}

	public void setRcarnum(String rcarnum) {
		this.rcarnum = rcarnum;
	}

	public String getRcolor() {
		return rcolor;
	}

	public void setRcolor(String rcolor) {
		this.rcolor = rcolor;
	}

	public float getRway() {
		return rway;
	}

	public void setRway(float rway) {
		this.rway = rway;
	}

	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}

	public String getRaddress() {
		return raddress;
	}

	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}

	public String getRremark() {
		return rremark;
	}

	public void setRremark(String rremark) {
		this.rremark = rremark;
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

	public float getRmoney() {
		return rmoney;
	}

	public void setRmoney(float rmoney) {
		this.rmoney = rmoney;
	}

	public int getZid() {
		return zid;
	}

	public void setZid(int zid) {
		this.zid = zid;
	}

	public String getZname() {
		return zname;
	}

	public void setZname(String zname) {
		this.zname = zname;
	}

	public int getXid() {
		return xid;
	}

	public void setXid(int xid) {
		this.xid = xid;
	}

	public String getXname() {
		return xname;
	}

	public void setXname(String xname) {
		this.xname = xname;
	}

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

	public int getRsex() {
		return rsex;
	}

	public void setRsex(int rsex) {
		this.rsex = rsex;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getRstatus() {
		return rstatus;
	}

	public void setRstatus(int rstatus) {
		this.rstatus = rstatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRimg() {
		return rimg;
	}

	public void setRimg(String rimg) {
		this.rimg = rimg;
	}
}
