package com.lamsey.service.impl;

import com.lamsey.bean.User;
import com.lamsey.dao.UserDao;
import com.lamsey.dao.impl.UserDaoImpl;
import com.lamsey.service.UserService;

public class UserServiceIpml implements UserService {
	
	private static UserDao userDao;
	public UserServiceIpml(){
		userDao = new UserDaoImpl();
	}
	
	public void registUser(User user) {
		userDao.saveUser(user);

	}

	//用户登录
	public User login(User user) {
		return userDao.findUserByUsernameAndPassword(user);
	
	}

	//根据用户名查找用户信息
	public boolean usernameExist(String username) {
		User user = userDao.findUserByUsername(username);
		//查找到用户，就返回true
		if (user != null){
			return true;
		} else{
			return false;
		}
		
	}

}
