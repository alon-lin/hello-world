package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.CpinfoDAO;
import com.hp.entity.CpinfoEntity;
import com.hp.service.CpinfoService;

@Service
public class CpinfoServiceImpl implements CpinfoService {

	@Autowired
	private CpinfoDAO dao;

	public List<CpinfoEntity> allCpinfo() {

		return dao.allCpinfo();
	}

	public List<CpinfoEntity> pageCpinfo(CpinfoEntity Cpinfo) {

		return dao.pageCpinfo(Cpinfo);
	}

	public int getCount() {

		return dao.getCount();
	}

	public void addCpinfo(CpinfoEntity Cpinfo) {
		dao.addCpinfo(Cpinfo);

	}

	public void updCpinfo(CpinfoEntity Cpinfo) {

		dao.updCpinfo(Cpinfo);

	}

	public CpinfoEntity selCpinfo(int fid) {

		return dao.selCpinfo(fid);
	}

	public CpinfoEntity getByName(int fid) {
		return dao.getByName(fid);
	}

	public int getMsg() {
		// TODO Auto-generated method stub
		return dao.getMsg();
	}

	public List<CpinfoEntity> getCountMsg() {
		// TODO Auto-generated method stub
		return dao.getCountMsg();
	}

}
