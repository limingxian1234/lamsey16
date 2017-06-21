<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>尚硅谷会员注册页面</title>

<%--base标签  css样式  jquery的引入--%>
<%@include file="/pages/common/head.jsp" %>

<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}

</style>
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
			
			// 验证确认密码：和密码相同
			//1.获取确认密码的内容 
			var repwdTextValue = $("#repwd").val();
			//2.跟密码比较
			if (repwdTextValue != passwordTextValue) {
				//3.提示用户
				alert("确认密码与密码不一致！");
				return false;
			}
			
			// 邮箱验证：xxxxx@xxx.com
			//1.先获取邮箱内容 。
			var emailTextValue = $("#email").val();
			//2.创建正是表达式对象
			var emailPatt = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			//3.验证并提示用户
			if (!emailPatt.test(emailTextValue)) {
				alert("邮箱格式不合法！");
				return false;
			}
			
			// 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
			// 1.获取验证码
			var codeTextValue = $("#code").val();
			//2.判断非空
// 			alert("去空格之前：[" + codeTextValue + "]");
			codeTextValue = $.trim(codeTextValue);
// 			alert("去空格之后：[" + codeTextValue + "]");
			if (codeTextValue == "") {
				alert("验证码不能为空！");
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
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg"><%=request.getAttribute("msg") == null ?"":request.getAttribute("msg") %></span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
									<!-- 用来判断servlet方法的标签 -->
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" 
									value = "<%= request.getAttribute("username") == null ?"":request.getAttribute("username") %>"
									/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" 
									value = "<%= request.getAttribute("email") == null ?"":request.getAttribute("email") %>"
									/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />

								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
			
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>