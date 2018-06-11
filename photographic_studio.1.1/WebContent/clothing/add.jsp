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
	<form action="clothing/clothing_add.action" method="post"
		enctype="multipart/form-data" name="form1" id="form1" onsubmit="return checkfrom();">
		<p align="center"
			style="font-size: 32px; font-weight: bolder; color: #00F">添加服装</p>
		<table width="696" height="317" border="0" cellpadding="0"
			cellspacing="0" style="margin: 0 auto;">
			<tr>
				<td width="156" height="52"><div align="right">图&nbsp;&nbsp;&nbsp;&nbsp;片：</div></td>
				<td width="436"><input type="file" name="upload" id="upload"
					onblur="checkUpload()" class="yanseA" /><label id="upload_init"></label>
					</td>
			</tr>
			<tr>
				<td height="52"><div align="right">二级类别：</div></td>
				<td><select name="secondCategory.scid" onblur="checkCategory()"
					id="select" class="yanseA">
						<s:iterator var="list" value="list" status="id" step="1">
							<option value="<s:property value="#list.scid" />"><s:property
									value="#list.name" /></option>
						</s:iterator>
				</select><label id="category_init"></label></td>
			</tr>
			<tr>
				<td><div align="right">描&nbsp;&nbsp;&nbsp;&nbsp;述：</div></td>
				<td><textarea name="cdesc" id="textarea" cols="60" rows="8"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><div align="center">
						<input type="submit" name="button" id="button" value="提交"
							class="login" /> &nbsp;&nbsp;<input type="reset" name="button"
							id="button" value="重置" class="login" />&nbsp;&nbsp;<input
							type="button" value="返回" class="login"
							onclick="javascript :history.back(-1)" class="login" />
					</div></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		var upload_boolean = false;
		function checkUpload() {
			var i = document.getElementById("upload").value;
				if (i==null || i == "") {
					upload_boolean = false;
					document.getElementById("upload_init").innerHTML = "<font color='red'>×</font>";
				} else {
					upload_boolean = true;
					document.getElementById("upload_init").innerHTML = "<font color='green'>√</font>";
				}
				
			}
		function checkfrom() {
			if (upload_boolean == true) {
				return true;
			}else{
				alert("请添加图片！");
				return false;
			}
		}
	</script>
</body>
</html>