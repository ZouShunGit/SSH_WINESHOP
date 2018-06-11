<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/register.css" rel="stylesheet" type="text/css" />
<title>部门编辑</title>
</head>
<body>
	<form id="form1" name="form1" method="post" action="category/category_edit.action" onsubmit="return checkfrom();">
		<p align="center" style="font-size: 24px; color: #00F">一级类别编辑</p>
		<table width="579" height="419" border="0" cellpadding="0"
			cellspacing="10" style="margin: 0 auto;">
			<s:iterator var="list" value="list" status="id" step="1">
			<tr>
				<td nowrap="nowrap"><div align="right">类别编号：</div></td>
				<td><input name="cid" type="text" id="cid"
					readonly="readonly" value="<s:property value="#list.cid" />"/></td>
			</tr>
			<tr>
				<td width="135" nowrap="nowrap"><div align="right">类别名称：</div></td>
				<td width="459"><input type="text" name="cname" onblur="checkName()" id="cname" value="<s:property value="#list.cname" />"/></td>
			</tr>
			<tr>
				<td height="171" nowrap="nowrap"><div align="right">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</div></td>
				<td><textarea name="cdesc" id="cdesc" cols="50" rows="10"><s:property value="#list.cdesc" /></textarea></td>
			</tr>
			</s:iterator>
			<tr>
				<td height="171" colspan="2"><center>
						<input type="submit" value="提交" class="login" /> &nbsp;&nbsp; <input
							type="reset" value="重置" class="login" /> &nbsp;&nbsp;
						<input
							type="button" value="返回" onclick="javascript :history.back(-1)"
							class="login" />
					</center></td>
			</tr>
			
		</table>
	</form>
		<script type="text/javascript">
	var neme_boolean = false;
	function checkName() {
		var i = document.getElementById("cname").value;
		var xhr = new XMLHttpRequest();
		/* 确定请求地址和请求参数 */
		var url = "category/category_findSname.action?cname=" + i
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
	function checkfrom() {
		if (name_boolean == true) {
			return true;
		}else{
			alert("请完善信息");
			return false;
		}
	}
	</script>
</body>
</html>