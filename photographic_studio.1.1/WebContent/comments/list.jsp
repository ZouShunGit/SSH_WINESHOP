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
</head>
<body>
	<div align="center">
		<div align="center">
			<h1 style="color: #00F">评论列表</h1>
		</div>
		<table width="869" border="1" cellspacing="0" cellpadding="0"
			bordercolor="#DBDBDB">
			<tr bgcolor="#FFFFFF">
				<th width="87" nowrap="nowrap" scope="col">序号</th>
				<th width="68" nowrap="nowrap" scope="col">评论编号</th>
				<th width="507" nowrap="nowrap" scope="col">评论内容</th>
				<th width="51" nowrap="nowrap" scope="col">用户名</th>
				<th width="92" nowrap="nowrap" scope="col">套餐名称</th>
				<th width="50" nowrap="nowrap" scope="col">操作</th>
			</tr>
			<s:iterator var="list" value="list" status="id" step="1">
				<c:if test="${id.index % 2 == 0 }">
					<tr bgcolor="#A7FECE">
						<td nowrap="nowrap"><div align="center">${id.index+1}</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.comid" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<textarea cols="70" rows="4" readonly="readonly"><s:property
										value="#list.comdesc" /></textarea>
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.user.uname" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.set.setname" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<a
									href="comment/comments_delete.action?comid=<s:property value="list.comid"/>"><img
									alt="删除" src="images/i_del.gif"></a>
							</div></td>
					</tr>
				</c:if>
				<c:if test="${id.index %2 != 0 }">
					<tr>
						<td nowrap="nowrap"><div align="center">${id.index+1}</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.comid" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<textarea cols="70" rows="4" readonly="readonly"><s:property
										value="#list.comdesc" /></textarea>
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.user.uname" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.set.setname" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<a
									href="comment/comments_delete.action?comid=<s:property value="#list.comid"/>"><img
									alt="删除" src="images/i_del.gif"></a>
							</div></td>
					</tr>
				</c:if>
			</s:iterator>
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
					href="comment/comments_findAll.action?pageBean.page=1">首页</a>&nbsp;
		<a style="color: #000"
					href="comment/comments_findAll.action?pageBean.page=<s:property value="pages.pageBean.page-1"/>">上一页</a>&nbsp;
		</s:if>

			<s:if test="pages.pageBean.page != pages.pageBean.totalPage">
				<a style="color: #000"
					href="comment/comments_findAll.action?pageBean.page=<s:property value="pages.pageBean.page+1" />">下一页</a>&nbsp;
			<a style="color: #000"
					href="comment/comments_findAll.action?pageBean.page=<s:property value="pages.pageBean.totalPage"/>">尾页</a>
			</s:if>
		</p>
	</div>
</body>
</html>