<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录/注册</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/public.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="main" style="margin: 0 auto; height: 450px">
		<div class="hdk">
			<ul class="menu0" id="menu0">
				<li><a href="user/login.jsp" target="myFramea">登录</a></li>
				<li><a href="user/register.jsp" target="myFramea">注册</a></li>
				<li><a href="user/findPass.jsp" target="myFramea">忘记密码</a></li>
			</ul>
		</div>
		<diV class="piece" id="piece0" align="center" style="padding-top: 20px">
			<iframe name=myFramea src="user/login.jsp" width="80%" height="600px" frameborder="0"></iframe>
		</div>
	</div>
</body>
</html>