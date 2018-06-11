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
			<strong>样片编辑</strong>
		</p>
		<p align="center" style="font-size: 28px; color: #00F">&nbsp;</p>
		<form action="sample/sampleAction_edit.action" method="post"
			enctype="multipart/form-data" onSubmit="return checkfrom();">
			<div align="center">
				<table width="631" border="0" cellspacing="15" cellpadding="0"
					style="font-size: 18px">
					<tr>
						<td><div align="right">编号：</div></td>
						<td><input name="said" type="text" id="said"
							readonly="readonly" class="yanseA"
							value="<s:property value="model.said"/>" /></td>
					</tr>

					<tr>
						<td width="206"><div align="right">名称：</div></td>
						<td width="410"><input type="text"
							value="<s:property value="model.sname"/>" onblur="checkName()"
							name="sname" id="sname" class="yanseA" /><label id="name_init"></label></td>
					</tr>
					<tr>
						<td><div align="right">类别：</div></td>
						<td><select name="sampleCategory.scid" class="yanseA"
							id="category" onblur="checkCategory()">
								<option value="<s:property value="model.sampleCategory.scid"/>"
									selected="selected"><s:property
										value="model.sampleCategory.scname" /></option>
								<s:iterator value="categories" var="cate">
									<option value="<s:property value="#cate.scid"/>"><s:property
											value="#cate.scname" /></option>

								</s:iterator>
						</select><label id="category_init"></label></td>
					</tr>
					<tr>
						<td><div align="right">图片：</div></td>
						<td><input type="file" name="upload" id="upload"
							onblur="checkUpload()" class="yanseA" /><label id="upload_init"></label></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2"><div align="center">
								<input type="reset" class="login" value="返回"
									onclick="javascript :history.back(-1)" /> <input name=""
									type="reset" value="重置" class="login" /> <input type="submit"
									name="button" id="button" value="提交" class="login" />
							</div></td>
					</tr>

				</table>
			</div>
		</form>
		<script type="text/javascript">
			var neme_boolean = true;
			var category_boolean = true;
			function checkName() {
				var i = document.getElementById("sname").value;
				if (i == "" || i == null) {
					name_boolean = false;
					document.getElementById("name_init").innerHTML = "<font color='red'>样片名不能为空</font>";

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

			function checkfrom() {
				if (name_boolean & category_boolean == true) {
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