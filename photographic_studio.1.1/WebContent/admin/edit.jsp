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
	<form method="post" action="admin/adminAction_edit.action"
		onsubmit="return checkForm();" style="margin: 100px 320px;">
		<center>
			<h2 style="color:blue;">管理员编辑</h2>
		</center>
		<br> <br>
		<table style="margin: 0 auto;font-size: 18px" border="0">
				<s:iterator var="list" value="list" status="id" step="1">
					<tr>
						<td align="right" nowrap="nowrap"
							style="color: #000; font-size: 16px; line-height: 30px;">管理员编号<span
							style="color: red;">*</span>：
						</td>
						<td colspan="2"><input type="text" id="aid" name="aid"
							style="font-size: 16px;" readonly="readonly"
							onblur="checkAname()" class="yanseA" value="<s:property value="#list.aid" />"><label id="tyla"></label></td>
					</tr>
					<tr>
						<td align="right" nowrap="nowrap"
							style="color: #000;  font-size: 16px; line-height: 30px;">管理员姓名<span
							style="color: red;">*</span>：
						</td>
						<td colspan="2"><input type="text" id="aname" name="aname"
							style="font-size: 16px;" onblur="checkAname()" value="<s:property value="#list.aname" />" class="yanseA"><label
							id="aname_init"></label></td>
					</tr>
					<tr>
						<td align="right" nowrap="nowrap"
							style="color: #000; font-size: 16px; line-height: 30px;">邮箱<span
							style="color: red;">*</span>：
						</td>
						<td colspan="2"><input type="text" id="aemail" readonly="readonly" name="aemail"
							style="font-size: 16px;" value="<s:property value="#list.aemail" />" class="yanseA"><label id="tyla"></label></td>
					</tr>
					<tr>
						<td align="right" nowrap="nowrap"
							style="color: #000; font-size: 16px; line-height: 30px;">联系电话<span
							style="color: red;">*</span>：
						</td>
						<td colspan="2"><input type="text" id="atel" name="atel" onblur="checkTel()"
							style="font-size: 16px;" class="yanseA" value="<s:property value="#list.atel" />"><label id="tel_init"></label></td>
					</tr>
					<tr>
						<td align="right" nowrap="nowrap"
							style="color: #000; font-size: 16px; line-height: 30px;">管理员级别<span
							style="color: red;">*</span>：
						</td>
						<td colspan="2"><select name="alevel" style="font-size: 16px;"
							class="yanseA" >
								<option value="1" selected="selected">人事管理员</option>
								<option value="2">物资管理员</option>
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

				</s:iterator>

		</table>
		<script type="text/javascript">
		/* 验证手机号 */
		var tel_Boolean = true;
		var aname_Boolean = true;
		function checkAname(){
			var aname = document.getElementById("aname").value;
			if (aname == "" ||aname == null) {
				aname_Boolean = false;
				document.getElementById('aname_init').innerHTML = "<font color='red'>×</font>";
			}else{
				aname_Boolean = true;
				document.getElementById("aname_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		
		function checkTel() {
			var utel = document.getElementById("atel").value;
			if ((/^1[3|4|5|7|8][0-9]\d{4,8}$/).test(utel)) {
				tel_Boolean = true;
				document.getElementById("tel_init").innerHTML = '<font color="green">✔</font>';
			} else {
				tel_Boolean = false;
				document.getElementById('tel_init').innerHTML = "<font color='red'>×</font>";
			}
		}
		function checkForm() {
			if (tel_Boolean & aname_Boolean == true) {
				return true;
			}else
				return false;
		}
		</script>
	</form>
</body>
</html>