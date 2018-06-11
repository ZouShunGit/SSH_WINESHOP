<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新密码输入</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="margin: 50px 200px">
		<form method="post" action="user/userAction_editPass.action?uemail=<s:property value="#session.existUser.uemail"/>"
			onsubmit="return checkFrom();" target="_top">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;"></td>
					<td><span style="color: red;"><s:actionerror /></span></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">密码<span
						style="color: red;">*</span>：
					</td>
					<td><input type="password" id="password" name="password"
						onblur="CheckPass()" class="yanseA"> <span
						id="password_init"></span></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">确认密码<span
						style="color: red;">*</span>：
					</td>
					<td><input type="password" id="password2" name="password2"
						class="yanseA" onblur="checkPassA()"> <span
						id="password2_init"></span></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">&nbsp;</td>
					<td align="center"
						style="color: #000; font-size: 16px; line-height: 30px;"><input
						type="submit" value="确认" class="login">&nbsp;&nbsp;<input
						type="reset" value="重置" class="login"></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		var password_Boolean = false;
		var password2_Boolean = false;
		/* 检查密码 */
		function CheckPass() {
			// 获得文件框值:
			var password = document.getElementById("password").value;
			if (password == "" || password == null) {
				password_Boolean = false;
				document.getElementById('password_init').innerHTML = "<font color='red'>密码不能为空</font>";
			} else {
				password_Boolean = true;
				document.getElementById("password_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		//确认密码检查
		function checkPassA() {
			// 获得文件框值:
			var password = document.getElementById("password").value;
			var password2 = document.getElementById("password2").value;

			if (password2 != password) {
				password2_Boolean = false;
				document.getElementById('password2_init').innerHTML = "<font color='red'>两次密码不一致</font>";
			} else {
				password2_Boolean = true;
				document.getElementById("password2_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		function checkFrom() {
			if (password_Boolean == false) {
				alert("密码输入错误！")
				return false;
			} else if (password_Boolean & password_Boolean2 == true) {
				return true
			} else
				return false;
		}
	</script>
</body>
</html>