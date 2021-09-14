package com.hp.service;

import java.util.List;

import com.hp.entity.JiciEntity;


public interface JiciService {
	//全查询
	public List<JiciEntity> allJici();
	
	//分页查询
	public List<JiciEntity> pageJici(JiciEntity Jici);
	//统计
	public int getCount();
	
	//添加
	public void addJici(JiciEntity Jici);
	//修改
	public void updJici(JiciEntity Jici);
	
	//查询一个
	public JiciEntity selJici(int jid);
}
