package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.ServiceTypeDAO;
import com.hp.entity.ServicetypeEntity;
import com.hp.service.ServiceTypeService;

@Service
public class ServicetypeImpl implements ServiceTypeService {

	@Autowired
	private ServiceTypeDAO dao;
	
	public List<ServicetypeEntity> allServiceType() {
		
		return dao.allServiceType();
	}

	public List<ServicetypeEntity> pageServiceType(ServicetypeEntity Servicetype) {
		
		return dao.pageServiceType(Servicetype);
	}

	public int getCount() {
		
		return dao.getCount();
	}

	public void addServiceType(ServicetypeEntity Servicetype) {
		dao.addServiceType(Servicetype);

	}

	public void updServiceType(ServicetypeEntity Servicetype) {
		dao.updServiceType(Servicetype);

	}

	public ServicetypeEntity selServiceType(int sid) {
		
		return dao.selServiceType(sid);
	}

}
