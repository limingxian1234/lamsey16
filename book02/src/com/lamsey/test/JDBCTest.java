package com.lamsey.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		
		try{
			
			
			//1.ע������
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName("com.mysql.jdbc.Driver");//�����������װ�ص���������Ƽ�
			
			//2.��������
			String url = "jdbc:mysql://localhost/php";//url--- jdbc(Э��)��mysql(��Э��)��
			String user = "root";
			String password = "537423Ab";
			Connection conn = DriverManager.getConnection(url,user,password);
			//3���������
			java.sql.Statement st = conn.createStatement();//����ʹ��java��׼��
			//4��ִ�����
			ResultSet rs = st.executeQuery("select * from nsg");
			// 5.������
			while (rs.next()) {
				System.out.println(rs.getObject(1) + "\t" + rs.getObject(2) + "\t"
						+ rs.getObject(3) + "\t" +rs.getObject(4));
			}
			// 6.�ͷ���Դ
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e){
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
