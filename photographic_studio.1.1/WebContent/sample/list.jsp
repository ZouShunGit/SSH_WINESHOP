<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>样片列表</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.8.3.js"></script>
	<script src="js/sinlar.js"></script>
</head>
<body oncontextmenu=self.event.returnValue=false>
	<div>
		<form action="sample/sampleAction_findAll.action?pageBean.page=1"
			method="post">
			类别名称： <select
				name="sampleCategory.scid" id="sampleCategory.scid">
				<option value="0"></option>
				<s:iterator value="categories" var="cate">
				<option value="<s:property value="#cate.scid"/>"><s:property value="#cate.scname"/></option>
				</s:iterator>
			</select> <input type="reset" value="重置" class="login" /><input class="login"
				type="submit" value="查询" />
		</form>
		<s:if test="list == null">
			<div align="left" style="color: red;">
				<s:actionmessage />
			</div>
		</s:if>
		<s:if test="list != null">
			<p align="center" style="font-size: 28px; color: #00F">
				<strong>样片列表</strong>
			</p>
			<div style="margin-left: 840px">
				<a href="sample/sampleAction_addPage.action">添加</a>
			</div>
			<div align="center">
				<table width="721" border="1" cellspacing="0" cellpadding="0"
					bordercolor="#A9ADF8">
					<tr>
						<td width="44"><div align="center">序号</div></td>
						<td width="64"><div align="center">编号</div></td>
						<td width="154"><div align="center">名称</div></td>
						<td width="100"><div align="center">图片</div></td>
						<td width="150"><div align="center">类别</div></td>
						<td width="195"><div align="center">操作</div></td>
					</tr>
					<s:iterator value="list" var="list" status="id" step="1">
						<tr>
						<td height="95"><div align="center">${id.index+1}</div></td>
						<td><div align="center">
								<s:property value="#list.said" />
							</div></td>
						<td><div align="center">
								<s:property value="#list.sname" />
							</div></td>
						<td><div align="center"><img class="data-img" alt="图片" width="100px" src="images/<s:property value="#list.img" />">
								
							</div></td>
						<td><div align="center">
								<s:property value="#list.sampleCategory.scname" />
							</div></td>
						<td><div align="center">
								<a
									href="sample/sampleAction_editPage.action?said=<s:property value="#list.said" />">
									<img alt="编辑" src="images/i_edit.gif" />
								</a> <a
									href="sample/sampleAction_delete.action?said=<s:property value="#list.said" />">
									<img alt="删除" src="images/i_del.gif" />
								</a>
							</div></td>
						</tr>
					</s:iterator>
				</table>
			</div>
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
						href="sample/sampleAction_findAll.action?sampleCategory.scid=<s:property value="model.sampleCategory.scid"/>&pageBean.page=1">首页</a>&nbsp;
		<a style="color: #000"
						href="sample/sampleAction_findAll.action?sampleCategory.scid=<s:property value="model.sampleCategory.scid"/>&pageBean.page=<s:property value="pages.pageBean.page-1"/>">上一页</a>&nbsp;
		</s:if>

				<s:if test="pages.pageBean.page != pages.pageBean.totalPage">
					<a style="color: #000"
						href="sample/sampleAction_findAll.action?sampleCategory.scid=<s:property value="model.sampleCategory.scid"/>&pageBean.page=<s:property value="pages.pageBean.page+1" />">下一页</a>&nbsp;
			<a style="color: #000"
						href="sample/sampleAction_findAll.action?sampleCategory.scid=<s:property value="model.sampleCategory.scid"/>&pageBean.page=<s:property value="pages.pageBean.totalPage"/>">尾页</a>
				</s:if>
			</p>
		</s:if>
	</div>

</body>
</html>
