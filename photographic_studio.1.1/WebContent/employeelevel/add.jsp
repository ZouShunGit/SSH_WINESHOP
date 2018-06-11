<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/register.css" rel="stylesheet" type="text/css" />
<title>员工级别添加</title>
</head>
<body>
	<form method="post" action="empLevel/empLevelAction_add.action"
		onsubmit="return checkForm();" style="margin: 20px 320px;">
		<center>
			<h2>员工级别添加</h2>
		</center>
		<br> <br>
		<table style="margin: 0 auto;" border="0" width="500px">
			<tr>
				<td align="right"
					style="color: #000; font-size: 16px; line-height: 30px;">级别名称<span
					style="color: red;">*</span>：
				</td>
				<td><input type="text" id="elname" name="elname"
					style="font-size: 16px;" onblur="checkname()" class="yanseA"><label
					id="tyla"></label></td>
			</tr>
			<tr>
				<td align="right"
					style="color: #000; font-size: 16px; line-height: 30px;">描述：
				</td>
				<td><textarea rows="15" cols="30" style="font-size: 16px;"
						name="eldesc"></textarea></td>
			</tr>

			<tr>
				<td align="right"
					style="color: #000; font-size: 16px; line-height: 30px;">&nbsp;&nbsp;
				</td>
				<td></td> 
			</tr>
			<tr>

				<td align="center" colspan="2"
					style="color: #000; font-size: 16px; line-height: 30px;"><input
					type="submit" value="提交" class="login">&nbsp;&nbsp;<input
					type="reset" value="重置" class="login"></td>
			</tr>

		</table>
	</form>
	<script type="text/javascript">
		var alname_Boolean = false;
		function checkname() {
			var name = document.getElementById("elname").value;
			var xhr = new XMLHttpRequest();
			/* 确定请求地址和请求参数 */
			var url = "empLevel/empLevelAction_findSname.action?elname=" + name
					+ "&pageBean.page=1";
			/* 调用XMLHttpRequest对象的open()方法建立对服务器的调用 */
			xhr.open("post", url, true)
			//指定响应事件处理函数
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					if (xhr.responseText == 0) {
						document.getElementById("tyla").innerHTML = "<font color='red'>级别名已存在</font>";
						alname_Boolean = false;
					} else {
						document.getElementById("tyla").innerHTML = "<font color='green'>√</font>";
						alname_Boolean = true;
					}
				}
			}
			//向服务器发送请求
			xhr.send();
		}
		function checkForm() {
			if (alname_Boolean == true) {
				return true;
			} else{
				alert("部门名称错误！");
				return false;
			}
				
		}
	</script>
</html>