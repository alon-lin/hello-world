package com.hp.service;

import java.util.List;

import com.hp.entity.CptypeEntity;

public interface CpTypeService {
	//全查询
	public List<CptypeEntity> allCptype();
	
	//分页查询
	public List<CptypeEntity> pageCptype(CptypeEntity CptypeEntity);
	//统计
	public int getCount();
	
	//添加
	public void addCptype(CptypeEntity Cptype);
	//修改
	public void updCptype(CptypeEntity Cptype);
	
	//查询一个
	public CptypeEntity selCptype(int cid);
}
