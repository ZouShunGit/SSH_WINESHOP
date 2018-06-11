<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<body>
	<div>
		<table width="850px" border="0" cellspacing="0">
			<tr>
				<td style="padding: 30px; text-align: center"><table
						width="60%" border="0" cellspacing="0" style="margin-top: 70px">
						<tr>
							<td style="width: 98"><img
								src="images/IconTexto_WebDev_009.jpg" width="128" height="128" /></td>
							<td style="padding-top: 30px"><font
								style="font-weight: bold; color: #FF0000"> <s:actionmessage />
									<s:actionerror />
							</font> <br /> <br /> <a href="index.jsp"  target="_top">首页</a> <s:if
									test="#session.existUser == null">
									<a href="user/userlogin.jsp" target="_parent">登录/注册</a>
								</s:if> <s:if test="#session.existUser != null">
									<a href="user/userAction_quit.action" target="_top">退出</a>
								</s:if></td>
						</tr>
					</table>
					<h1>&nbsp;</h1></td>
			</tr>
		</table>
	</div>
</body>
</html>