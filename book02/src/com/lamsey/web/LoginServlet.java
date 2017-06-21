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

    //����֮��һ�㶼ʹ��post????
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1����ȡ�����û���������---servlet
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		2������service���ҵ��login����
		User user = userService.login(new User(0,username,password,""));
//		3������login�ķ���ֵ�жϻ�����ǰ��--��½�ɹ�����ת��login-success;��½ʧ��������ԭҳ��
		if (user == null){
//			System.out.println("��½ʧ��");
//			String projectPath = request.getContextPath();
//			String fullPath = projectPath + "/pages/user/login.jsp";
//			System.out.println(fullPath);
//			response.sendRedirect(fullPath);//�ض���
			request.setAttribute("msg", "��½ʧ��,�û������������");
			request.setAttribute("username", username);
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);//ת��
		} else {
			System.out.println("��½�ɹ�");
			request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
		}		
	}

}
