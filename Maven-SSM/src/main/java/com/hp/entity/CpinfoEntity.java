package com.hp.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hp.util.PageUtil;

public class CpinfoEntity extends PageUtil implements Serializable {
	private int fid;
	private String fname;
	private int cid;
	private String fdw;
	private String faddress;
	private float foutprice;
	private float finprice;
	private String fimg;
	private int fcount;
	private int xcount;
	
	
	
	public int getXcount() {
		return xcount;
	}


	public void setXcount(int xcount) {
		this.xcount = xcount;
	}






	// 注意这两个参数不能变
	private String name;
	private List data;

	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
	


	public List getData() {
		return data;
	}


	public void setData(List data) {
		this.data = data;
	}






	// 折扣价
	private float price;

	// 小计
	private float allPrice;
	
	private double count;
	
	
	





	public double getCount() {
		return count;
	}


	public void setCount(double count) {
		this.count = count;
	}






	private Integer id;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	


	private CommonsMultipartFile img;
	
	
	private String cname;

	
	
	public CommonsMultipartFile getImg() {
		return img;
	}


	public void setImg(CommonsMultipartFile img) {
		this.img = img;
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


	public int getFid() {
		return fid;
	}


	public void setFid(int fid) {
		this.fid = fid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getFdw() {
		return fdw;
	}


	public void setFdw(String fdw) {
		this.fdw = fdw;
	}


	public String getFaddress() {
		return faddress;
	}


	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}


	public float getFoutprice() {
		return foutprice;
	}


	public void setFoutprice(float foutprice) {
		this.foutprice = foutprice;
	}


	public float getFinprice() {
		return finprice;
	}


	public void setFinprice(float finprice) {
		this.finprice = finprice;
	}


	public String getFimg() {
		return fimg;
	}


	public void setFimg(String fimg) {
		this.fimg = fimg;
	}


	public int getFcount() {
		return fcount;
	}


	public void setFcount(int fcount) {
		this.fcount = fcount;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}
	

}
