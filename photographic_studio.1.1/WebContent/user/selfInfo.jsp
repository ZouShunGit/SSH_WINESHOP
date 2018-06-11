<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="0" cellpadding="0" cellspacing="0"
		style="color: blue;">
		<thead>
			<tr>
				<th><center>您的个人信息如下</center></th>
			</tr>
		</thead>
		<tr>
			<td style="color: #000; font-size: 16px; line-height: 30px;"></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td style="color: #000; font-size: 16px; line-height: 30px;">编号：</td>
			<td><s:property value="model.id" /></td>
		</tr>
		<tr>
			<td style="color: #000; font-size: 16px; line-height: 30px;">邮箱账号：
			</td>
			<td><s:property value="model.uemail" /></td>
		</tr>
		<tr>
			<td style="color: #000; font-size: 16px; line-height: 30px;">手机号：</td>
			<td><s:property value="model.utel" /></td>
		</tr>
		<tr>
			<td style="color: #000; font-size: 16px; line-height: 30px;">姓名:</td>
			<td><s:property value="model.uname" /></td>
		</tr>
		<tr>
			<td style="color: #000; font-size: 16px; line-height: 30px;">性别：</td>
			<td><s:property value="model.usex" /></td>
		</tr>
		<tr>
			<td style="color: #000; font-size: 16px; line-height: 30px;">年龄：</td>
			<td><s:property value="model.uage" /></td>
		</tr>
		<tr>
			<td style="color: #000; font-size: 16px; line-height: 30px;">家庭住址：</td>
			<td><s:property value="model.uaddress" /></td>
		</tr>
	</table>
</body>
</html>