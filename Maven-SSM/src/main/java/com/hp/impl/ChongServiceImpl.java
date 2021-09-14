package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.ChongDAO;
import com.hp.entity.ChongEntity;
import com.hp.service.ChongService;

@Service
public class ChongServiceImpl implements ChongService{

	@Autowired
	private ChongDAO dao;

	public List<ChongEntity> allChong() {
		
		return dao.allChong();
	}

	public List<ChongEntity> pageChong(ChongEntity Chong) {
		
		return dao.pageChong(Chong);
	}

	public int getCount() {
		
		return dao.getCount();
	}

	public void addChong(ChongEntity Chong) {
		dao.addChong(Chong);
		
	}

	public void updChong(ChongEntity Chong) {
		dao.updChong(Chong);
		
	}

	public ChongEntity selChong(int oid) {
		
		return dao.selChong(oid);
	}
	
	
}
