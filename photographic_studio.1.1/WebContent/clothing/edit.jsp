<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="clothing/clothing_edit.action" method="post"
		enctype="multipart/form-data" name="form1" id="form1" onsubmit="return checkfrom();">
		<table width="696" height="317" border="0" cellpadding="0"
			cellspacing="0" style="margin: 0 auto;">
			<tr>
				<td height="52" colspan="2" nowrap="nowrap"><div align="center"
						style="color: blue;">
						<strong style="font-size: 32px;">服装编辑</strong>
					</div></td>
			</tr>
			<tr>
				<td height="52" nowrap="nowrap">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<s:iterator var="list" value="list" status="id" step="1">
				<tr>
					<td height="52" nowrap="nowrap"><div align="right">服装编号：</div></td>
					<td><input name="cid" type="text" id="cid" class="yanseA" readonly="readonly"
						value="<s:property value="#list.cid" />" /></td>
				</tr>
				<tr>
					<td width="156" height="52" nowrap="nowrap"><div align="right">图&nbsp;&nbsp;&nbsp;&nbsp;片：</div></td>
					<td width="436"> <input type="file"
						name="upload" id="upload" class="yanseA" onblur="checkUpload()" /></td>
				</tr>
				<tr>
					<td height="52" nowrap="nowrap"><div align="right">二级类别：</div></td>
					<td><select name="secondCategory.scid" id="select" class="yanseA">
							<option value="<s:property value="#list.secondCategory.scid" />"><s:property
									value="#list.secondCategory.name" /></option>
							<s:iterator var="sCategories" value="sCategories" status="id"
								step="1">
								<option value="<s:property value="#sCategories.scid" />"><s:property
										value="#sCategories.name" /></option>
							</s:iterator>
					</select></td>
				</tr>
				<tr>
					<td nowrap="nowrap"><div align="right">描&nbsp;&nbsp;&nbsp;&nbsp;述：</div></td>
					<td><textarea name="cdesc"
							id="cdesc" cols="60" rows="5"><s:property
								value="#list.cdesc" /></textarea></td>
				</tr>
			</s:iterator>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><div align="center">
						<input type="submit" value="提交" class="login" /> &nbsp;&nbsp;<input
							type="reset" value="重置" class="login" />&nbsp;&nbsp;<input
							type="button" value="返回" onclick="javascript :history.back(-1)"
							class="login" />
					</div></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		var upload_boolean = true;
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