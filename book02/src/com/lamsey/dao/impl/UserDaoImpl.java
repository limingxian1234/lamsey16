package com.lamsey.dao.impl;

import com.lamsey.bean.User;
import com.lamsey.dao.UserDao;
import com.lamsey.utils.JdbcUtils;
import com.mysql.jdbc.Connection;
//ʵ�ֽӿ�
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
		
	//�û�ע��
	public int saveUser(User user) {
		//�����û�sql���
		String sql = "insert into t_user(username,password,email) values (?,?,?);";
		//����ӿ��Զ�ӵ�и��෽��
		return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
	}

	//�û���¼�������û�������������û�
	public User findUserByUsernameAndPassword(User user) {
		//�����û�sql���
		String sql = "SELECT id,username,password,email from t_user where username = ? and password = ?;";
		//����ӿ��Զ�ӵ�и��෽��
		return queryOne(sql,user.getUsername(),user.getPassword());		
	}

	//��֤�û����Ƿ����
	//1��sql����ѯ�����û���
	public User findUserByUsername(String username) {
		//�����û�sql���
		String sql = "SELECT username,password,email from t_user where username = ?;";
		//����ӿ��Զ�ӵ�и��෽��
		return queryOne(sql,username);		
	}

}
