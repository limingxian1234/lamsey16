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
		//1���Ȼ�ȡ���ݹ����Ĳ���.��ȡ��������post�µ�request.getParameter()
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		//2���Ի�ȡ�����ݽ��д���
		//2.1��֤�����Ϊabcde
		if("abcde".equalsIgnoreCase(code)){ //equalsIgnoreCase()��ʾ���Ӵ�Сд
			//2��2 ����û����Ƿ����
			 boolean usernameExist = userService.usernameExist(username);
			 if(usernameExist) {
					//�Ȱ���Ҫ���Ե���Ϣ������request�������
				 //������Ϣ���û���������
				request.setAttribute("msg", "�û����Ѿ�����!");
				request.setAttribute("username", username);
				request.setAttribute("email", email);
				 
				 //�û����Ѿ����ڣ���ʾ
				 System.out.println("�û�����" +username + "]�Ѿ�����");
				//��ȡ����·��
				/*String projectPath = request.getContextPath();
				//��֤�������ض����ע��ҳ��
				response.sendRedirect(projectPath + "/pages/user/regist.jsp");*/
				 
			    request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			 } else{
				 //2.3 �û��������ڣ���ôע���û�����ת��ע��ɹ�ҳ��
				 userService.registUser(new User(0,username,password,email));
				System.out.println("�û�ע��ɹ�����ת��ע��ɹ�ҳ��");
				request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);;
			 }
		} else{
			//�Ȱ���Ҫ���Ե���Ϣ������request�������
			 //������Ϣ���û���������
			request.setAttribute("msg", "��֤�����ע��ʧ��");
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			
			System.out.println("��֤�����ע��ʧ��");
			//��ȡ����·��
			/*String projectPath = request.getContextPath();
			//��֤�������ض����ע��ҳ��
			response.sendRedirect(projectPath + "/pages/user/regist.jsp");*/
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

}
