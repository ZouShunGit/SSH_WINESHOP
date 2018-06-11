<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.8.3.js"></script>
	<script src="js/sinlar.js"></script>
</head>
<body oncontextmenu=self.event.returnValue=false>
	<div>
		<form action="clothing/clothing_findAll.action?pageBean.page=1"
			method="post">
			二级类别名称： <select name="secondCategory.scid" id="secondCategory.scid">
				<option value="0"></option>
				<s:iterator value="categories" var="cate">
					<option value="<s:property value="#cate.scid"/>"><s:property
							value="#cate.name" /></option>
				</s:iterator>
			</select><input class="login"
				type="submit" value="查询" />
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
					align="center">服装列表</p>
				<p style="margin-top: 0px; margin-left: 860px">
					<a href="clothing/clothing_addPage.action" class="login" >添加</a>
				</p>

			</div>
			<table border="1" bordercolor="#A9ADF8"cellpadding="0" cellspacing="0"
				align="center" style="margin: 0px auto;" width="74%">
				<thead>
					<tr>
						<td align="center" width="5%">序号</td>
						<td align="center" width="10%">编号</td>
						<td align="center" width="13%">图片</td>
						<td align="center" width="10%">二级类别</td>
						<td width="10%" align="center">操作</td>
					</tr>
				</thead>
				<tbody align="center">

					<s:if test="list!=null">
						<s:iterator var="list" value="list" status="id" step="1">
								<tr>
							<td>${id.index+1 }</td>
							<td><s:property value="#list.cid" /></td>
							<td><img class="data-img" alt="服装图片" width="100px"
								src="images/<s:property value="#list.cimg" />"></td>
							<td><s:property value="#list.secondCategory.name" /></td>
							<td><a
								href="clothing/clothing_editPage.action?cid=<s:property value="#list.cid" />">
									<img alt="删除" src="images/i_edit.gif" />
							</a> <a
								href="clothing/clothing_delete.action?cid=<s:property value="#list.cid" />">
									<img alt="删除" src="images/i_del.gif" />
							</a></td>
							</tr>
						</s:iterator>
					</s:if>
				</tbody>
			</table>
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
						href="clothing/clothing_findAll.action?secondCategory.scid=<s:property value="model.secondCategory.scid"/>&pageBean.page=1">首页</a>&nbsp;
		<a style="color: #000"
						href="clothing/clothing_findAll.action?secondCategory.scid=<s:property value="model.secondCategory.scid"/>&pageBean.page=<s:property value="model.pageBean.page-1"/>">上一页</a>&nbsp;
		</s:if>

				<s:if test="model.pageBean.page != model.pageBean.totalPage">
					<a style="color: #000"
						href="clothing/clothing_findAll.action?secondCategory.scid=<s:property value="model.secondCategory.scid"/>&pageBean.page=<s:property value="model.pageBean.page+1" />">下一页</a>&nbsp;
			<a style="color: #000"
						href="clothing/clothing_findAll.action?secondCategory.scid=<s:property value="model.secondCategory.scid"/>&pageBean.page=<s:property value="model.pageBean.totalPage"/>">尾页</a>
				</s:if>
			</p>
		</s:if>
	</div>
</body>
</html>