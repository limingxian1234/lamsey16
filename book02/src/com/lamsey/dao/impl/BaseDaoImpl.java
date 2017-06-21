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
	private Class<T>  type;//����
	
	public BaseDaoImpl(){
		queryRunner = new QueryRunner();
		//this ��ʾ��ǰ����ʵ�����Ķ���Ҳ����UserDaoImpl
		System.out.println(this);
		//��ȡ���������
		System.out.println(this.getClass().getSuperclass());
		//��ȡ���з�����Ϣ�ĸ�������
		ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) this.getClass().getGenericSuperclass();
	//	System.out.println(parameterizedType);
		//getActualTypeArguments() �Ӵ��з�����Ϣ�ĸ����л�ȡ����ķ�������
		type = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		System.out.println(type);
	}
	/**
	 * ���²���
	 * @param sql
	 * �������
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
	 * ��ѯ���ݿ��Ķ�����¼
	 * @param sql
	 *   ��ѯ�����
	 * @param params
	 *   ��ѯ�ķ��ؽ��<br/>
	 * @return
	 *   �����ѯʧ�ܷ���null
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
	 * ��ѯ���ݿ���һ����¼
	 * @param sql
	 *   ��ѯ�����
	 * @param params
	 *   ��ѯ�ķ��ؽ��<br/>
	 * @return
	 *   �����ѯʧ�ܷ���null
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
