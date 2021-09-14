package com.hp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.dao.UserDAO;
import com.hp.entity.UserEntity;
import com.hp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	public List<UserEntity> allUser() {

		return dao.allUser();
	}

	public List<UserEntity> pageUser(UserEntity user) {

		return dao.pageUser(user);
	}

	public int getCount() {

		return dao.getCount();
	}

	public void addUser(UserEntity user) {
		dao.addUser(user);

	}

	public void updUser(UserEntity user) {

		dao.updUser(user);
	}

	public UserEntity selUser(int uid) {

		return dao.selUser(uid);
	}

	public int userLogin(UserEntity user) {

		return dao.userLogin(user);
	}

	public UserEntity getUser(UserEntity user) {

		return dao.getUser(user);
	}

	public int getCheckName(UserEntity user) {
		return dao.getCheckName(user);
	}

}
