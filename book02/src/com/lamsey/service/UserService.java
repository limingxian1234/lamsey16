package com.lamsey.service;

import com.lamsey.bean.User;

public interface UserService {

	/**
	 * �û�ע��
	 * @param user
	 */
	public void registUser( User user );	
	

	/**
	 * �û���¼
	 * @param user
	 * @return User
	 */
	public User login( User user );	
	/**
	 * ��֤�û����Ƿ����
	 * @param username
	 * @return boolean
	 */
	public boolean usernameExist( String username );	
}
