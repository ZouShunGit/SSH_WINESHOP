<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/register.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
<script src="js/jquery-1.8.3.js"></script>
	<script src="js/sinlar.js"></script>
</head>
<body oncontextmenu=self.event.returnValue=false>
	<div align="center">
		<div align="left">
			<form action="set/setAction_findAll.action?pageBean.page=1"
				method="post">
				<table border="0" cellspacing="5" cellpadding="0"
					style="margin-top: 0px">
					<tr>
						<td>套餐名称：</td>
						<td><input type="text" name="setname" /></td>
						<td><input type="submit" value="查询" class="login" /></td>
					</tr>
				</table>
			</form>
		</div>
		<s:if test="list == null">
		<div align="left" style="color: red;"><s:actionmessage /></div>
		</s:if>
		<s:if test="list != null">
		<div align="center">
			<strong style="font-size: 24px; color: #00F;">套餐列表</strong>
		</div>
			<div style="margin-left: 730px">
				<a href="set/setAction_addPage.action" class="login">添加</a>
			</div>
			<table width="860" border="1" bordercolor="blue" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="35" nowrap="nowrap"><div align="center">序号</div></td>
					<td width="68" nowrap="nowrap"><div align="center">套餐编号</div></td>
					<td width="98" nowrap="nowrap"><div align="center">图片</div></td>
					<td width="116" nowrap="nowrap"><div align="center">套餐名称</div></td>
					<td width="58" nowrap="nowrap"><div align="center">服装数</div></td>
					<td width="52" nowrap="nowrap"><div align="center">相片数</div></td>
					<td width="63" nowrap="nowrap"><div align="center">门面价</div></td>
					<td width="63" nowrap="nowrap"><div align="center">网上价</div></td>
					<td width="242" nowrap="nowrap"><div align="center">描述</div></td>
					<td width="39" nowrap="nowrap"><div align="center">操作</div></td>
				</tr>
				<s:iterator var="list" value="list" status="id">
					<tr>
						<td><div align="center">${id.index+1 }</div></td>
						<td><div align="center">
								<s:property value="#list.setid" />
							</div></td>
						<td><div align="center">
								<img class="data-img" src="images/<s:property value="#list.setimg" />" alt="套餐图片"
									width="98" height="98" />
							</div></td>
						<td><div align="center">
								<s:property value="#list.setname" />
							</div></td>
						<td><div align="center">
								<s:property value="#list.clothingnum" />
							</div></td>
						<td><div align="center">
								<s:property value="#list.imgnum" />
							</div></td>
						<td><div align="center">
								<s:property value="#list.facdeprice" />
							</div></td>
						<td><div align="center">
								<s:property value="#list.onlineprice" />
							</div></td>
						<td><div align="center">
								<textarea readonly="readonly"
									style="background-color: #DDF0FB; font-size: 18px" rows="5"
									cols="25"><s:property value="#list.setdesc" /></textarea>
							</div></td>
						<td><a
							href="set/setAction_editPage.action?setid=<s:property value="#list.setid" />">
								<img alt="编辑" src="images/i_edit.gif" />
						</a> <a
							href="set/setAction_delete.action?setid=<s:property value="#list.setid" />">
								<img alt="删除" src="images/i_del.gif" />
						</a></td>
					</tr>
				</s:iterator>

			</table>
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
						href="set/setAction_findAll.action?pageBean.page=1">首页</a>&nbsp;
		<a style="color: #000"
						href="set/setAction_findAll.action?pageBean.page=<s:property value="model.pageBean.page-1"/>">上一页</a>&nbsp;
		</s:if>

				<s:if test="model.pageBean.page != model.pageBean.totalPage">
					<a style="color: #000"
						href="set/setAction_findAll.action?pageBean.page=<s:property value="model.pageBean.page+1" />">下一页</a>&nbsp;
			<a style="color: #000"
						href="set/setAction_findAll.action?pageBean.page=<s:property value="model.pageBean.totalPage"/>">尾页</a>
				</s:if>
			</p>
			</div>
		</s:if>
	</div>
</body>
</html>