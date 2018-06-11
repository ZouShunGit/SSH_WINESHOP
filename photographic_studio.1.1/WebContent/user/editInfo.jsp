<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息修改</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="margin: 0 auto">
		<form
			action="user/userAction_editInfo.action?id=<s:property value="model.id" />"
			method="post" onsubmit="return checkFrom()" style="margin: 15px auto">
			<table align="center" border="0" cellpadding="0" cellspacing="5">
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">邮箱账号<span
						style="color: red;">*</span>：
					</td>
					<td><input type="text" id="uemail" name="uemail"
						value="<s:property value="model.uemail"/>" readonly="readonly"
						class="yanseA" /><label id="tyla"></label></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">手机号<span
						style="color: red;">*</span>：
					</td>
					<td><input type="text" id="utel" name="utel"
						value="<s:property value="model.utel"/>" onblur="checkTel()"
						class="yanseA"><span id="tel_init"></span></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">姓名<span
						style="color: red;">*</span>：
					</td>
					<td><input type="text" id="uname" name="uname"
						value="<s:property value="model.uname"/>" class="yanseA"
						onblur="checkName()"><span id="uname_init"></span></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">性别：</td>
					<td>男<input type="radio" id="usex" name="usex"
						value="<s:property value="model.usex"/>" checked="checked">女<input
						type="radio" id="usex" name="usex" value="女"></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">年龄：</td>
					<td><input type="text" id="age" name="uage"
						value="<s:property value="model.uage"/>" onblur="checkAge()"
						class="yanseA"> <span id="age_init"></span></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">家庭住址：</td>
					<td><input type="text" id="address" name="uaddress"
						value="<s:property value="model.uaddress"/>" class="yanseA"></td>
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
						type="submit" value="提交" class="login">&nbsp;&nbsp;<input
						type="reset" value="重置" class="login"></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		var tel_Boolean = true;
		var uname_Boolean = true;
		
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
			if (tel_Boolean & uname_Boolean & password_Boolean
					& password2_Boolean == true) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>
</html>