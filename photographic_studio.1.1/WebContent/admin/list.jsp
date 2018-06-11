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
</head>
<body>
	<div>
		<div>
			<form action="admin/adminAction_findAll.action?pageBean.page=1"
				method="post">
				<table border="0" cellspacing="5" cellpadding="0"
					style="margin-top: 0px">
					<tr>
						<td>管理员编号：</td>
						<td><input type="text" name="aid" /></td>
						<td>姓名：</td>
						<td><input type="text" name="aname" /></td>
						<td>管理员级别<select name="alevel">
								<option value=""></option>
								<option value="1">人事管理员</option>
								<option value="2">服装管理员</option>
						</select></td>
						<td><input type="reset" value="重置" class="login" /><input
							type="submit" value="查询" class="login" /></td>
					</tr>
				</table>
			</form>
			<p
				style="margin: 10px auto; font-size: 24px; font-weight: bolder; color: blue;"
				align="center">管理员列表</p>
			<p style="margin-top: 10px; margin-left: 900px">
				<a href="admin/adminAction_addPage.action" class="login">添加</a>
			</p>
		</div>
		<s:if test="list == null">
			<tr>
				<td style="color: red;"><s:actionmessage /></td>
			</tr>
		</s:if>
		<s:if test="list != null">
			<table border="1" bordercolor="#A9ADF8" cellpadding="0" cellspacing="0"
				align="center" style="margin: -10px auto;">
				<thead>
					<tr>
						<th width="6%">序号</th>
						<th width="10%">管理员编号</th>
						<th width="16%">姓名</th>
						<th width="20%">联系电话</th>
						<th width="20%">邮箱</th>
						<th width="16%">管理员级别</th>
						<th width="8%">操作</th>
					</tr>
				</thead>
				<tbody align="center">
					<s:iterator var="list" value="list" status="id" step="1">
						<tr>
							<td>${id.index+1 }</td>
							<td><s:property value="#list.aid" /></td>
							<td><s:property value="#list.aname" /></td>
							<td><s:property value="#list.atel" /></td>
							<td><s:property value="#list.aemail" /></td>
							<td><s:if test="#list.alevel == 3">超级管理员</s:if><s:if test="#list.alevel == 1">人事管理员</s:if> <s:if
									test="#list.alevel == 2">物资管理员</s:if></td>
							<td><a
								href="admin/adminAction_editPage.action?aid=<s:property value="#list.aid" />&pageBean.page=1">
									<img alt="编辑" src="images/i_edit.gif" />
							</a> <s:if test="#list.alevel!= 3">
									<a
										href="admin/adminAction_delete.action?aid=<s:property value="#list.aid" />">
										<img alt="删除" src="images/i_del.gif" />
									</a>
								</s:if></td>
						</tr>
					</s:iterator>

				</tbody>
			</table>

			<p align="center">
				每页显示：
				<s:property value="pages.pageBean.rows" />
				/
				<s:property value="pages.pageBean.listnum" />
				条记录！当前页：
				<s:property value="pages.pageBean.page" />
				/
				<s:property value="pages.pageBean.totalPage" />
				页！
				<s:if test="pages.pageBean.page != 1">
					<a style="color: #000"
						href="admin/adminAction_findAll.action?pageBean.page=1&sampleCategory.scid=<s:property value="model.sampleCategory.scid"/>">首页</a>&nbsp;
		<a style="color: #000"
						href="admin/adminAction_findAll.action?pageBean.page=<s:property value="pages.pageBean.page-1"/>&sampleCategory.scid=<s:property value="model.sampleCategory.scid"/>">上一页</a>&nbsp;
		</s:if>

				<s:if test="pages.pageBean.page != pages.pageBean.totalPage">
					<a style="color: #000"
						href="admin/adminAction_findAll.action?pageBean.page=<s:property value="pages.pageBean.page+1" />&sampleCategory.scid=<s:property value="model.sampleCategory.scid"/>">下一页</a>&nbsp;
			<a style="color: #000"
						href="admin/adminAction_findAll.action?pageBean.page=<s:property value="pages.pageBean.totalPage"/>&sampleCategory.scid=<s:property value="model.sampleCategory.scid"/>">尾页</a>
				</s:if>
			</p>
		</s:if>
	</div>
</body>
</html>