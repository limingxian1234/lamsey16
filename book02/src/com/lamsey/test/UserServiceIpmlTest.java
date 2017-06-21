package com.lamsey.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lamsey.bean.User;
import com.lamsey.service.UserService;
import com.lamsey.service.impl.UserServiceIpml;

public class UserServiceIpmlTest {
	
	private static UserService userService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userService = new UserServiceIpml();
	}

	@Test
	public void testUserServiceIpml() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegistUser() {
		userService.registUser(new User(0,"lisi","123456","lisi@126.com"));
	}

	@Test
	public void testLogin() {
	System.out.println(userService.login(new User(0,"lisi","123456",null)));
	System.out.println(userService.login(new User(0,"li","123456",null)));
	}

	@Test
	public void testUsernameExist() {
		System.out.println(userService.usernameExist("lamsey"));
		System.out.println(userService.usernameExist("limingxian"));
	}
}
