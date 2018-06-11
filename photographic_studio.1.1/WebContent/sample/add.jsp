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
	<div>
		<p align="center" style="font-size: 28px; color: #00F">
			<strong>样片添加</strong>
		</p>
		<p align="center" style="font-size: 28px; color: #00F">&nbsp;</p>
		<form action="sample/sampleAction_add.action" method="post"
			enctype="multipart/form-data" onSubmit="return checkfrom();">
			<div align="center">
				<table width="631" border="0" cellspacing="15" cellpadding="0"
					style="font-size: 18px">
					<tr>
						<td width="206"><div align="right">名称：</div></td>
						<td width="410"><input type="text" name="sname" onblur="checkName()" id="sname"  class="yanseA" /><label
							id="name_init"></label></td>
					</tr>
					<tr>
						<td><div align="right">类别：</div></td>
						<td><select name="sampleCategory.scid" class="yanseA" id="category"
							onblur="checkCategory()">	<s:iterator value="categories" var="cate">
				<option value="<s:property value="#cate.scid"/>"><s:property value="#cate.scname"/></option>
				
				</s:iterator>
			</select><label id="category_init"></label></td>
					</tr>
					<tr>
						<td><div align="right">图片：</div></td>
						<td><input type="file" name="upload" id="upload"
							onblur="checkUpload()" class="yanseA" /><label id="upload_init"></label></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td colspan="2"><div align="center"><input type="reset"
								class="login" value="返回" onclick="javascript :history.back(-1)"
								/>
								<input name="" type="reset" value="重置" class="login"  /> <input type="submit"
									name="button" id="button" value="提交" class="login"  />
							</div></td>
					</tr>

				</table>
			</div>
		</form>
		<script type="text/javascript">
			var neme_boolean = false;
			var category_boolean = false;
			var upload_boolean = false;
			function checkName() {
				var i = document.getElementById("sname").value;
				if (i == "" || i == null) {
					name_boolean = false;
					document.getElementById("name_init").innerHTML = "<font color='red'>×</font>";
				} else {
					name_boolean = true;
					document.getElementById("name_init").innerHTML = "<font color='green'>√</font>";
				}	
			
			}
			function checkCategory() {
				var i = document.getElementById("category").value;
				if (i == "" || i == null) {
					category_boolean = false;
					document.getElementById('category_init').innerHTML = "<font color='red'>×</font>";
				} else {
					category_boolean = true;
					document.getElementById("category_init").innerHTML = '<font color="green">✔</font>';
				}
			}
			function checkUpload() {
				var i = document.getElementById("upload").value;
				if (i == "" || i == null) {
					upload_boolean = false;
					document.getElementById('upload_init').innerHTML = "<font color='red'>×</font>";
				} else {
					upload_boolean = true;
					document.getElementById("upload_init").innerHTML = '<font color="green">✔</font>';
				}
			}
			function checkfrom() {
				if (name_boolean & category_boolean & upload_boolean == true) {
					return true;
				} else {
					alert("请完善信息！");
					return false;
				}
			}
		</script>
	</div>
</body>
</html>