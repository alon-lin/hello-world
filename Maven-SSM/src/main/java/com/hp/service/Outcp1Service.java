package com.hp.service;

import java.util.List;

import com.hp.entity.Outcp1Entity;

public interface Outcp1Service {
	// 全查询
	public List<Outcp1Entity> allOutcp1();

	// 分页查询
	public List<Outcp1Entity> pageOutcp1(Outcp1Entity Outcp1);

	// 统计
	public int getCount();

	// 添加
	public void addOutcp1(Outcp1Entity Outcp1);

	// 修改
	public void updOutcp1(Outcp1Entity Outcp1);

	// 查询一个
	public Outcp1Entity selOutcp1(int tid);

	// 分页查询
	public List<Outcp1Entity> page(Outcp1Entity Outcp1);

	// 统计
	public int getCount1(int fid);
}
