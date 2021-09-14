package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.GetcpDAO;
import com.hp.entity.GetcpEntity;
import com.hp.service.GetcpService;

@Service
public class GetcpServiceImpl implements GetcpService {

	@Autowired
	private GetcpDAO dao;

	public List<GetcpEntity> allGetcp() {

		return dao.allGetcp();
	}

	public List<GetcpEntity> pageGetcp(GetcpEntity Getcp) {

		return dao.pageGetcp(Getcp);
	}

	public int getCount() {

		return dao.getCount();
	}

	public void addGetcp(GetcpEntity Getcp) {
		dao.addGetcp(Getcp);

	}

	public void updGetcp(GetcpEntity Getcp) {

		dao.updGetcp(Getcp);
	}

	public GetcpEntity selGetcp(int gid) {

		return dao.selGetcp(gid);
	}

	public List<GetcpEntity> selAll(int fid) {
		return dao.selAll(fid);
	}

	public int getCount1(int fid) {
		return dao.getCount1(fid);
	}

}
