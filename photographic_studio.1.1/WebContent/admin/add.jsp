<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/register.css" rel="stylesheet" type="text/css" />
<title>管理员级别添加</title>
</head>
<body>
	<form method="post" action="admin/adminAction_add.action"
		onsubmit="return checkForm();" style="margin: 100px 320px;">
		<center>
			<h2>添加管理员</h2>
		</center>
		<br> <br>
		<table style="margin: 0 auto;" border="0">
			<tr>
				<td align="right"
					style="color: #000; font-size: 16px; line-height: 30px;">管理员姓名<span
					style="color: red;">*</span>：
				</td> 
				<td><input type="text" id="aname" name="aname"
					style="font-size: 16px;"  class="yanseA"><label
					id="tyla"></label></td>
			</tr>
			<tr>
				<td align="right"
					style="color: #000; font-size: 16px; line-height: 30px;">邮箱<span
					style="color: red;">*</span>：
				</td>
				<td><input type="text" id="aemail" name="aemail"
					style="font-size: 16px;" class="yanseA" onblur="checkEmail()"><label id="email_init"></label></td>
			</tr>
			<tr>
				<td align="right"
					style="color: #000; font-size: 16px; line-height: 30px;">联系电话<span
					style="color: red;">*</span>：
				</td>
				<td><input type="text" id="atel" name="atel"
					style="font-size: 16px;" class="yanseA"><label id="tyla"></label></td>
			</tr>
			<tr>
				<td align="right"
					style="color: #000; font-size: 16px; line-height: 30px;">管理员级别<span
					style="color: red;">*</span>：
				</td>
				<td><select name="alevel" style="font-size: 16px;"
					class="yanseA">
						<option value="1" selected="selected">人事管理员</option>
						<option value="2" selected="selected">物资管理员</option>
				</select><label id="tyla"></label></td>
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
		var email_Boolean = false;
		function checkEmail() {
			var  aemail = document.getElementById("aemail").value;
			var xhr = new XMLHttpRequest();
			/* 确定请求地址和请求参数 */
			var url = "admin/adminAction_findByAemail.action?aemail=" +  aemail
					+ "&pageBean.page=1";
			/* 调用XMLHttpRequest对象的open()方法建立对服务器的调用 */
			xhr.open("post", url, true)
			//指定响应事件处理函数
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					if (xhr.responseText == 0) {
						document.getElementById("email_init").innerHTML = "<font color='red'>×</font>";
						aemail_Boolean = false;
					} else {
						document.getElementById("email_init").innerHTML = "<font color='green'>√</font>";
						aemail_Boolean = true;
					}
				}
			}
			//向服务器发送请求
			xhr.send();
		}
		function checkForm() {
			if (aemail_Boolean == true) {
				return true;
			} else
				return false;
		}
	</script>
</body>
</html>