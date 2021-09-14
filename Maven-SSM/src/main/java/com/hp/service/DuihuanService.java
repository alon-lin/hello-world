package com.hp.service;

import java.util.List;

import com.hp.entity.DuihuanEntity;

public interface DuihuanService {
	// 全查询
	public List<DuihuanEntity> allDuihuan();

	// 分页查询
	public List<DuihuanEntity> pageDuihuan(DuihuanEntity Duihuan);

	// 统计
	public int getCount();

	// 添加
	public void addDuihuan(DuihuanEntity Duihuan);

	// 修改
	public void updDuihuan(DuihuanEntity Duihuan);

	// 查询一个
	public DuihuanEntity selDuihuan(int yid);

	// 分页查询
	public List<DuihuanEntity> page(DuihuanEntity Duihuan);

	// 统计
	public int getCount1(int nid);
	
	public List<DuihuanEntity> getByName();
}
