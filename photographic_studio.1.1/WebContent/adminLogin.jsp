<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<title>管理登录</title>
</head>
<body>
	<div class="main">
		<div class="login">
			<h1>幸福影楼管理系统</h1>
			<div class="inset">
				<form method="post" action="admin/adminAction_login.action"
					onsubmit="return checkFrom()">
					<div>
						<h2>管理员登录</h2>
						<span><label>邮箱</label></span> <span><input type="text"
							class="textbox" name="aemail"></span>
					</div>
					<div>
						<span><label>密码</label></span> <span><input type="password"
							class="password" name="password"></span>
					</div>
					<div class="sign">
						<input type="submit" value="登录" class="submit" />
					</div>
					<div><center><span><s:actionerror/></span></center></div>
				</form>
			</div>
		</div>
	</div>
	<div class="copy-right">
		<p>&copy; 2015 Ethos Login Form. All Rights Reserved</p>
	</div>
</body>
</html>