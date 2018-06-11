<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link href="css/dtree.css" rel="stylesheet" type="text/css">
<script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
</head>

</head>

<body>
<div align="center" style="width: 98%;margin: 0 auto;" >
<ul id="MenuBar1" class="MenuBarHorizontal" style="margin-left: 200px">
	<li><a class="MenuBarItemSubmenu" href="user/userAction_findUserInfo.action?uemail=<s:property value="#{session.existUser.uemail}"/>" target="mainFrame">个人信息</a>
		<ul>
			<li><a href="user/userAction_editInfoPage.action" target="mainFrame">信息修改</a></li>
			<li><a href="user/oldpass.jsp" target="mainFrame">更改密码</a></li>
		</ul>
	</li>
	<li><a href="car/carAction_findAll.action" target="mainFrame">购物车</a></li>
	<li><a href="order/orderAction_findAll.action?pageBean.page=1&user.id=<s:property value="#session.existUser.id"/>&ostate=0" target="mainFrame">我的订单</a>
	</li>
	<li><a href="user/userAction_quit.action" target="_top">安全退出</a></li>
</ul>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
</script>
<div><iframe src="user/userAction_findUserInfo.action?uemail=<s:property value="#{session.existUser.uemail}"/>" frameborder="0" width="98%" height="700px" align="middle" style="margin-top:20px" name=mainFrame></iframe></div>
</div>
</body>

</html>