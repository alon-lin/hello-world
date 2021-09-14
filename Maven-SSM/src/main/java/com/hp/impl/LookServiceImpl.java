package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.LookDAO;
import com.hp.entity.LookEntity;
import com.hp.service.LookService;

@Service
public class LookServiceImpl implements LookService {

	@Autowired
	private LookDAO dao;
	
	public List<LookEntity> allLook() {
		
		return dao.allLook();
	}

	public List<LookEntity> pageLook(LookEntity Look) {
		
		return dao.pageLook(Look);
	}

	public int getCount(LookEntity Look) {
		
		return dao.getCount(Look);
	}

	public void addLook(LookEntity Look) {
		dao.addLook(Look);

	}

	public void updLook(LookEntity Look) {
		dao.updLook(Look);

	}

	public LookEntity selLook(int kid) {
		
		return dao.selLook(kid);
	}

}
