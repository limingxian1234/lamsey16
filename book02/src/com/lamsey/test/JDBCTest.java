package com.lamsey.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		
		try{
			
			
			//1.注册驱动
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName("com.mysql.jdbc.Driver");//根据类的名字装载到虚拟机，推荐
			
			//2.建立连接
			String url = "jdbc:mysql://localhost/php";//url--- jdbc(协议)，mysql(子协议)，
			String user = "root";
			String password = "537423Ab";
			Connection conn = DriverManager.getConnection(url,user,password);
			//3、创建语句
			java.sql.Statement st = conn.createStatement();//尽量使用java标准库
			//4、执行语句
			ResultSet rs = st.executeQuery("select * from nsg");
			// 5.处理结果
			while (rs.next()) {
				System.out.println(rs.getObject(1) + "\t" + rs.getObject(2) + "\t"
						+ rs.getObject(3) + "\t" +rs.getObject(4));
			}
			// 6.释放资源
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
