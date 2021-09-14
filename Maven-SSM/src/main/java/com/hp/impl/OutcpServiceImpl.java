package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.OutcpDAO;
import com.hp.entity.OutcpEntity;
import com.hp.service.OutcpService;

@Service
public class OutcpServiceImpl implements OutcpService {

	@Autowired
	private OutcpDAO dao;
	
	public List<OutcpEntity> allOutcp() {
		
		return dao.allOutcp();
	}

	public List<OutcpEntity> pageOutcp(OutcpEntity Outcp) {
		
		return dao.pageOutcp(Outcp);
	}

	public int getCount() {
		
		return dao.getCount();
	}

	public void addOutcp(OutcpEntity Outcp) {
		dao.addOutcp(Outcp);

	}

	public void updOutcp(OutcpEntity Outcp) {
		dao.updOutcp(Outcp);

	}

	public OutcpEntity selOutcp(int tid) {
		
		return dao.selOutcp(tid);
	}

	public List<OutcpEntity> page(OutcpEntity Outcp) {
		return dao.page(Outcp);
	}

	public int getCount1(int fid) {
		return dao.getCount1(fid);
	}

}
