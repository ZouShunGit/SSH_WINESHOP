<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/public.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<title>头部</title>
</head>
<body>
	<div class="wrap_top">
		<div class="top">
			<div class="logo">
				<a href="#"><img src="images/logo.jpg" width="200" height="74" /></a>
			</div>
			<div id="navMenu">
				<UL class="menu1">
					<li class="onelink"><a href="index.jsp">网站首页</a></li>
					<li class="navthis1"><a  href="sample/sampleAction_index.action?pageBean.page=1" rel='dropmenu1'
						target="myFrame">作品欣赏</a>
						<ul>
							<s:iterator value="#session.categories" var="c">
							<li><a target="myFrame" href="sample/sampleAction_index.action?sampleCategory.scid=<s:property value="#c.scid"/>&pageBean.page=1"><s:property value="#c.scname"/></a></li>
							</s:iterator>
						</ul></li>
					<!-- <li class="navthis22"><a href="customers.html">每日客照</a></li> -->
					<li class="navthis8"><a href="activity.jsp" rel='dropmenu8'
						target="myFrame">最近活动</a></li>
					<s:if test="#session.existUser == null">
						<li class="navthis27"><a href="user/userlogin.jsp"
							rel='dropmenu8' target="myFrame">登录/注册</a></li>
					</s:if>
					<s:if test="#session.existUser != null">
						<li class="navthis1"><a href="user/userInfo.jsp"
							target="myFrame" rel='dropmenu8'>个人中心</a>
							<ul>
								<li><a href="user/userAction_quit.action" target="_top">退出</a></li>
							</ul></li>
					</s:if>
					<li class="navthis1"><a
						href="set/setAction_index.action?pageBean.page=1" rel='dropmenu1'
						target="myFrame">套餐系列</a></li>
				<!-- 	<li class="navthis9"><a href="news.jsp" rel='dropmenu9'
						target="myFrame">新闻动态</a></li> -->
					<li class="navthis1"><a
						href="emp/empAction_index.action?employeeLevel.elid=0&pageBean.page=1"
						rel='dropmenu1' target="myFrame">员工介绍</a>
						<ul>
							<li><a
								href="emp/empAction_index.action?employeeLevel.elid=1&pageBean.page=1"
								target="myFrame">摄影师</a></li>
							<li><a
								href="emp/empAction_index.action?employeeLevel.elid=2&pageBean.page=1"
								target="myFrame">化妆师</a></li>
						</ul></li>
					<li class="navthis24"><a href="clothing/clothing_item.action?pageBean.page=1" target="myFrame">服装宝库</a></li>
					<li class="navthis25"><a href="contact.jsp" target="myFrame">联系我们</a></li>
					<!-- <li class="navthis24"><a href="message.jsp" target="myFrame">留言板</a></li> -->
				</ul>
			</div>
		</div>
	</div>
</body>
</html>