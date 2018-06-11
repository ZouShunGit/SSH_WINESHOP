<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="main">
		<form action="user/userAction_regist.action" method="post"
			onsubmit="return checkFrom()" style="margin: 15px auto">
			<table align="center">
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">邮箱账号<span
						style="color: red;">*</span>：
					</td>
					<td><input type="text" id="uemail" name="uemail"
						onblur="checkEmail()" class="yanseA"><label id="tyla"></label></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">手机号<span
						style="color: red;">*</span>：
					</td>
					<td><input type="text" id="utel" name="utel"
						onblur="checkTel()" class="yanseA"><span id="tel_init"></span></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">姓名<span
						style="color: red;">*</span>：
					</td>
					<td><input type="text" id="uname" name="uname" class="yanseA"
						onblur="checkName()"><span id="uname_init"></span></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">性别：</td>
					<td>男<input type="radio" id="usex" name="usex" value="男"
						checked="checked">女<input type="radio" id="usex"
						name="usex" value="女"></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">年龄：</td>
					<td><input type="text" id="age" name="uage"
						onblur="checkAge()" class="yanseA"> <span id="age_init"></span></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">家庭住址：</td>
					<td><input type="text" id="address" name="uaddress"
						class="yanseA"></td>
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
						type="submit" value="注册" class="login">&nbsp;&nbsp;<input
						type="reset" value="重置" class="login"></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		var email_Boolean = false;
		var tel_Boolean = false;
		var uname_Boolean = false;
		var password_Boolean = false;
		var password2_Boolean = false;
		/* 邮箱验证 */
		function checkEmail() {
			var uemail = document.getElementById("uemail").value;
			if ((/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/)
					.test(uemail)) {
				var xhr = new XMLHttpRequest();
				/* 确定请求地址和请求参数 */
				var url = "user/userAction_findByEmail.action?uemail=" + uemail
						+ "";
				/* 调用XMLHttpRequest对象的open()方法建立对服务器的调用 */
				xhr.open("post", url, true)
				//指定响应事件处理函数
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4 && xhr.status == 200) {
						if (xhr.responseText == 0) {
							document.getElementById("tyla").innerHTML = "<font color='red'>邮箱账号已被注册，不能重复注册</font>";
							email_Boolean = false;
						} else {
							document.getElementById("tyla").innerHTML = "<font color='green'>邮箱账号可以使用</font>";
							email_Boolean = true;
						}
					}
				}
				//向服务器发送请求
				xhr.send();
			} else {
				document.getElementById("tyla").innerHTML = "<font color='red'>邮箱账号输入错误</font>";
				email_Boolean = false;
				return false;
			}
		}
		/* 验证手机号 */
		function checkTel() {
			var utel = document.getElementById("utel").value;
			if ((/^1[3|4|5|7|8][0-9]\d{4,8}$/).test(utel)) {
				tel_Boolean = true;
				document.getElementById("tel_init").innerHTML = '<font color="green">✔</font>';
			} else {
				tel_Boolean = false;
				document.getElementById('tel_init').innerHTML = "<font color='red'>×</font>";
			}
		}
		/* 检查姓名 */
		function checkName() {
			var uname = document.getElementById("uname").value;
			if (uname == "" || uname == null) {
				uname_Boolean = false;
				document.getElementById('uname_init').innerHTML = "<font color='red'>姓名为必填项</font>";
			} else {
				uname_Boolean = true;
				document.getElementById("uname_init").innerHTML = '<font color="green">✔</font>';
			}
		}

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
			alert(email_Boolean + "," + tel_Boolean + "," + uname_Boolean + ","
					+ password_Boolean);
			if (email_Boolean & tel_Boolean & uname_Boolean & password_Boolean
					& password2_Boolean == true) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>
</html>