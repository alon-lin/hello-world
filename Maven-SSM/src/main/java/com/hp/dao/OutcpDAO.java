package com.hp.dao;

import java.util.List;

import com.hp.entity.OutcpEntity;

public interface OutcpDAO {
	// 全查询
	public List<OutcpEntity> allOutcp();

	// 分页查询
	public List<OutcpEntity> pageOutcp(OutcpEntity Outcp);

	// 统计
	public int getCount();

	// 添加
	public void addOutcp(OutcpEntity Outcp);

	// 修改
	public void updOutcp(OutcpEntity Outcp);

	// 查询一个
	public OutcpEntity selOutcp(int tid);

	// 分页查询
	public List<OutcpEntity> page(OutcpEntity Outcp);

	// 统计
	public int getCount1(int fid);
}
