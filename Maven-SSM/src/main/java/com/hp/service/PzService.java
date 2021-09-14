package com.hp.service;

import java.util.List;

import com.hp.entity.PzEntity;

public interface PzService {
	//全查询
	public List<PzEntity> allPz();
	
	//分页查询
	public List<PzEntity> pagePz(PzEntity pz);
	//统计
	public int getCount();
	
	//添加
	public void addPz(PzEntity pz);
	//修改
	public void updPz(PzEntity pz);
	
	//查询一个
	public PzEntity selPz(int zid);
}
