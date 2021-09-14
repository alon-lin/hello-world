package com.hp.dao;

import java.util.List;

import com.hp.entity.ChongEntity;


public interface ChongDAO {
	//全查询
	public List<ChongEntity> allChong();
	
	//分页查询
	public List<ChongEntity> pageChong(ChongEntity Chong);
	//统计
	public int getCount();
	
	//添加
	public void addChong(ChongEntity Chong);
	//修改
	public void updChong(ChongEntity Chong);
	
	//查询一个
	public ChongEntity selChong(int oid);
}
