package com.hp.dao;

import java.util.List;

import com.hp.entity.CarxlEntity;


public interface CarxlDAO {
	//全查询
	public List<CarxlEntity> allCarxl();
	
	//分页查询
	public List<CarxlEntity> pageCarxl(CarxlEntity Carxl);
	//统计
	public int getCount();
	
	//添加
	public void addCarxl(CarxlEntity Carxl);
	//修改
	public void updCarxl(CarxlEntity Carxl);
	
	//查询一个
	public CarxlEntity selCarxl(int xid);
}
