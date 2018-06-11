<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div align="center" style="color: gray;">
		<form action="user/userAction_login.action" method="post"
			onsubmit="return checkFrom();" style="margin: 60px 30%;"
			target="_top">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				align="center">
				<tr>
					<td>&nbsp;</td>
					<td><center>
							<span style="color: red; font-weight: bold;"><s:actionerror /></span>
							<span style="color: green; font-weight: bold;"><s:actionmessage /></span>
						</center></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 18px; line-height: 50px;">邮箱：</td>
					<td><input type="text" id="email" name="uemail"
						onblur="checkEmail()" class="yanse"><span id="email_init"></span></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 18px; line-height: 50px;">密码：</td>
					<td><input type="password" id="password" name="password"
						onblur="checkPassword()" class="yanse"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2"><center>
							<input type="submit" value="登录" class="login">&nbsp;&nbsp;<input
								type="reset" value="重置" class="login">
						</center></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript">
	var email_Boolean = false;
	var password_Boolean = false;
	function checkEmail() {
		var email = document.getElementById("email").value;
		if ((/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/)
				.test(email)) {
			document.getElementById("email_init").innerHTML = '<font color="green">✔</font>'
			email_Boolean = true;
		} else {
			document.getElementById("email_init").innerHTML = '<font color="red">×</font>'
			email_Boolean = false;
		}
	}
	function checkPassword() {
		// 获得文件框值:
		var password = document.getElementById("password").value;
		if (password != "") {
			password_Boolean = true;
		} else {
			password_Boolean = false;
		}
	}
	function checkFrom() {
		if (email_Boolean == false) {
			alert("邮箱为空或输入错误");
			return false;
		} else if (password_Boolean == false) {
			alert("密码不能为空");
			return false;
		} else if (email_Boolean & password_Boolean == true) {
			return true;
		}
	}
</script>
</html>