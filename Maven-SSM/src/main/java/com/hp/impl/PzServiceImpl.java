package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.PzDAO;
import com.hp.entity.PzEntity;
import com.hp.service.PzService;

@Service
public class PzServiceImpl implements PzService {

	@Autowired
	private PzDAO dao;

	public List<PzEntity> allPz() {

		return dao.allPz();
	}

	public List<PzEntity> pagePz(PzEntity pz) {

		return dao.pagePz(pz);
	}

	public int getCount() {

		return dao.getCount();
	}

	public void addPz(PzEntity pz) {
		dao.addPz(pz);

	}

	public void updPz(PzEntity pz) {

		dao.updPz(pz);
	}

	public PzEntity selPz(int zid) {

		return dao.selPz(zid);
	}

}
