package com.lamsey.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lamsey.bean.User;
import com.lamsey.service.UserService;
import com.lamsey.service.impl.UserServiceIpml;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
    public LoginServlet() {
        super();
        userService = new UserServiceIpml();
    }

    //工作之后一般都使用post????
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1、获取表单的用户名和密码---servlet
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		2、调用service层的业务login方法
		User user = userService.login(new User(0,username,password,""));
//		3、根据login的返回值判断回馈给前端--登陆成功则跳转到login-success;登陆失败则跳回原页面
		if (user == null){
//			System.out.println("登陆失败");
//			String projectPath = request.getContextPath();
//			String fullPath = projectPath + "/pages/user/login.jsp";
//			System.out.println(fullPath);
//			response.sendRedirect(fullPath);//重定向
			request.setAttribute("msg", "登陆失败,用户名或密码错误");
			request.setAttribute("username", username);
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);//转发
		} else {
			System.out.println("登陆成功");
			request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
		}		
	}

}
