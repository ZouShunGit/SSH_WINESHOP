<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/public.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.find {
	background-color: #F4F4F4;
	text-align: left;
	height: 30px;
	width: 240px;
	border: medium solid #39F;
	font-size: 24px;
}

.find2 {
	background-color: #39F;
	color: #FFF;
	height: 38px;
	width: 65px;
	border: medium solid #39F;
	margin-left: 0;
	font-size: 24px;
	font-weight: bold;
}
</style>
<title>前台页面显示</title>
</head>
<body oncontextmenu=self.event.returnValue=false>
	<div align="center">
		<div align="left" style="margin-left: 180px; margin-top: 20px">
			<form action="set/setAction_index.action?pageBean.page=1"
				method="post" enctype="application/x-www-form-urlencoded"
				id="setname">
				<table width="764" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="248"><input name="setname" type="text"
							class="find" value="请输入套系名称" /></td>
						<td width="516"><input type="submit" name="button"
							id="button" width="50px" class="find2" value="查询" /></td>
					</tr>
				</table>
			</form>
		</div>
		<s:if test="list==null">
			<span style="font-size: 20px; color: red"><s:actionmessage /></span>
		</s:if>
		<s:if test="list!=null">

			<table width="900" style="margin-top: 20px" border="0"
				cellspacing="0" cellpadding="0">
				<s:iterator value="list" var="list">
					<tbody style="background-color: #E3FFFF; padding: 10px">
						<tr>
							<td width="100" rowspan="4" nowrap="nowrap"><a
								href="comment/comments_index.action?set.setid=<s:property
							value="#list.setid" />&pageBean.page=1"><img
									class="data-img"
									src="images/<s:property value="#list.setimg" />" width="100"
									height="100" /></a></td>
							<td nowrap="nowrap">套餐名称：</td>
							<td colspan="3" width="314" nowrap="nowrap"><div
									align="left">
									<s:property value="#list.setname" />
								</div></td>
						</tr>
						<tr>
							<td width="72" nowrap="nowrap">服&nbsp;&nbsp;装&nbsp;&nbsp;数：</td>
							<td width="133" nowrap="nowrap"><s:property
									value="#list.clothingnum" /></td>
							<td width="72" nowrap="nowrap">相&nbsp;&nbsp;片&nbsp;&nbsp;数：</td>
							<td nowrap="nowrap"><s:property value="#list.imgnum" /></td>
						</tr>
						<tr>
							<td nowrap="nowrap">门&nbsp;&nbsp;面&nbsp;&nbsp;价：</td>
							<td nowrap="nowrap">￥<s:property value="#list.facdeprice" /></td>
							<td nowrap="nowrap">网&nbsp;&nbsp;上&nbsp;&nbsp;价：</td>
							<td nowrap="nowrap" style="color: red; font-size: 20px">￥<s:property
									value="#list.onlineprice" />.00
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</td>
							<td colspan="3" nowrap="nowrap"><textarea rows="2"
									style="background-color: #E3FFFF;; font-size: 18px; border-color: #00E8E8;"
									readonly="readonly" cols="70"><s:property
										value="#list.setdesc" /></textarea></td>
						</tr>
						<tr>
							<td nowrap="nowrap">&nbsp;</td>
							<td colspan="4" nowrap="nowrap"><div align="right">
									<a
										href="car/carAction_add.action?set.setid=<s:property value="#list.setid" />&set.onlineprice=<s:property value="#list.onlineprice" />">添加到购物车</a>
								</div></td>
						</tr>
					</tbody>
					<tr>
						<td>&nbsp;</td>
					</tr>
				</s:iterator>
			</table>
			<div class="digg" style="margin-top: 20px">
				<p>
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
							href="set/setAction_index.action?pageBean.page=1">首页</a>&nbsp;
		<a style="color: #000"
							href="set/setAction_index.action?pageBean.page=<s:property value="pages.pageBean.page-1"/>">上一页</a>&nbsp;
		</s:if>

					<s:if test="pages.pageBean.page != pages.pageBean.totalPage">
						<a style="color: #000"
							href="set/setAction_index.action?pageBean.page=<s:property value="pages.pageBean.page+1" />">下一页</a>&nbsp;
			<a style="color: #000"
							href="set/setAction_index.action?pageBean.page=<s:property value="pages.pageBean.totalPage"/>">尾页</a>
					</s:if>
					
				</p>
			</div>
		</s:if>
	</div>
</body>
</html>