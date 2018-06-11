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
<script src="js/jquery-1.8.3.js"></script>
<script src="js/sinlar.js"></script>
</head>
<body oncontextmenu=self.event.returnValue=false>
	<div>
		<form action="emp/empAction_findAll.action?pageBean.page=1"
			method="post">
			部门名称： <select name="department.did" id="department.did">
				<option value="0"></option>
				<s:iterator value="dept" var="cate">
					<option value="<s:property value="#cate.did"/>"><s:property
							value="#cate.dname" /></option>

				</s:iterator>
			</select>级别名称： <select name="employeeLevel.elid" id="employeeLevel.elid">
				<option value="0"></option>
				<s:iterator value="empl" var="cate">
					<option value="<s:property value="#cate.elid"/>"><s:property
							value="#cate.elname" /></option>

				</s:iterator>
			</select>员工名： <input type="text" name="ename" id="ename" /><input
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
					style="margin: 0px auto; font-size: 32px; font-weight: bolder; color: blue;"
					align="center">员工列表</p>
				<p style="margin-top: 0px; margin-left: 920px">
					<a href="emp/empAction_addPage.action" class="login">添加</a>
				</p>
			</div>
			<table border="1" bordercolor="blue" cellpadding="0" cellspacing="0"
				align="center" style="margin: 0px auto;" width="90%">
				<thead>
					<tr>
						<td align="center" width="5%">序号</td>
						<td align="center" width="10%">员工编号</td>
						<td align="center" width="13%">姓名</td>
						<td align="center" width="12%">图片</td>
						<td width="5%" align="center">性别</td>
						<td align="center" width="10%">部门</td>
						<td align="center" width="10%">职称</td>
						<td align="center" width="30%">描述</td>
						<td width="5%" align="center">操作</td>
					</tr>
				</thead>
				<tbody align="center">
					<s:iterator var="list" value="list" status="id" step="1">
						<tr>
							<td>${id.index+1 }</td>
							<td><s:property value="#list.eid" /></td>
							<td><s:property value="#list.ename" /></td>
							<td><img class="data-img" alt="员工图片" width="50px" height="50px"
								src="images/<s:property value="#list.eimg" />"></td>
							<td><s:property value="#list.esex" /></td>
							<td><s:property value="#list.department.dname" /></td>
							<td><s:property value="#list.employeeLevel.elname" /></td>
							<td><textarea rows="5" readonly="readonly" cols="45" style="font-size: 18px"><s:property
										value="#list.edesc" /></textarea></td>
							<td><a
								href="emp/empAction_editPage.action?eid=<s:property value="#list.eid" />">
									<img alt="删除" src="images/i_edit.gif" />
							</a> <a
								href="emp/empAction_delete.action?eid=<s:property value="#list.eid" />">
									<img alt="删除" src="images/i_del.gif" />
							</a></td>
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
						href="emp/empAction_findAll.action?pageBean.page=1">首页</a>&nbsp;
		<a style="color: #000"
						href="emp/empAction_findAll.action?pageBean.page=<s:property value="pages.pageBean.page-1"/>">上一页</a>&nbsp;
		</s:if>

				<s:if test="pages.pageBean.page != pages.pageBean.totalPage">
					<a style="color: #000"
						href="emp/empAction_findAll.action?pageBean.page=<s:property value="pages.pageBean.page+1" />">下一页</a>&nbsp;
			<a style="color: #000"
						href="emp/empAction_findAll.action?pageBean.page=<s:property value="pages.pageBean.totalPage"/>">尾页</a>
				</s:if>
			</p>
		</s:if>
	</div>
</body>
</html>