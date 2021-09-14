package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.LipinDAO;
import com.hp.entity.LipinEntity;
import com.hp.service.LipinService;


@Service
public class LipinServiceImpl implements LipinService {

	@Autowired
	private LipinDAO dao;
	
	public List<LipinEntity> allLipin() {
		
		return dao.allLipin();
	}

	public List<LipinEntity> pageLipin(LipinEntity Lipin) {
		
		return dao.pageLipin(Lipin);
	}

	public int getCount() {
		
		return dao.getCount();
	}

	public void addLipin(LipinEntity Lipin) {
		dao.addLipin(Lipin);

	}

	public void updLipin(LipinEntity Lipin) {
		
dao.updLipin(Lipin);
	}

	public LipinEntity selLipin(int nid) {
		
		return dao.selLipin(nid);
	}

}
