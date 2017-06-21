package com.lamsey.dao.impl;

import com.lamsey.bean.User;
import com.lamsey.dao.UserDao;
import com.lamsey.utils.JdbcUtils;
import com.mysql.jdbc.Connection;
//实现接口
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
		
	//用户注册
	public int saveUser(User user) {
		//插入用户sql语句
		String sql = "insert into t_user(username,password,email) values (?,?,?);";
		//子类接口自动拥有父类方法
		return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
	}

	//用户登录，根据用户名和密码查找用户
	public User findUserByUsernameAndPassword(User user) {
		//插入用户sql语句
		String sql = "SELECT id,username,password,email from t_user where username = ? and password = ?;";
		//子类接口自动拥有父类方法
		return queryOne(sql,user.getUsername(),user.getPassword());		
	}

	//验证用户名是否存在
	//1、sql语句查询所有用户名
	public User findUserByUsername(String username) {
		//插入用户sql语句
		String sql = "SELECT username,password,email from t_user where username = ?;";
		//子类接口自动拥有父类方法
		return queryOne(sql,username);		
	}

}
