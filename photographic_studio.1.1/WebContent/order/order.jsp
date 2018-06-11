<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/register.css" rel="stylesheet" type="text/css" />
<link href="css/public.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>

</head>
<body>
	<div>
		<form
			action="order/orderAction_findAll.action?pageBean.page=1&user.id=<s:property value="model.user.id"/>"
			method="post">
			状态选择： <select name="ostate">
				<option value="0">全部</option>
				<option value="1">未付款</option>
				<option value="2">未拍摄</option>
				<option value="3">已拍摄</option>
				<option value="4">完成</option>
			</select>
			<s:submit name="确认" value="确认" class="login"></s:submit>
		</form>
	</div>
	<s:if test="list == null">
		<p style="color: red">
			<s:actionmessage />
		</p>
	</s:if>
	<s:if test="list != null">
		<div align="center">
			<p align="center">
				<strong style="font-size: 34px; color: #00F">订单列表</strong>
			</p>
			<table width="80%" bordercolor="#A9ADF8" border="1" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="156" nowrap="nowrap"><div align="center">订单编号</div></td>
					<td width="86" nowrap="nowrap"><div align="center">男嘉宾</div></td>
					<td width="86" nowrap="nowrap"><div align="center">女嘉宾</div></td>
					<td width="115" nowrap="nowrap"><div align="center">联系电话</div></td>
					<td width="115" nowrap="nowrap"><div align="center">拍照日期</div></td>
					<td width="114" nowrap="nowrap"><div align="center">总计</div></td>
					<td width="57" nowrap="nowrap"><div align="center">状态</div></td>

					<td width="86" nowrap="nowrap"><div align="center">摄影师</div></td>
					<td width="97" nowrap="nowrap"><div align="center">化妆师</div></td>
				</tr>
				<s:iterator value="list" var="list">
					<tr>
						<td nowrap="nowrap"><div align="center">
								<a
									href="order/orderAction_item.action?oid=<s:property value="#list.oid" />"><s:property
										value="#list.oid" /></a>
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.maleguests" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.femaleguests" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.otel" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.photodate" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.realprice" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:if test="#session.existUser != null">
									<s:if test="#list.ostate == 1">
										<a
											href="order/orderAction_editPage.action?oid=<s:property value="#list.oid" />&dresser.eid=0">提交</a>
									</s:if>
									<s:if test="#list.ostate == 2">未拍照</s:if>
									<s:if test="#list.ostate == 3">
										<a
											href="photo/photoAction_select.action?oid=<s:property value="#list.oid" />&pageBean.page=1">选片</a>
									</s:if>
									<s:if test="#list.ostate == 4">已完成</s:if>
								</s:if>
								<s:if test="#session.existAdmin != null">
									<s:if test="#list.ostate == 1">未提交</s:if>
									<s:if test="#list.ostate == 2">
										<a
											href="photo/photoAction_addPage.action?oid=<s:property value="#list.oid" />&photodate=<s:property value="#list.photodate" />">结束拍照</a>
									</s:if>
									<s:if test="#list.ostate == 3">未选片</s:if>
									<s:if test="#list.ostate == 4">完成</s:if>
								</s:if>
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.photographer" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.dresser" />
							</div></td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<div class="digg" style="margin-top: 20px">
		<p align="center">
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
					href="order/orderAction_findAll.action?ostate=<s:property value="model.ostate"/>&pageBean.page=1&ostate=<s:property value="model.ostate"/>&user.id=<s:property value="model.user.id"/>">首页</a>&nbsp;
		<a style="color: #000"
					href="order/orderAction_findAll.action?ostate=<s:property value="model.ostate"/>&pageBean.page=<s:property value="model.pageBean.page-1"/>&ostate=<s:property value="model.ostate"/>&user.id=<s:property value="model.user.id"/>">上一页</a>&nbsp;
		</s:if>

			<s:if test="model.pageBean.page != model.pageBean.totalPage">
				<a style="color: #000"
					href="order/orderAction_findAll.action?ostate=<s:property value="model.ostate"/>&pageBean.page=<s:property value="model.pageBean.page+1" />&ostate=<s:property value="model.ostate"/>&user.id=<s:property value="model.user.id"/>">下一页</a>&nbsp;
			<a style="color: #000"
					href="order/orderAction_findAll.action?ostate=<s:property value="model.ostate"/>&pageBean.page=<s:property value="model.pageBean.totalPage"/>&ostate=<s:property value="model.ostate"/>&user.id=<s:property value="model.user.id"/>">尾页</a>
			</s:if>
		</p>
		</div>
	</s:if>
</body>
</html>