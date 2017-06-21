package com.lamsey.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lamsey.utils.JdbcUtils;

public abstract class BaseDaoImpl<T> {
	private QueryRunner queryRunner;
	private Class<T>  type;//泛型
	
	public BaseDaoImpl(){
		queryRunner = new QueryRunner();
		//this 表示当前具体实例化的对象，也就是UserDaoImpl
		System.out.println(this);
		//获取父类的类型
		System.out.println(this.getClass().getSuperclass());
		//获取带有泛型信息的父类类型
		ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) this.getClass().getGenericSuperclass();
	//	System.out.println(parameterizedType);
		//getActualTypeArguments() 从带有泛型信息的父类中获取具体的泛型类型
		type = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		System.out.println(type);
	}
	/**
	 * 更新操作
	 * @param sql
	 * 更新语句
	 * @param params
	 * 
	 * @return
	 */
	public int update(String sql,Object...params){
		Connection conn = JdbcUtils.getConnection();
		try {
			return queryRunner.update(conn,sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(conn);
		}
		return 0;
	}
	/**
	 * 查询数据库表的多条记录
	 * @param sql
	 *   查询的语句
	 * @param params
	 *   查询的返回结果<br/>
	 * @return
	 *   如果查询失败返回null
	 */
	public List<T>  quearyList(String sql,Object... params){
		Connection conn = JdbcUtils.getConnection();
		try {
			return queryRunner.query(conn, sql, new BeanListHandler<T>(type),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.releaseConnection(conn);
		}
		return null;
	}
	
	/**
	 * 查询数据库表的一条记录
	 * @param sql
	 *   查询的语句
	 * @param params
	 *   查询的返回结果<br/>
	 * @return
	 *   如果查询失败返回null
	 */
	
	public T queryOne(String sql,Object... params){
		Connection conn = JdbcUtils.getConnection();
		try {
			return queryRunner.query(conn, sql, new BeanHandler<T>(type),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.releaseConnection(conn);
		}
		return null;
	}
}
