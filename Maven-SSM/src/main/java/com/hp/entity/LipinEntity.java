package com.hp.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hp.util.PageUtil;

public class LipinEntity extends PageUtil implements Serializable {
	private int nid;
	private String nname;
	private String nimg;
	private int njf;
	private int ncount;
	private int nncount;
	
	
	private String name;
	private List<Integer> date;
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getDate() {
		return date;
	}
	public void setDate(List<Integer> date) {
		this.date = date;
	}
	private CommonsMultipartFile img;
	
	
	public CommonsMultipartFile getImg() {
		return img;
	}
	public void setImg(CommonsMultipartFile img) {
		this.img = img;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public String getNimg() {
		return nimg;
	}
	public void setNimg(String nimg) {
		this.nimg = nimg;
	}
	public int getNjf() {
		return njf;
	}
	public void setNjf(int njf) {
		this.njf = njf;
	}
	public int getNcount() {
		return ncount;
	}
	public void setNcount(int ncount) {
		this.ncount = ncount;
	}
	public int getNncount() {
		return nncount;
	}
	public void setNncount(int nncount) {
		this.nncount = nncount;
	}

}
