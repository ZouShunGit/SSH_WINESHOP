<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form id="form1" name="form1" method="post"
		action="set/setAction_edit.action" onsubmit="return checkform();">
		<div align="center">
			<table width="560" border="0" cellspacing="10" cellpadding="0">
				<tr>
					<td colspan="4"><div align="center">
							<p>
								<strong style="font-size: 24px; color: #00F;">修改套餐系列</strong>
							</p>
							<p>&nbsp;</p>
						</div></td>
				</tr>
				<s:iterator var="list" value="list" status="id">
					<tr>
						<td width="108" nowrap="nowrap"><div align="right">编&nbsp;&nbsp;&nbsp;&nbsp;号：</div></td>
						<td><input name="setid" type="text" id="setid"
							readonly="readonly" value="<s:property value="#list.setid" />" /></td>
						<td nowrap="nowrap"><div align="right">套餐名称：</div></td>
						<td><input type="text" name="setname" id="setname"
							value="<s:property value="#list.setname"/>" onblur="chaeckName()" /><label
							id="name_init"></label></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><div align="right">服&nbsp;装&nbsp;数：</div></td>
						<td width="197" nowrap="nowrap"><input type="text"
							name="clothingnum" id="clothingnum"
							value="<s:property value="#list.clothingnum" />"
							onblur="chaeckClothing()" /><label id="clo_init"></label></td>
						<td width="56" nowrap="nowrap">相&nbsp;片&nbsp;数：</td>
						<td width="270" nowrap="nowrap"><input type="text"
							name="imgnum" id="imgnum"
							value="<s:property value="#list.imgnum" />" onblur="chaeckImg()" /><label
							id="img_init"></label></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><div align="right">门&nbsp;面&nbsp;价：</div></td>
						<td nowrap="nowrap"><input type="text" name="facdeprice"
							id="facdeprice" value="<s:property value="#list.facdeprice" />"
							onblur="chaeckF()" /><label id="f_init"></label></td>
						<td nowrap="nowrap">网&nbsp;上&nbsp;价：</td>
						<td nowrap="nowrap"><input type="text" name="onlineprice"
							id="onlineprice" value="<s:property value="#list.onlineprice" />"
							onblur="chaeckO()" /><label id="o_init"></label></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><div align="right">描&nbsp;&nbsp;&nbsp;&nbsp;述：</div></td>
						<td colspan="3" nowrap="nowrap"><textarea name="setdesc"
								id="setdesc" cols="60" rows="5"><s:property
									value="#list.setdesc"/></textarea></td>
					</tr>
					<tr>
						<td nowrap="nowrap">&nbsp;</td>
						<td colspan="3" nowrap="nowrap">&nbsp;</td>
					</tr>
				</s:iterator>
				<tr>
					<td colspan="4" nowrap="nowrap"><div align="center">
							<input type="submit" value="提交" class="login" /> <input
								type="reset" value="重置" class="login" /> <input type="reset"
								class="login" value="返回" onclick="javascript :history.back(-1)"
								class="login" />
						</div></td>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		var name_boolean = true;
		var clothing_boolean = true;

		function chaeckName() {
			var aname = document.getElementById("setname").value;
			if (aname == "" || aname == null) {
				aname_Boolean = false;
				document.getElementById('name_init').innerHTML = "<font color='red'>×</font>";
			} else {
				aname_Boolean = true;
				document.getElementById("name_init").innerHTML = '<font color="green">✔</font>';
			}
		}

		function chaeckClothing() {
			var clo = document.getElementById("clothingnum").value;
			if (clo == "" || clo == null) {
				clothing_Boolean = false;
				document.getElementById('clo_init').innerHTML = "<font color='red'>×</font>";
			} else {
				clothing_Boolean = true;
				document.getElementById("clo_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		var img_boolean = true;
		function chaeckImg() {
			var img = document.getElementById("imgnum").value;
			if (img == "" || img == null) {
				img_Boolean = false;
				document.getElementById('img_init').innerHTML = "<font color='red'>×</font>";
			} else {
				img_Boolean = true;
				document.getElementById("img_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		var face_boolean = true;
		function chaeckF() {
			var i = document.getElementById("facdeprice").value;
			if (i == "" || i == null) {
				face_Boolean = false;
				document.getElementById('f_init').innerHTML = "<font color='red'>×</font>";
			} else {
				face_Boolean = true;
				document.getElementById("f_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		var online_boolean = true;
		function chaeckO() {
			var i = document.getElementById("onlineprice").value;
			if (i == "" || i == null) {
				online_Boolean = false;
				document.getElementById('o_init').innerHTML = "<font color='red'>×</font>";
			} else {
				online_Boolean = true;
				document.getElementById("o_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		function checkform() {
			if (name_boolean & clothing_boolean & img_boolean & face_boolean
					& online_boolean == true) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>
</html>