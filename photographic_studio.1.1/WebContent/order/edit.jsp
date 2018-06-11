<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/register.css" rel="stylesheet" type="text/css" />
<title>订单信息修改</title>
<meta name="keywords"
	content="nightlight, free template, pink, purple, templatemo, html css" />
<meta name="description"
	content="NightLight is a free template from templatemo." />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/slimbox2.css" type="text/css"
	media="screen" />
<script type="text/JavaScript" src="js/slimbox2.js"></script>

<script language="javascript" type="text/javascript">
	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}
</script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<div>
		<p align="center" style="font-size: 30px; color: #00F">
			<strong>订单信息</strong>
		</p>
		<div>
			<div align="center">
				<table width="764" border="1" bordercolor="#EEEEEE" cellspacing="0"
					cellpadding="0">
					<tr>
						<td colspan="5"><strong style="color: #00F; font-size: 20px">订单编号：<s:property
									value="model.oid" /></strong></td>
					</tr>
					<tr>
						<td width="69"><div align="center">序号</div></td>
						<td width="101"><div align="center">套餐图片</div></td>
						<td width="213"><div align="center">名称</div></td>
						<td width="188"><div align="center">数量</div></td>
					</tr>
					<s:iterator value="list" var="list" step="1" status="id">
					<tr>
						<td><div align="center">${id.index+1}</div></td>
						<td><div align="center">
								<img src="images/<s:property value="#list.set.setimg"/>"
									width="100" height="99" alt="套餐图片" />
							</div></td>
						<td><div align="center">
								<s:property value="#list.set.setname" />
							</div></td>
						<td><div align="center">
								<s:property value="#list.setnum" />
							</div></td>
						</tr>
					</s:iterator>
				</table>
				<div align="right">
					<em id="promotion"></em> <em> </em>商品金额: <strong
						style="color: #F00; font-size: 22px">￥<s:property
							value="total" />元
					</strong>
				</div>
				<br />
			</div>
			<form action="order/orderAction_edit.action?oid=<s:property
									value="model.oid" />&ostate=2" method="post"
				name="form1" onSubmit="return checkform();">
				<div align="center">
					<table width="886" border="0" cellspacing="5" cellpadding="0">
						<tr>
							<td width="81" nowrap="nowrap">男嘉宾名<em style="color: #F00">*</em>：
							</td>
							<td width="352" nowrap="nowrap"><input type="text"
								name="maleguests" id="maleguests" onblur="checkMale()" class="yanseA" /><label
								id="male_init"></label></td>
							<td width="80" nowrap="nowrap">女嘉宾名<em style="color: #F00">*</em>：
							</td>
							<td width="348" nowrap="nowrap"><input type="text"
								name="femaleguests" id="femaleguests" onblur="checkFeal()" class="yanseA"/><label
								id="feal_init"> </label></td>
						</tr>
						<tr>
							<td nowrap="nowrap">联系电话<em style="color: #F00">*</em>：
							</td>
							<td nowrap="nowrap"><input type="text" name="otel"
								value="<s:property value="model.otel"/>" id="otel"
								onblur="checkTel()" class="yanseA" /><label id="tel_init"> </label></td>
							<td nowrap="nowrap">联系地址<em style="color: #F00">*</em>：
							</td>
							<td nowrap="nowrap"><input type="text" name="oaddress"
								onblur="checkAddress()" id="oaddress" class="yanseA"
								value="<s:property value="model.oaddress"/>" /><label
								id="add_init"></label></td>
						</tr>
						<tr>
							<td colspan="4" nowrap="nowrap"><div
									class="membder-background addMemo-body">
									<div class="addMemo" id="iframe">
										<label>拍照日期<em
											style="color: #F00">*</em>：
										</label><input type="text" name="photodate" class="yanseA" onblur="CheckPhoto()"
											id="J-xl" /><label id="pt_init"></label>
										<div class="clear-both"></div>
									</div>
								</div> <label id="pt_init"></label></td>
						</tr>
						<tr>
							<td nowrap="nowrap">摄&nbsp;&nbsp;影&nbsp;&nbsp;师<em
								style="color: #F00">*</em>：
							</td>
							<td nowrap="nowrap"><select name="photographer" class="yanseA"
								id="photographer"  onclick="checkPhotographer()">
								<s:iterator value="photographers" var="p">
								<option value="<s:property value="#p.ename"/>"><s:property value="#p.ename"/></option>
								</s:iterator>
							</select></td>
							<td nowrap="nowrap">化&nbsp;&nbsp;妆&nbsp;&nbsp;师<em
								style="color: #F00">*</em>：
							</td>
							<td nowrap="nowrap"><select name="dresser" class="yanseA" id="dresser"
								onblur="checkDresser()"><s:iterator value="dressers" var="m">
								<option value="<s:property value="#m.ename"/>"><s:property value="#m.ename"/></option>
								</s:iterator>
							</select></td>
						</tr>
					</table>
				</div>
				<div align="right">
					<a
						href="order/orderAction_delete.action?oid=<s:property
									value="model.oid"  />" class="login" style="font-size: 18px">取消订单</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="确认订单" class="login" />
				</div>
			</form>
			<script type="text/javascript">
				$(document).ready(function() {
					var iframe = $("#iframepage").hide();
					$("#J-xl").click(function() {
						iframe.fadeIn();
					});
				});
			</script>
			<iframe src="date.jsp" width="40%" height="300" id="iframepage"
				name="iframe" frameborder="0" scrolling="no" marginheight="0"
				marginwidth="0"></iframe>
		</div>
	</div>
	<script type="text/javascript">
		var bolean_maleguests = false;
		var bolean_femaleguests = false;
		var bolean_otel = true;
		var bolean_oaddress = true;
		var bolean_photodate = false;
		function checkMale() {
			var male = document.getElementById("maleguests").value;
			if (male == null || male == "") {
				bolean_maleguests = false;
				document.getElementById('male_init').innerHTML = "<font color='red'>×</font>";
			} else {
				bolean_maleguests = true;
				document.getElementById("male_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		function checkFeal() {
			var feal = document.getElementById("femaleguests").value;
			if (feal == null || feal == "") {
				bolean_femaleguests = false;
				document.getElementById('feal_init').innerHTML = "<font color='red'>×</font>";
			} else {
				bolean_femaleguests = true;
				document.getElementById("feal_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		function checkTel() {
			var tel = document.getElementById("otel").value;
			if ((/^1[3|4|5|7|8][0-9]\d{4,8}$/).test(tel)) {
				bolean_otel = true;
				document.getElementById("tel_init").innerHTML = '<font color="green">✔</font>';
			} else {
				bolean_otel = false;
				document.getElementById('tel_init').innerHTML = "<font color='red'>×</font>";
			}
		}
		function checkAddress() {
			var add = document.getElementById("oaddress").value;
			if (add == null || add == "") {
				bolean_oaddress = false;
				document.getElementById('add_init').innerHTML = "<font color='red'>×</font>";
			} else {
				bolean_oaddress = true;
				document.getElementById("add_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		function CheckPhoto() {
			var pt = document.getElementById("J-xl").value;
			if (pt == null || pt == "") {
				bolean_photodate = false;
				document.getElementById('pt_init').innerHTML = "<font color='red'>×</font>";
			} else {
				bolean_photodate = true;
				document.getElementById("pt_init").innerHTML = '<font color="green">✔</font>';
			}
		}
	
		function checkform() {
			if (bolean_maleguests & bolean_femaleguests & bolean_otel
					& bolean_oaddress & bolean_photodate == true) {
				return true;
			} else {
				alert("请先完善信息，再进行确认订单！");
				return false;
			}
		}
	</script>
</body>
</html>