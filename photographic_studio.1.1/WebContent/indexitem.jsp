<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/public.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.8.3.js"></script>
	<script src="js/sinlar.js"></script>
</head>

<body oncontextmenu=self.event.returnValue=false>
	<div align="center">
		<img alt="图片" src="images/banner.jpg" width="100%">
	</div>
	<div style="width: 80%; margin: 0 auto;">
		<div class="matter2">
			<p style="background-color: #EEE; color: #00F; font-size: 24px">
				特色内景
			</p>
			<div class="content">
				<div class="left">
					<div class="tp1">
						<img src="tp/2.jpg" class="data-img" />
					</div>
					<div class="biaoti">
						<strong>拍摄主题：新年吉祥</strong><br /> 拍摄时间：2013-5-15
					</div>
				</div>
				<div class="right">
				<s:iterator value="#session.samples" var="s" begin="0" step="1" end="5">
					<div class="prod">
						<div class="tip">
							<img class="data-img" src="images/<s:property value="#s.img"/>" width="205" height="125"/>
						</div>
						<div class="scrt">
							<a href="#"><s:property value="#s.sname"/></a>
						</div>
					</div>
				</s:iterator>
				</div>
			</div>
		</div>
	</div>
</body>
</html>