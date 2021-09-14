package com.hp.service;

import java.util.List;

import com.hp.entity.CartypeEntity;

public interface CartypeService {
	//全查询
	public List<CartypeEntity> allCartype();
	
	//分页查询
	public List<CartypeEntity> pageCartype(CartypeEntity Cartype);
	//统计
	public int getCount();
	
	//添加
	public void addCartype(CartypeEntity Cartype);
	//修改
	public void updCartype(CartypeEntity Cartype);
	
	//查询一个
	public CartypeEntity selCartype(int aid);
}
