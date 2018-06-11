<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码找回</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="main" style="margin: 60px auto">
		<form action="user/userAction_findPass.action" method="post"
			>
			<table align="center" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right"
						style="color: #000; font-size: 18px; line-height: 50px;">&nbsp;</td>
					<td style="color: #000; font-size: 16px;"><center
							style="color: red; font-weight: bold;">
							<s:actionerror />
						</center></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 18px; line-height: 50px;">邮箱账号：</td>
					<td style="color: #000; font-size: 16px;"><input type="text"
						id="email" name="uemail" onblur="checkEmail()" class="yanse"><span
						id="email_init"></span></td>
				</tr>
				<tr>
					<td align="right"
						style="color: #000; font-size: 18px; line-height: 50px;">确认邮箱账号：</td>
					<td style="color: #000; font-size: 16px;"><input type="text"
						id="email1" name="uemail1" onblur="checkEmailA()" class="yanse"><span
						id="email1_init"></span></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td style="color: #000; font-size: 16px;"><center>
							<input type="submit" value="密码找回" class="login">&nbsp;&nbsp;<input
								type="reset" value="重置" class="login">
						</center></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>