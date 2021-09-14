package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.CpTypeDAO;
import com.hp.entity.CptypeEntity;
import com.hp.service.CpTypeService;

@Service
public class CpTypeServiceImpl implements CpTypeService {

	@Autowired
	private CpTypeDAO dao;
	
	public List<CptypeEntity> allCptype() {
		
		return dao.allCptype();
	}

	public List<CptypeEntity> pageCptype(CptypeEntity CptypeEntity) {
		
		return dao.pageCptype(CptypeEntity);
	}

	public int getCount() {
		
		return dao.getCount();
	}

	public void addCptype(CptypeEntity Cptype) {
		dao.addCptype(Cptype);

	}

	public void updCptype(CptypeEntity Cptype) {
		dao.updCptype(Cptype);

	}

	public CptypeEntity selCptype(int cid) {
		
		return dao.selCptype(cid);
	}

}
