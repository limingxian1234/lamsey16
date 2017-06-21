<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>尚硅谷会员登录页面</title>

<%--base标签  css样式  jquery的引入--%>
<%@include file="/pages/common/head.jsp" %>
<script type="text/javascript">
	$(function(){
		$("#sub_btn").click(function(){
			// 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
			//1.先获取文本框里的内容
			var usernameTextValue = $("#username").val();
			//2.创建一个正则表达式，用于验证用户名是否合法
			var patt = /^\w{5,12}$/;
			//test判断文本框里的内容是否合法
			if (!patt.test(usernameTextValue)) {
				//3.提示用户
				alert("用户名不合法！");
				return false;
			}
			
			// 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
			//1.先获取文本框里的内容
			var passwordTextValue = $("#password").val();
			//2.创建一个正则表达式，用于验证用户名是否合法
			var passwordPatt = /^\w{5,12}$/;
			//test判断文本框里的内容是否合法
			if (!passwordPatt.test(passwordTextValue)) {
				//3.提示用户
				alert("密码不合法！");
				return false;
			}
			
			return true;
		});
	});
</script>

</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg"><%=request.getAttribute("msg") == null ? "请输入用户名和密码" :request.getAttribute("msg")%></span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
									<!-- 用来判断servlet方法的标签 -->
									<input type="hidden" name="action" value="login"/>
									
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"
									value ="<%=request.getAttribute("username") == null ? "" : request.getAttribute("username")%>"
									/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password"/>
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>