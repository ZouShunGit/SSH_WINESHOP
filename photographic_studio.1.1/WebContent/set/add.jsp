<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		action="set/setAction_add.action" enctype="multipart/form-data" onsubmit="return checkform()">
		<div align="center">
			<table width="560" border="0" cellspacing="10" cellpadding="0">
				<tr>
					<td colspan="4"><div align="center">
							<p>
								<strong>添加套餐系列</strong>
							</p>
							<p>&nbsp;</p>
						</div></td>
				</tr>
				<tr>
					<td width="108" nowrap="nowrap"><div align="right">套餐名称：</div></td>
					<td><input type="text" name="setname" id="setname"
						onblur="chaeckName()" /><label id="name_init"></label></td>
					<td>图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片：</td>
					<td><input type="file"
						name="upload" id="upload" onblur="checkupload()" /><label id="upload_init"></label> </td>
				</tr>
				<tr>
					<td nowrap="nowrap"><div align="right">服&nbsp;&nbsp;&nbsp;装&nbsp;数：</div></td>
					<td width="197" nowrap="nowrap"><input type="text"
						name="clothingnum" id="clothingnum" onblur="chaeckClothing()" /><label
						id="clo_init"></label></td>
					<td width="56" nowrap="nowrap">相&nbsp;片&nbsp;数：</td>
					<td width="270" nowrap="nowrap"><input type="text"
						name="imgnum" id="imgnum" onblur="chaeckImg()" /><label
						id="img_init"></label></td>
				</tr>
				<tr>
					<td nowrap="nowrap"><div align="right">门&nbsp;&nbsp;面&nbsp;&nbsp;价：</div></td>
					<td nowrap="nowrap"><input type="text" name="facdeprice"
						id="facdeprice" onblur="chaeckF()" /><label id="f_init"></label></td>
					<td nowrap="nowrap">网&nbsp;上&nbsp;价：</td>
					<td nowrap="nowrap"><input type="text" name="onlineprice"
						id="onlineprice" onblur="chaeckO()" /><label id="o_init"></label></td>
				</tr>
				<tr>
					<td nowrap="nowrap"><div align="right">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</div></td>
					<td colspan="3" nowrap="nowrap"><textarea name="setdesc"
							id="setdesc" cols="60" rows="5"></textarea></td>
				</tr>
				<tr>
					<td nowrap="nowrap">&nbsp;</td>
					<td colspan="3" nowrap="nowrap">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4" nowrap="nowrap"><div align="center">
							<input type="submit" value="提交" class="login" /> <input
								type="reset" value="重置" class="login" /> <input type="button"
								value="返回" onclick="javascript :history.back(-1)" class="login" />
						</div></td>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		var name_boolean = false;
		var clothing_boolean = false;

		function chaeckName() {
			var setname = document.getElementById("setname").value;
			var xhr = new XMLHttpRequest();
			/* 确定请求地址和请求参数 */
			var url = "set/setAction_findSetname.action?setname="+setname
					+ "&pageBean.page=1";
			/* 调用XMLHttpRequest对象的open()方法建立对服务器的调用 */
			xhr.open("post", url, true)
			//指定响应事件处理函数
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					if (xhr.responseText == 0) {
						name_boolean = false;
						document.getElementById("name_init").innerHTML = "<font color='red'>×</font>";
						
					} else {
						name_boolean = true;
						document.getElementById("name_init").innerHTML = "<font color='green'>√</font>";
						
					}
				}
			}
			//向服务器发送请求
			xhr.send();
		}

		function chaeckClothing() {
			var clo = document.getElementById("clothingnum").value;
			if (clo == "" || clo == null) {
				clothing_boolean = false;
				document.getElementById('clo_init').innerHTML = "<font color='red'>×</font>";
			} else {
				clothing_boolean = true;
				document.getElementById("clo_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		var img_boolean = false;
		function chaeckImg() {
			var img = document.getElementById("imgnum").value;
			if (img == "" || img == null) {
				img_boolean = false;
				document.getElementById('img_init').innerHTML = "<font color='red'>×</font>";
			} else {
				img_boolean = true;
				document.getElementById("img_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		var face_boolean = false;
		function chaeckF() {
			var i = document.getElementById("facdeprice").value;
			if (i == "" || i == null) {
				face_boolean = false;
				document.getElementById('f_init').innerHTML = "<font color='red'>×</font>";
			} else {
				face_boolean = true;
				document.getElementById("f_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		var online_boolean = false;
		function chaeckO() {
			var i = document.getElementById("onlineprice").value;
			if (i == "" || i == null) {
				online_boolean = false;
				document.getElementById('o_init').innerHTML = "<font color='red'>×</font>";
			} else {
				online_boolean = true;
				document.getElementById("o_init").innerHTML = '<font color="green">✔</font>';
			}
		}

		var upload_boolean = false;
		function checkupload() {
			var i = document.getElementById("upload").value;
			if (i == "" || i == null) {
				upload_boolean = false;
				document.getElementById('upload_init').innerHTML = "<font color='red'>×</font>";
			} else {
				upload_boolean = true;
				document.getElementById("upload_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		function checkform() {
			if (name_boolean & clothing_boolean & img_boolean & face_boolean
					& online_boolean & upload_boolean == true) {
				return true;
			} else {
				alert("请完善信息！");
				return false;
			}
		}
	</script>
</body>
</html>