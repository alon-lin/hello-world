package com.hp.service;

import java.util.List;

import com.hp.entity.CpinfoEntity;


public interface CpinfoService {
	//全查询
	public List<CpinfoEntity> allCpinfo();
	
	//分页查询
	public List<CpinfoEntity> pageCpinfo(CpinfoEntity Cpinfo);
	//统计
	public int getCount();
	
	//添加
	public void addCpinfo(CpinfoEntity Cpinfo);
	//修改
	public void updCpinfo(CpinfoEntity Cpinfo);
	
	//查询一个
	public CpinfoEntity selCpinfo(int fid);
	//根据产品名称查销售数量
	public CpinfoEntity getByName(int fid);
	
	//弹窗
	public int getMsg();
	//库存小于10
	public List<CpinfoEntity> getCountMsg();
	
	
}
