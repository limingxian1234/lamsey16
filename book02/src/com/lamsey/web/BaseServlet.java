package com.lamsey.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1����ȡAction�Ĳ���
		String action = request.getParameter("action");
		//2��ͨ��action���ԣ�������Ҫ���õ�ҵ�񷽷�
		try {
			Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class,HttpServletResponse.class);// .class�ļ�
		//3���������ҵ�񷽷�ִ��ҵ��
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    }
}
