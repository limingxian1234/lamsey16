package com.lamsey.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("helloworld");//�������ݿ����ӳض���
	/**
	 * ��c3p0���ӳ��л�ȡ���ݿ����Ӷ���<br/>
	 * @return �������null,���ȡʧ��<br/>
	 * ������ֵ�����ȡ�ɹ�
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
	 * ��c3p0���ӳ����ͷ����ݿ����Ӷ���
	 * @param connection �ͷ����ݿ����Ӷ���
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
