package com.lamsey.service;

import com.lamsey.bean.User;

public interface UserService {

	/**
	 * 用户注册
	 * @param user
	 */
	public void registUser( User user );	
	

	/**
	 * 用户登录
	 * @param user
	 * @return User
	 */
	public User login( User user );	
	/**
	 * 验证用户名是否存在
	 * @param username
	 * @return boolean
	 */
	public boolean usernameExist( String username );	
}
