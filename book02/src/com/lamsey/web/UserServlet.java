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
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;  
    public UserServlet() {
        super();
        userService = new UserServiceIpml();
    }

	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//在jsp提交的表格form中加入隐藏input标签	
	String action = request.getParameter("action");
	//通过获取隐藏标签action的内容进行判断调用相应的功能servlet方法
	if("login".equals(action)) {
		login(request,response);
	} else if("regist".equals(action)){
		regist(request,response);
	}
	}
	*/
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
