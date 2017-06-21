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

	//�û���¼
	public User login(User user) {
		return userDao.findUserByUsernameAndPassword(user);
	
	}

	//�����û��������û���Ϣ
	public boolean usernameExist(String username) {
		User user = userDao.findUserByUsername(username);
		//���ҵ��û����ͷ���true
		if (user != null){
			return true;
		} else{
			return false;
		}
		
	}

}
