package com.hp.service;

import java.util.List;

import com.hp.entity.LipinEntity;


public interface LipinService {
	//全查询
	public List<LipinEntity> allLipin();
	
	//分页查询
	public List<LipinEntity> pageLipin(LipinEntity Lipin);
	//统计
	public int getCount();
	
	//添加
	public void addLipin(LipinEntity Lipin);
	//修改
	public void updLipin(LipinEntity Lipin);
	
	//查询一个
	public LipinEntity selLipin(int nid);
}
