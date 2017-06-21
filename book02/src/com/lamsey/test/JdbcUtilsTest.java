package com.lamsey.test;

import org.junit.Test;

import com.lamsey.utils.JdbcUtils;

public class JdbcUtilsTest {
	@Test
   public void getConnectionTest(){
		for (int i = 0;i <= 100;i++){
			 System.out.println(JdbcUtils.getConnection());  	
		}
	
   }
}
