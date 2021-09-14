package com.hp.service;

import java.util.List;

import com.hp.entity.LookEntity;


public interface LookService {
	//全查询
	public List<LookEntity> allLook();
	
	//分页查询
	public List<LookEntity> pageLook(LookEntity Look);
	//统计
	public int getCount(LookEntity Look);
	
	//添加
	public void addLook(LookEntity Look);
	//修改
	public void updLook(LookEntity Look);
	
	//查询一个
	public LookEntity selLook(int kid);
}
