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
<div>
	<p align="center" style="font-size: 28px; color: #00F">
		<strong>样片级别编辑</strong>
	</p>
	<p align="center" style="font-size: 28px; color: #00F">&nbsp;</p>
	<form action="samplecategory/samplecategory_add.action" method="post"
		enctype="multipart/form-data" onSubmit="return checkfrom();">
		<div align="center">
			<table width="631" border="0" cellspacing="10" cellpadding="0"
				style="font-size: 18px">
				<tr>
					<td nowrap="nowrap"><div align="right">编号：</div></td>
					<td nowrap="nowrap"><input name="scid" class="yanseA"
						type="text" id="scid" readonly="readonly"
						value="<s:property value="model.scid"/>" /></td>
				</tr>
				<tr>
					<td width="206" nowrap="nowrap"><div align="right">名称：</div></td>
					<td width="410" nowrap="nowrap"><input type="text"
						name="scname" id="scname" onblur="checkName()" class="yanseA"
						value="<s:property value="model.scname"/>" /><label
						id="name_init"></label></td>
				</tr>
				<tr>
					<td nowrap="nowrap"><div align="right">描述：</div></td>
					<td nowrap="nowrap"><textarea name="scdesc"
							style="font-size: 18px" id="scdesc" cols="45" rows="5"><s:property
								value="model.scdesc" /></textarea></td>
				</tr>
				<tr>
					<td nowrap="nowrap"><div align="right">&nbsp;</div></td>
				</tr>
				<tr>
					<td colspan="2" nowrap="nowrap"><div align="center">
							<input type="reset" class="login" value="返回"
								onclick="javascript :history.back(-1)" class="login" /> <input
								name="input" type="reset" value="重置" class="login" /> <input
								type="submit" name="button" id="button" value="提交" class="login" />
						</div></td>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		var neme_boolean = false;
		function checkName() {
			var i = document.getElementById("scname").value;
			var xhr = new XMLHttpRequest();
			/* 确定请求地址和请求参数 */
			var url = "samplecategory/samplecategory_findByscname.action?pageBean.page=1&scname="
					+ i;
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
		function checkfrom() {
			if (name_boolean == true) {
				return true;
			} else {
				return false;
			}
		}
	
		
	</script>
</div>
</body>
</html>