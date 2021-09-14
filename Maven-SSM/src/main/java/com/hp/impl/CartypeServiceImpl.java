package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.CartypeDAO;
import com.hp.entity.CartypeEntity;
import com.hp.service.CartypeService;

@Service
public class CartypeServiceImpl implements CartypeService {

	@Autowired
	private CartypeDAO dao;
	
	public List<CartypeEntity> allCartype() {
		
		return dao.allCartype();
	}

	public List<CartypeEntity> pageCartype(CartypeEntity Cartype) {
		
		return dao.pageCartype(Cartype);
	}

	public int getCount() {
		
		return dao.getCount();
	}

	public void addCartype(CartypeEntity Cartype) {
		dao.addCartype(Cartype);

	}

	public void updCartype(CartypeEntity Cartype) {
		dao.updCartype(Cartype);

	}

	public CartypeEntity selCartype(int aid) {
		
		return dao.selCartype(aid);
	}

}
