package com.hp.service;

import java.util.List;

import com.hp.entity.UserEntity;

public interface UserService {
	//全查询
	public List<UserEntity> allUser();
	//分页查询
	public List<UserEntity> pageUser(UserEntity user);
	//统计总数
	public int getCount();
	//添加
	public void addUser(UserEntity user);
	//修改
	public void updUser(UserEntity user);
	//查询一个
	public UserEntity selUser(int uid);
	//登录
	public int userLogin(UserEntity user);
	//根据登录全查询
	public UserEntity getUser(UserEntity user);
	
	//判断用户名是否有效
	public int getCheckName(UserEntity user);
}
