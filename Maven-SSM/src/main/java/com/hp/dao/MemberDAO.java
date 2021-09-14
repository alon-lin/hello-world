package com.hp.dao;

import java.util.List;

import com.hp.entity.MemberEntity;

public interface MemberDAO {
	//全查询
	public List<MemberEntity> allMember();
	//分页查询
	public List<MemberEntity> pageMember(MemberEntity Member);
	//统计总数
	public int getCount();
	//添加
	public void addMember(MemberEntity Member);
	//修改
	public void updMember(MemberEntity Member);
	//查询一个
	public MemberEntity selMember(int uid);
	public MemberEntity getRcard(String rcard);
	
	//图形表报
	//分组统计每种会员的个数
	public List<MemberEntity> group();
	//查询每种会员的对应的详细信息
	public List<MemberEntity> getByDid(int did);
	public int getCount1(int did);
	
	public List<MemberEntity> getRjf(MemberEntity member);
	
	public List<MemberEntity> getTwo(MemberEntity member);
	
	public List<MemberEntity> getOt(MemberEntity member);
	
	public int getCouRjf(MemberEntity member);
	public int getCouTwo(MemberEntity member);
	public int getCouOt(MemberEntity member);

}
