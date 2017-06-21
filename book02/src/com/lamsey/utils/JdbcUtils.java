package com.lamsey.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("helloworld");//连接数据库连接池对象
	/**
	 * 从c3p0连接池中获取数据库连接对象<br/>
	 * @return 如果返回null,则获取失败<br/>
	 * 返回有值，则获取成功
	 */
	public static Connection getConnection(){
		Connection connection = null;
		try{
			connection = dataSource.getConnection();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 从c3p0连接池中释放数据库连接对象
	 * @param connection 释放数据库连接对象
	 */
	public static void releaseConnection(Connection connection){
		if (connection != null){
			try{
				connection.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
		}
	}
	
}
