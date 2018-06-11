<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在先选片库</title>
<script src="js/jquery-1.8.3.js"></script>
<script src="js/sinlar.js"></script>
</head>
<body oncontextmenu=self.event.returnValue=false>
	<div align="left">
		<form action="photo/photoAction_findAll.action?pageBean.page=1"
			method="post">
			<table width="461" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<th width="85" nowrap="nowrap" scope="col"><div align="center">订单编号：</div></th>
					<th width="168" nowrap="nowrap" scope="col"><div
							align="center">
							<input type="text" name="oid" id="oid" />
						</div></th>
					<th width="92" nowrap="nowrap" scope="col"><div align="center">是否已选：</div></th>
					<th width="68" nowrap="nowrap" scope="col"><div align="center">
							<select name="sign" id="sign"><option value="1">未选</option>
								<option value="2">已选</option>
								<option selected="selected" value="0">全部</option>
							</select>
						</div></th>
					<th width="339" nowrap="nowrap" scope="col">
						<div align="left">
							<input type="submit" name="button" id="button" value="查询" />
						</div>
					</th>
				</tr>
			</table>

		</form>
	</div>
	<s:if test="list == null">
		<h2 align="left" style="color: red;">
			<s:actionmessage />
		</h2>
	</s:if>
	<s:if test="list != null">
		<div align="center">
			<h2 align="center" style="color: #00F">在先选片库</h2>
			<table width="764" border="1" cellspacing="0" cellpadding="0"
				bordercolor="#EEEEEE">
				<tr>
					<th width="68" nowrap="nowrap" scope="col"><div align="center">序号</div></th>
					<th width="161" nowrap="nowrap" scope="col"><div
							align="center">相片编号</div></th>
					<th width="100" nowrap="nowrap" scope="col"><div
							align="center">图片</div></th>
					<th width="117" nowrap="nowrap" scope="col"><div
							align="center">选取标志</div></th>
					<th width="225" nowrap="nowrap" scope="col"><div
							align="center">订单编号</div></th>
					<th width="79" nowrap="nowrap" scope="col">操作
						<div align="center"></div>
					</th>
				</tr>

				<s:iterator var="list" value="list" status="id" step="1">
					<c:if test="${id.index % 2 == 0 }">
						<tr bgcolor="#BDFFFF">
							<td nowrap="nowrap"><div align="center">${id.index +1 }</div></td>
							<td nowrap="nowrap"><div align="center">
									<s:property value="#list.pid" />
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<img class="data-img" src="images/<s:property value="#list.pimg" />" width="100"
										height="63" alt="选片图片" />
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<s:if test="#list.sign == 2">已选</s:if>
									<s:if test="#list.sign == 1">未选</s:if>
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<s:property value="#list.oid" />
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<a
										href="photo/photoAction_delete.action?pid=<s:property value="#list.pid"/>"><img
										alt="删除" src="images/i_del.gif"></a>
								</div></td>
						</tr>
					</c:if>

					<c:if test="${id.index %2 != 0 }">
						<tr>
							<td nowrap="nowrap"><div align="center">${id.index +1 }</div></td>
							<td nowrap="nowrap"><div align="center">
									<s:property value="#list.pid" />
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<img src="images/<s:property value="#list.pimg" />" width="100"
										height="63" alt="选片图片" />
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<s:if test="#list.sign == 2">已选</s:if>
									<s:if test="#list.sign == 1">未选</s:if>
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<s:property value="#list.oid" />
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<a
										href="photo/photoAction_delete.action?pid=<s:property value="#list.pid"/>"><img
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
						href="photo/photoAction_findAll.action?pageBean.page=1">首页</a>&nbsp;
		<a style="color: #000"
						href="photo/photoAction_findAll.action?pageBean.page=<s:property value="pages.pageBean.page-1"/>">上一页</a>&nbsp;
		</s:if>

				<s:if test="pages.pageBean.page != pages.pageBean.totalPage">
					<a style="color: #000"
						href="photo/photoAction_findAll.action?pageBean.page=<s:property value="pages.pageBean.page+1" />">下一页</a>&nbsp;
			<a style="color: #000"
						href="photo/photoAction_findAll.action?pageBean.page=<s:property value="pages.pageBean.totalPage"/>">尾页</a>
				</s:if>
			</p>
		</div>
	</s:if>
</body>
</html>