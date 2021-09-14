package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.DuihuanDAO;
import com.hp.entity.DuihuanEntity;
import com.hp.service.DuihuanService;

@Service
public class DuihuanServiceImpl implements DuihuanService {

	
	@Autowired
	private DuihuanDAO dao;
	public List<DuihuanEntity> allDuihuan() {
		
		return dao.allDuihuan();
	}

	public List<DuihuanEntity> pageDuihuan(DuihuanEntity Duihuan) {
		
		return dao.pageDuihuan(Duihuan);
	}

	public int getCount() {
		
		return dao.getCount();
	}

	public void addDuihuan(DuihuanEntity Duihuan) {
		dao.addDuihuan(Duihuan);

	}

	public void updDuihuan(DuihuanEntity Duihuan) {
		dao.updDuihuan(Duihuan);

	}

	public DuihuanEntity selDuihuan(int yid) {
		
		return dao.selDuihuan(yid);
	}

	public List<DuihuanEntity> page(DuihuanEntity Duihuan) {
		// TODO Auto-generated method stub
		return dao.page(Duihuan);
	}

	public int getCount1(int nid) {
		// TODO Auto-generated method stub
		return dao.getCount1(nid);
	}

	public List<DuihuanEntity>  getByName() {
		return dao.getByName();
	}

}
