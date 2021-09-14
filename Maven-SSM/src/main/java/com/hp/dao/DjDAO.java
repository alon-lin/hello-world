package com.hp.dao;

import java.util.List;

import com.hp.entity.DjEntity;

public interface DjDAO {
	// 全查询
	public List<DjEntity> allDj();

	// 分页查询
	public List<DjEntity> pageDj(DjEntity djEntity);

	// 统计
	public int getCount();

	// 添加
	public void addDj(DjEntity dj);

	// 修改
	public void updDj(DjEntity dj);

	// 查询一个
	public DjEntity selDj(int did);
	
	//重复等级名称
	public int getCheckName(String dname);
}
