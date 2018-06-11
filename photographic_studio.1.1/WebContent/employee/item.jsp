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
			<div class="content">
				<s:iterator value="emp" var="list">
					<div class="prod">
						<div class="tip">
							<img class="data-img"
								src="images/<s:property value="#list.eimg"/>" width="200px"
								height="200px">
						</div>
						<div class="scrt">
							<div class="zt">
								<s:property value="#list.ename" />
							</div>
							<div class="rq">
								<s:property value="#list.ecreattime" />
							</div>
						</div>
					</div>
				</s:iterator>
				<p>&nbsp;</p>
			</div>
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
							href="emp/empAction_index.action?employeeLevel.elid=<s:property value="model.employeeLevel.elid"/>&pageBean.page=1">首页</a>&nbsp;
		<a style="color: #000"
							href="emp/empAction_index.action?employeeLevel.elid=<s:property value="model.employeeLevel.elid"/>&pageBean.page=<s:property value="model.pageBean.page-1"/>">上一页</a>&nbsp;
		</s:if>

					<s:if test="model.pageBean.page != model.pageBean.totalPage">
						<a style="color: #000"
							href="emp/empAction_index.action?employeeLevel.elid=<s:property value="model.employeeLevel.elid"/>&pageBean.page=<s:property value="model.pageBean.page+1" />">下一页</a>&nbsp;
			<a style="color: #000"
							href="emp/empAction_index.action?employeeLevel.elid=<s:property value="model.employeeLevel.elid"/>&pageBean.page=<s:property value="model.pageBean.totalPage"/>">尾页</a>
					</s:if>
				</p>
			</div>
		</div>
	</div>
</body>
</html>