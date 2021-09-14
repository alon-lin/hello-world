package com.hp.dao;

import java.util.List;

import com.hp.entity.ServicetypeEntity;

public interface ServiceTypeDAO {
	//全查询
	public List<ServicetypeEntity> allServiceType();
	
	//分页查询
	public List<ServicetypeEntity> pageServiceType(ServicetypeEntity Servicetype);
	//统计
	public int getCount();
	
	//添加
	public void addServiceType(ServicetypeEntity Servicetype);
	//修改
	public void updServiceType(ServicetypeEntity Servicetype);
	
	//查询一个
	public ServicetypeEntity selServiceType(int sid);
}
