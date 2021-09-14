package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.JiciDAO;
import com.hp.entity.JiciEntity;
import com.hp.service.JiciService;

@Service
public class JiciServiceImpl implements JiciService {

	@Autowired
	private JiciDAO dao;
	
	public List<JiciEntity> allJici() {
		
		return dao.allJici();
	}

	public List<JiciEntity> pageJici(JiciEntity Jici) {
		
		return dao.pageJici(Jici);
	}

	public int getCount() {
		
		return dao.getCount();
	}

	public void addJici(JiciEntity Jici) {
		
dao.addJici(Jici);
	}

	public void updJici(JiciEntity Jici) {
		
dao.updJici(Jici);
	}

	public JiciEntity selJici(int jid) {
		
		return dao.selJici(jid);
	}

}
