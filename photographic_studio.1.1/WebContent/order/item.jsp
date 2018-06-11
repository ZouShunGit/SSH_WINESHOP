<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情页</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div align="center">
		<p>
			<strong style="font-size: 32px; color: #00F">订单详情</strong>
		</p>
		<table width="764" border="1" cellspacing="0" cellpadding="0"
			bordercolor="#DBDBDB">
			<tr>
				<td width="138"><strong>订单编号：</strong></td>
				<td width="191"><s:property value="model.oid" /></td>
				<td width="103"><strong>用户名：</strong></td>
				<td colspan="3"><s:property value="model.user.uname" /></td>
			</tr>
			<tr>
				<td>男嘉宾：</td>
				<td><s:property value="model.maleguests" /></td>
				<td>女嘉宾：</td>
				<td colspan="3"><s:property value="model.femaleguests" /></td>
			</tr>
			<tr>
				<td>拍照日期：</td>
				<td><s:property value="model.photodate" /></td>
				<td nowrap="nowrap">订单状态：</td>
				<td colspan="3"><s:if
						test="#session.existUser != null">
						<s:if test="model.ostate == 1">
							<a
								href="order/orderAction_editPage.action?oid=<s:property value="model.oid" />&dresser.eid=0">提交</a>
						</s:if>
						<s:if test="model.ostate == 2">未拍照</s:if>
						<s:if test="model.ostate == 3">
							<a href="photo/photoAction_select.action?oid=<s:property value="model.oid" />&pageBean.page=1">选片</a>
						</s:if>
						<s:if test="model.ostate == 4">已完成</s:if>
					</s:if> <s:if test="#session.existAdmin != null">
						<s:if test="model.ostate == 1">未提交</s:if>
						<s:if test="model.ostate == 2">
							<a
								href="photo/photoAction_addPage.action?oid=<s:property value="model.oid" />&photodate=<s:property value="model.photodate" />">结束拍照</a>
						</s:if>
						<s:if test="model.ostate == 3">未选片</s:if>
						<s:if test="model.ostate == 4">完成</s:if>
					</s:if>
			<tr>
				<td>摄影师:</td>
				<td><s:property value="model.photographer" /></td>
				<td>化妆师：</td>
				<td colspan="3"><s:property value="model.dresser" /></td>
			</tr>
			<tr>
				<td>联系电话：</td>
				<td><s:property value="model.otel" /></td>
				<td>联系地址：</td>
				<td colspan="3"><s:property value="model.oaddress" /></td>
			</tr>
			<tr>
				<td>生成时间：</td>
				<td><s:property value="model.creattime" /></td>
				<td>&nbsp;</td>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="6">&nbsp;</td>
			</tr>
			<tr>
				<td height="23"><div align="center">
						<strong>序号</strong>
					</div></td>
				<td><div align="center">
						<strong>套餐图片</strong>
					</div></td>
				<td><div align="center">
						<strong>套餐名称</strong>
					</div></td>
				<td width="103"><div align="center">
						<strong>套餐数量</strong>
					</div></td>
				<%-- <td width="103"><div align="center"><strong>小计</strong></div></td> --%>
				<td width="126"><div align="center">
						<strong>评论</strong>
					</div></td>
			</tr>
			<s:iterator value="list" var="list" status="id">
				<tr>
					<td height="20"><div align="center">${id.index +1}</div></td>
					<td><div align="center">
							<img width="60" alt="套餐图片"
								src="images/<s:property value="#list.set.setimg" />">
						</div></td>
					<td><div align="center">
							<s:property value="#list.set.setname" />
						</div></td>
					<td><div align="center">
							<s:property value="#list.setnum" />
						</div></td>
					<td><div align="center">
							<s:if test="#session.existUser != null">
								<form method="post" onsubmit="return checkfrom()">
									<textarea rows="2" id="comdesc" name="comdesc" cols="40"
										style="font-size: 16px"></textarea>
									<div align="right">
										<input type="submit" value="提交" class="login" />
									</div>
								</form>
							</s:if>
						</div></td>
				</tr>
			</s:iterator>

			<tr>
				<td height="24" colspan="6">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="6" nowrap="nowrap"><div align="right"
						style="color: red;">
						<strong>商品价格：￥<s:property value="total" />元
						</strong>
					</div></td>
			</tr>
			<tr>
				<td colspan="6">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="4"></td>
				<td colspan="2"><s:if test="model.ostate <= 2">
						<a
							href="order/orderAction_delete.action?oid=<s:property value="model.oid" />">删除订单</a>
					</s:if> <s:if test="model.ostate == 3">
						<a
							href="photo/photoAction_select.action?oid=<s:property value="model.oid" />&pageBean.page=1">选片库</a>

					</s:if></td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
		function checkfrom() {
			var i = document.getElementById("comdesc").value;
			alert(i);
			var xhr = new XMLHttpRequest();
			/* 确定请求地址和请求参数 */
			var url = "comment/comments_add.action?set.setid=<s:property value="#list.set.setid" />&user.id=<s:property value="#session.existUser.id" />&comdesc="
					+ i + "";

			/* 调用XMLHttpRequest对象的open()方法建立对服务器的调用 */
			xhr.open("post", url, true)
			//指定响应事件处理函数
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
				}
			}
			//向服务器发送请求
			xhr.send();
		}
	</script>
</body>
</html>