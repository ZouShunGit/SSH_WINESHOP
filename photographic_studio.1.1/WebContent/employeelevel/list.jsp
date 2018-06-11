<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div>
		<form action="empLevel/empLevelAction_findAll.action?pageBean.page=1"
			method="post">
			级别名称： <input type="text" name="elname" id="elname" /><input
				class="login" type="submit" value="查询" />
		</form>
		<s:if test="list == null">
			<div align="left" style="color: red;">
				<s:actionmessage />
			</div>
		</s:if>
		<s:if test="list != null">
			<div>
				<p
					style="margin: 0px auto; font-size: 24px; font-weight: bolder; color: blue;"
					align="center">员工级别信息</p>
				<p style="margin-top: 0px; margin-left: 830px">
					<a href="empLevel/empLevelAction_addPage.action" class="login">添加</a>
				</p>

			</div>
			<table border="1" bordercolor="#A9ADF8" cellpadding="0"
				cellspacing="0" align="center" style="margin: 0px auto;">
				<thead>
					<tr>
						<th width="6%">序号</th>
						<th width="10%">级别编号</th>
						<th width="16%">名称</th>
						<th width="60%">描述</th>
						<th width="8%">操作</th>
					</tr>
				</thead>
				<tbody align="center">
					<s:if test="list==null">
						<tr>
							<td style="color: red;"><s:actionmessage /></td>
						</tr>
					</s:if>
					<s:if test="list!=null">
						<s:iterator var="list" value="list" status="id" step="1">
							<tr>
								<td>${id.index+1 }</td>
								<td><s:property value="#list.elid" /></td>
								<td><s:property value="#list.elname" /></td>
								<td><textarea rows="3" cols="41" readonly="readonly" style="font-size: 18px"><s:property
											value="#list.eldesc" /></textarea></td>
								<td><a
									href="empLevel/empLevelAction_editPage.action?elid=<s:property value="#list.elid" />">
										<img alt="编辑" src="images/i_edit.gif" />
								</a> <a
									href="empLevel/empLevelAction_delete.action?elid=<s:property value="#list.elid" />">
										<img alt="删除" src="images/i_del.gif" />
								</a></td>
							</tr>
						</s:iterator>
					</s:if>
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
						href="empLevel/empLevelAction_findAll.action?pageBean.page=1">首页</a>&nbsp;
		<a style="color: #000"
						href="empLevel/empLevelAction_findAll.action?pageBean.page=<s:property value="pages.pageBean.page-1"/>">上一页</a>&nbsp;
		</s:if>

				<s:if test="pages.pageBean.page != pages.pageBean.totalPage">
					<a style="color: #000"
						href="empLevel/empLevelAction_findAll.action?pageBean.page=<s:property value="pages.pageBean.page+1" />">下一页</a>&nbsp;
			<a style="color: #000"
						href="empLevel/empLevelAction_findAll.action?pageBean.page=<s:property value="pages.pageBean.totalPage"/>">尾页</a>
				</s:if>
			</p>
		</s:if>
	</div>
</body>
</html>