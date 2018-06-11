<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>原密码确认</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="margin: 50px 200px">
		<form method="post" action="user/userAction_oldPass.action?uemail=<s:property value="#session.existUser.uemail"/>"
			onsubmit="return checkFrom();">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;"></td>
					<td><span style="color: red;"><s:actionerror /></span></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 16px; line-height: 30px;">请输入您的原密码<span
						style="color: red;">*</span>：
					</td>
					<td><input type="password" id="password" name="password"
						class="yanseA"> <span id="password_init"></span></td>
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
						type="submit" value="确认" class="login"></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		function checkFrom() {
			var password = document.getElementById("password").value;
			if (password == null || password == "") {
				alert("请输入原始密码！")
				return false;
			} else
				return true
		}
	</script>
</body>
</html>