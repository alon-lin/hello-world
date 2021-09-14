package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.MemberDAO;
import com.hp.entity.MemberEntity;
import com.hp.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	public List<MemberEntity> allMember() {
		
		return dao.allMember();
	}

	public List<MemberEntity> pageMember(MemberEntity Member) {
		
		return dao.pageMember(Member);
	}

	public int getCount() {
		
		return dao.getCount();
	}

	public void addMember(MemberEntity Member) {
		dao.addMember(Member);
	}

	public void updMember(MemberEntity Member) {
		dao.updMember(Member);

	}

	public MemberEntity selMember(int uid) {
		
		return dao.selMember(uid);
	}

	public MemberEntity getRcard(String rcard) {
		
		return dao.getRcard(rcard);
	}

	public List<MemberEntity> group() {
		return dao.group();
	}

	public List<MemberEntity> getByDid(int did) {
		return dao.getByDid(did);
	}

	public int getCount1(int did) {
		// TODO Auto-generated method stub
		return dao.getCount1(did);
	}

	public List<MemberEntity> getRjf(MemberEntity member) {
		// TODO Auto-generated method stub
		return dao.getRjf(member);
	}

	public List<MemberEntity> getTwo(MemberEntity member) {
		// TODO Auto-generated method stub
		return dao.getTwo(member);
	}

	public List<MemberEntity> getOt(MemberEntity member) {
		return dao.getOt(member);
	}

	public int getCouRjf(MemberEntity member) {
		// TODO Auto-generated method stub
		return dao.getCouRjf(member);
	}

	public int getCouTwo(MemberEntity member) {
		// TODO Auto-generated method stub
		return dao.getCouTwo(member);
	}

	public int getCouOt(MemberEntity member) {
		return dao.getCouOt(member);
	}

}
