package com.hp.dao;

import java.util.List;

import com.hp.entity.YouhuiEntity;


public interface YouhuiDAO {
	//全查询
	public List<YouhuiEntity> allYouhui();
	
	//分页查询
	public List<YouhuiEntity> pageYouhui(YouhuiEntity Youhui);
	//统计
	public int getCount();
	
	//添加
	public void addYouhui(YouhuiEntity Youhui);
	//修改
	public void updYouhui(YouhuiEntity Youhui);
	
	//查询一个
	public YouhuiEntity selYouhui(int yid);
}
