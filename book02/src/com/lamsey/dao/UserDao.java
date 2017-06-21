package com.lamsey.dao;

import com.lamsey.bean.User;

public interface UserDao {	
	//�����û�
	public int saveUser( User user );
	// �����û�������������û�
	public User findUserByUsernameAndPassword( User user );
	/**
	 * �����û��������û���Ϣ
	 * @param username ���ҵ��û���
	 * @return   ���ز��ҵ����û���Ϣ<br>
	 * ����û��������ڣ�����null
	 */
	public User findUserByUsername( String username );
		
}
