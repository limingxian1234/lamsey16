package com.lamsey.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取Action的参数
		String action = request.getParameter("action");
		//2、通过action属性，调用需要调用的业务方法
		try {
			Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class,HttpServletResponse.class);// .class文件
		//3、调用这个业务方法执行业务
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    }
}
