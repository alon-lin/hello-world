package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.CarxlDAO;
import com.hp.entity.CarxlEntity;
import com.hp.service.CarxlService;

@Service
public class CarxlServiceImpl implements CarxlService {

	@Autowired
	private CarxlDAO dao;

	public List<CarxlEntity> allCarxl() {

		return dao.allCarxl();
	}

	public List<CarxlEntity> pageCarxl(CarxlEntity Carxl) {

		return dao.pageCarxl(Carxl);
	}

	public int getCount() {

		return dao.getCount();
	}

	public void addCarxl(CarxlEntity Carxl) {

		dao.addCarxl(Carxl);
	}

	public void updCarxl(CarxlEntity Carxl) {
		dao.updCarxl(Carxl);

	}

	public CarxlEntity selCarxl(int xid) {

		return dao.selCarxl(xid);
	}

}
