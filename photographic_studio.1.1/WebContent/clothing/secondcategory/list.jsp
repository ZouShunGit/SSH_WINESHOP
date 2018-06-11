<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div>
		<form action="scategory/scategory_findAll.action?pageBean.page=1"
			method="post">
			二级类别名称： <input type="text" name="name" id="name"/>一级类别名称： <select
				name="category.cid" id="category.cid">
				<option value="0"></option>
				<s:iterator value="categories" var="cate">
					<option value="<s:property value="#cate.cid"/>"><s:property
							value="#cate.cname" /></option>
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
			<div>
			<p
					style="margin: 10px auto; font-size: 32px; font-weight: bolder; color: blue;"
					align="center">二级类别列表</p>
				<p style="margin-top: 0px; margin-left: 960px">
					<a href="scategory/scategory_addPage.action" class="login">添加</a>
				</p>
				
			</div>
			<table border="1"  bordercolor="#A9ADF8" cellpadding="0" cellspacing="0"
				align="center" style="margin: 0px auto;">
				<thead>
					<tr>
						<td align="center" width="7%">序号</td>
						<td align="center" width="9%">编号</td>
						<td align="center" width="18%">名称</td>
						<td align="center" width="12%">一级类别</td>
						<td align="center" width="48%">描述</td>
						<td width="7%" align="center">操作</td>
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


							<c:if test="${id.index % 2 != 0 }">
								<tr style="background-color: aqua;">
							</c:if>
							<c:if test="${id.index % 2 == 0 }">
								<tr>
							</c:if>
							<td><div align="center">${id.index+1 }</div></td>
							<td><div align="center">
									<s:property value="#list.scid" />
								</div></td>
							<td><div align="center">
									<s:property value="#list.name" />
								</div></td>
							<td><div align="center">
									<s:property value="#list.category.cname" />
								</div></td>
							<td><textarea rows="4" cols="50" readonly="readonly"
									style="font-size: 18px"><s:property
										value="#list.scdesc" /></textarea></td>
							<td><a
								href="scategory/scategory_editPage.action?scid=<s:property value="#list.scid" />">
									<img alt="删除" src="images/i_edit.gif" />
							</a> <a
								href="scategory/scategory_delete.action?scid=<s:property value="#list.scid" />">
									<img alt="删除" src="images/i_del.gif" />
							</a></td>
							</tr>
						</s:iterator>
					</s:if>
				</tbody>
			</table>
			<p align="center" style="margin-top：-50px">
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
						href="scategory/scategory_findAll.action?pageBean.page=1">首页</a>&nbsp;
		<a style="color: #000"
						href="scategory/scategory_findAll.action?pageBean.page=<s:property value="pages.pageBean.page-1"/>">上一页</a>&nbsp;
		</s:if>

				<s:if test="pages.pageBean.page != pages.pageBean.totalPage">
					<a style="color: #000"
						href="scategory/scategory_findAll.action?pageBean.page=<s:property value="pages.pageBean.page+1" />">下一页</a>&nbsp;
			<a style="color: #000"
						href="scategory/scategory_findAll.action?pageBean.page=<s:property value="pages.pageBean.totalPage"/>">尾页</a>
				</s:if>
			</p>
		</s:if>
	</div>
</body>
</html>