package com.hp.dao;

import java.util.List;

import com.hp.entity.GetcpEntity;


public interface GetcpDAO {
	//全查询
	public List<GetcpEntity> allGetcp();
	
	//分页查询
	public List<GetcpEntity> pageGetcp(GetcpEntity Getcp);
	//统计
	public int getCount();
	
	//添加
	public void addGetcp(GetcpEntity Getcp);
	//修改
	public void updGetcp(GetcpEntity Getcp);
	
	//查询一个
	public GetcpEntity selGetcp(int gid);
	
	public List<GetcpEntity> selAll(int fid);
	public int getCount1(int fid);
}
