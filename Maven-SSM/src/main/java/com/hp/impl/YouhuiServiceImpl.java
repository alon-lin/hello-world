package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.YouhuiDAO;
import com.hp.entity.YouhuiEntity;
import com.hp.service.YouhuiService;

@Service
public class YouhuiServiceImpl implements YouhuiService {

	@Autowired
	private YouhuiDAO dao;

	public List<YouhuiEntity> allYouhui() {

		return dao.allYouhui();
	}

	public List<YouhuiEntity> pageYouhui(YouhuiEntity Youhui) {

		return dao.pageYouhui(Youhui);
	}

	public int getCount() {

		return dao.getCount();
	}

	public void addYouhui(YouhuiEntity Youhui) {
		dao.addYouhui(Youhui);

	}

	public void updYouhui(YouhuiEntity Youhui) {
		dao.updYouhui(Youhui);

	}

	public YouhuiEntity selYouhui(int yid) {

		return dao.selYouhui(yid);
	}

}
