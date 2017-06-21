package com.lamsey.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lamsey.bean.User;
import com.lamsey.dao.UserDao;
import com.lamsey.dao.impl.UserDaoImpl;

public class UserDaoTest {
	private static UserDao UserDao;
	//BeforeClass 在测试之前进行执行，做一些初始化工作
	@BeforeClass
	public static void setUpBeforeClass(){
		System.out.println("11111");
		UserDao = new UserDaoImpl();
	}
	@Test
	public void testRegistUser() {
		int updateCount = UserDao.saveUser(new User(0,"yangweiwu","234567","yww@qq.com"));
		System.out.println(updateCount);
	}

	@Test
	public void testLogin() {
		System.out.println("测试");
		System.out.println(UserDao.findUserByUsernameAndPassword(new User(0,"huangyucheng","654321",null)));
		System.out.println(UserDao.findUserByUsernameAndPassword(new User(0,"lamsey","537423",null)));
	}

	@Test
	public void testUsernameExist() {
		System.out.println(UserDao.findUserByUsername("lamsey"));
	}

}
