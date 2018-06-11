<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/photo.css" rel="stylesheet" type="text/css" />
<link href="css/public.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.se1 {
	background: #e8e6eb;
	font-weight: bold;
	color: #167eff;
}

.se2 a {
	background: #167eff;
	color: #fff;
	padding: 2px;
}
</style>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.Xslider.js"></script>
<script src="js/jquery-1.8.3.js"></script>
<script src="js/sinlar.js"></script>
</head>
<body oncontextmenu=self.event.returnValue=false>
	<div class="mian">
		<div class="matter2">
			<div class="choose">
				<div class="select2">
					<ul>
						<li class="se2"><a
							href="sample/sampleAction_index.action?pageBean.page=1"><strong
								style="color: #fff;">全部：</strong></a></li>
						<s:iterator value="#session.categories" var="c">
							<li><a target="myFrame"
								href="sample/sampleAction_index.action?sampleCategory.scid=<s:property value="#c.scid"/>&pageBean.page=1"><s:property
										value="#c.scname" /></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="content">
				<s:iterator value="samples" var="sa">
					<div class="prod">
						<div class="tip">
							<img width="205" height="125" class="data-img"
								src="images/<s:property value="#sa.img"/>">
						</div>
						<div class="scrt">
							<div class="zt">
								<s:property value="#sa.sname" />
							</div>
							<div class="rq">
								<s:property value="#sa.creattime" />
							</div>
						</div>
					</div>
				</s:iterator>
			</div>
			<p>&nbsp;</p>
			<div class="digg">
				<p align="center" style="">
					每页显示：
					<s:property value="model.pageBean.rows" />
					/
					<s:property value="model.pageBean.listnum" />
					条记录！当前页：
					<s:property value="model.pageBean.page" />
					/
					<s:property value="model.pageBean.totalPage" />
					页！
					<s:if test="model.pageBean.page != 1">
						<a style="color: #000"
							href="sample/sampleAction_index.action?sampleCategory.scid=<s:property value="model.sampleCategory.scid"/>&pageBean.page=1">首页</a>&nbsp;
		<a style="color: #000"
							href="sample/sampleAction_index.action?sampleCategory.scid=<s:property value="model.sampleCategory.scid"/>&pageBean.page=<s:property value="model.pageBean.page-1"/>">上一页</a>&nbsp;
		</s:if>
					<s:if test="model.pageBean.page != model.pageBean.totalPage">
						<a style="color: #000"
							href="sample/sampleAction_index.action?sampleCategory.scid=<s:property value="model.sampleCategory.scid"/>&pageBean.page=<s:property value="model.pageBean.page+1" />">下一页</a>&nbsp;
			<a style="color: #000"
							href="sample/sampleAction_index.action?sampleCategory.scid=<s:property value="model.sampleCategory.scid"/>&pageBean.page=<s:property value="model.pageBean.totalPage"/>">尾页</a>
					</s:if>
				</p>
			</div>
		</div>
	</div>
</body>
</html>