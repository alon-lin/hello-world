package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.Outcp1DAO;
import com.hp.entity.Outcp1Entity;
import com.hp.service.Outcp1Service;

@Service
public class Outcp1ServiceImpl implements Outcp1Service {

	@Autowired
	private Outcp1DAO dao;
	
	public List<Outcp1Entity> allOutcp1() {
		
		return dao.allOutcp1();
	}

	public List<Outcp1Entity> pageOutcp1(Outcp1Entity Outcp1) {
		
		return dao.pageOutcp1(Outcp1);
	}

	public int getCount() {
		
		return dao.getCount();
	}

	public void addOutcp1(Outcp1Entity Outcp1) {
		dao.addOutcp1(Outcp1);

	}

	public void updOutcp1(Outcp1Entity Outcp1) {
		dao.updOutcp1(Outcp1);

	}

	public Outcp1Entity selOutcp1(int tid) {
		
		return dao.selOutcp1(tid);
	}

	public List<Outcp1Entity> page(Outcp1Entity Outcp1) {
		
		return dao.page(Outcp1);
	}

	public int getCount1(int fid) {
		
		return dao.getCount1(fid);
	}

}
