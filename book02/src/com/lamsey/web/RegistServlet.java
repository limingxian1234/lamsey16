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
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;   
  
    public RegistServlet() {
        super();
        userService = new UserServiceIpml();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、先获取传递过来的参数.获取表单数据用post下的request.getParameter()
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		//2、对获取的数据进行处理
		//2.1验证码必须为abcde
		if("abcde".equalsIgnoreCase(code)){ //equalsIgnoreCase()表示忽视大小写
			//2。2 检查用户名是否存在
			 boolean usernameExist = userService.usernameExist(username);
			 if(usernameExist) {
					//先把需要回显的信息保存在request域对象中
				 //错误信息：用户名、邮箱
				request.setAttribute("msg", "用户名已经存在!");
				request.setAttribute("username", username);
				request.setAttribute("email", email);
				 
				 //用户名已经存在，提示
				 System.out.println("用户名【" +username + "]已经存在");
				//获取工程路径
				/*String projectPath = request.getContextPath();
				//验证码错误就重定向回注册页面
				response.sendRedirect(projectPath + "/pages/user/regist.jsp");*/
				 
			    request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			 } else{
				 //2.3 用户名不存在，那么注册用户，跳转到注册成功页面
				 userService.registUser(new User(0,username,password,email));
				System.out.println("用户注册成功，跳转到注册成功页面");
				request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);;
			 }
		} else{
			//先把需要回显的信息保存在request域对象中
			 //错误信息：用户名、邮箱
			request.setAttribute("msg", "验证码错误！注册失败");
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			
			System.out.println("验证码错误！注册失败");
			//获取工程路径
			/*String projectPath = request.getContextPath();
			//验证码错误就重定向回注册页面
			response.sendRedirect(projectPath + "/pages/user/regist.jsp");*/
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

}
