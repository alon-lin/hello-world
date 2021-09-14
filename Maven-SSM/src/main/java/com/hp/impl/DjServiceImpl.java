package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.DjDAO;
import com.hp.entity.DjEntity;
import com.hp.service.DjService;

@Service
public class DjServiceImpl implements DjService {

	@Autowired
	private DjDAO dao;

	public List<DjEntity> allDj() {

		return dao.allDj();
	}

	public List<DjEntity> pageDj(DjEntity djEntity) {

		return dao.pageDj(djEntity);
	}

	public int getCount() {

		return dao.getCount();
	}

	public void addDj(DjEntity dj) {
		dao.addDj(dj);

	}

	public void updDj(DjEntity dj) {
		dao.updDj(dj);

	}

	public DjEntity selDj(int did) {
		return dao.selDj(did);
	}

	public int getCheckName(String dname) {
		return dao.getCheckName(dname);
	}

}
