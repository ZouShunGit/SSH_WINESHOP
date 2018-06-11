<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
.bottom {
	height: 30px;
	line-height: 30px;
	margin-bottom: 10px;
	text-align: right;
	overflow: hidden;
	border: 1px dotted #e4e4e4;
	background-color: #fdfdfd;
}

.submit {
	padding: 14px;
	color: #ffffff;
	background-color: #b31d04;
}
</style>
<script src="js/jquery-1.8.3.js"></script>
<script src="js/sinlar.js"></script>
</head>
<body oncontextmenu=self.event.returnValue=false>
	<div>
		<s:if test="#session.list ==null">
			<strong style="color: red"><s:actionmessage /></strong>
		</s:if>
		<s:if test="#session.list !=null">
			<div align="center">
				<strong style="font-size: 24px; color: #06F;">购物车信息</strong>
			</div>
			<br />
			<table width="764" bordercolor="#EDE4FE" border="1px" cellpadding="0"
				cellspacing="0" style="margin: 0 auto">
				<tr bgcolor="#F9F9F9">
					<td width="107" nowrap="nowrap"><div align="center">图片</div></td>
					<td width="225" nowrap="nowrap"><div align="center">套餐名称</div></td>
					<td width="159" nowrap="nowrap"><div align="center">数量</div></td>
					<td width="178" nowrap="nowrap"><div align="center">小计</div></td>
					<td width="95" nowrap="nowrap"><div align="center">操作</div></td>
				</tr>
				<s:iterator value="#session.list" var="list">
					<tr>
						<td nowrap="nowrap"><img class="data-img"
							src="images/<s:property value="#list.set.setimg"/>" width="100"
							height="100" /></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.set.setname" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.setnum" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<s:property value="#list.carprice" />
							</div></td>
						<td nowrap="nowrap"><div align="center">
								<a
									href="car/carAction_delete.action?carid=<s:property value="#list.carid"/>" >删除</a>
							</div></td>
					</tr>
				</s:iterator>
			</table>
			<div align="right">
				<em id="promotion"></em> <em> </em>商品金额: <strong
					style="color: #F00; font-size: 16px">￥<s:property
						value="#session.total" />元
				</strong>
			</div>
			<br />
			<div class="bottom">
				<div align="right">
					<a href="car/carAction_clear.action" style="margin-right: 10px;">清空购物车</a>
					<a href="order/orderAction_add.action?pageBean.page=1&carid=0" id="submit"
						class="submit">提交订单</a>
				</div>
			</div>
		</s:if>
	</div>

</body>
</html>