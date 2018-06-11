<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/register.css" rel="stylesheet" type="text/css" />
<title>部门添加</title>
</head>
<body>
	<form method="post" action="emp/empAction_edit.action"
		onsubmit="return checkForm();" style="margin: 20px 200px;"
		enctype="multipart/form-data">
		<center>
			<h2>员工编辑</h2>
		</center>
		<br> <br>
		<table width="90%" border="0" cellpadding="0" cellspacing="10"
			style="margin: 0 auto;">
			<s:if test="#session.list==null">
				<tr>
					<td style="color: red;"><s:actionmessage /></td>
				</tr>
			</s:if>
			<s:if test="#session.list!=null">
				<s:iterator var="emp" value="#session.list" status="id" step="1">

					<tr>
						<td nowrap="nowrap" style="font-size: 16px;">姓名<span
							style="color: red;">*</span>：
						</td>
						<td nowrap="nowrap"><input type="text" id="ename"
							class="yanseA" name="ename"
							value="<s:property
									value="#emp.ename" />"
							onblur="checkname()" style="font-size: 16px;"><label
							id="name_init"></label></td>
						<td nowrap="nowrap" style="font-size: 16px;">性别<span
							style="color: red;">*</span>：
						</td>
						<td nowrap="nowrap" width="203"><select name="esex"
							class="yanseA">
								<option selected="selected"
									value="<s:property
									value="#emp.esex" />"><s:property
										value="#emp.esex" /></option>
								<option value="男">男</option>
								<option value="女">女</option>
						</select></td>
					</tr>
					<tr>
						<td nowrap="nowrap" style="font-size: 16px;">邮箱<span
							style="color: red;">*</span>：
						</td>
						<td nowrap="nowrap"><input type="text" class="yanseA"
							id="eemail" name="eemail"
							value="<s:property
									value="#emp.eemail" />"
							style="font-size: 16px;" onblur="checkemail()"><label
							id="email_init"></label></td>
						<td nowrap="nowrap" style="font-size: 16px;">电话<span
							style="color: red;">*</span>：
						</td>
						<td nowrap="nowrap"><input type="text" class="yanseA"
							id="etel" name="etel"
							value="<s:property
									value="#emp.etel" />"
							style="font-size: 16px;" onblur="checktel()"><label
					id="tel_init"></label></td>
					</tr>
					<tr>
						<td nowrap="nowrap" style="font-size: 16px;">相片<span
							style="color: red;">*</span>：
						</td>
						<td nowrap="nowrap"><input class="yanseA" type="file"
							name="upload" onblur="checkupload()" />
							<label id="upload_init"></label></td>

					</tr>
					<tr>
						<td nowrap="nowrap" style="font-size: 16px;">部门<span
							style="color: red;">*</span>：
						</td>
						<td nowrap="nowrap"><select name="department.did"
							style="font-size: 16px;" class="yanseA">
								<option selected="selected"
									value="<s:property
									value="#emp.department.did" />"><s:property
										value="#emp.department.dname" /></option>
								<s:iterator var="dept" status="id" value="depts">
									<option value="<s:property value="#dept.did"/>"><s:property
											value="#dept.dname" /></option>
								</s:iterator>
						</select></td>
						<td nowrap="nowrap" style="font-size: 16px;">职称<span
							style="color: red;">*</span>：
						</td>
						<td nowrap="nowrap"><select name="employeeLevel.elid"
							style="font-size: 16px;">
								<option selected="selected"
									value="<s:property
									value="#emp.employeeLevel.elid" />"><s:property
										value="#emp.employeeLevel.elname" /></option>
								<s:iterator var="empl" status="id" value="empls">
									<option value="<s:property value="#empl.elid"/>"><s:property
											value="#empl.elname" /></option>
								</s:iterator>
						</select></td>
					</tr>
					<tr>
						<td nowrap="nowrap" style="font-size: 16px;">描述：</td>
						<td colspan="3"><textarea rows="5" cols="65"
								style="font-size: 16px;" name="edesc"><s:property
									value="#emp.edesc" /></textarea></td>
					</tr>
					<tr>
						<td><input type="hidden" name="eid"
							value="<s:property value="#emp.eid"/>"></td>
						<td></td>
					</tr>
					<tr>
						<td align="center" colspan="4"
							style="color: #000; font-size: 16px; line-height: 30px;"><input
							type="submit" value="提交" class="login">&nbsp;&nbsp;<input
							type="reset" value="重置" class="login"> &nbsp;&nbsp;
							<button type="button" value="" class="login">返回</button></td>
					</tr>
				</s:iterator>
			</s:if>
		</table>
	</form>
	<script type="text/javascript">
		var name_boolean = true;
		var email_boolean = true;
		var tel_boolean = true;
		function checkname() {
			var i = document.getElementById("ename").value;
			if (i == "" || i == null) {
				category_boolean = false;
				document.getElementById('name_init').innerHTML = "<font color='red'>×</font>";
			} else {
				category_boolean = true;
				document.getElementById("name_init").innerHTML = '<font color="green">✔</font>';
			}
		}
		function checkemail() {
			var i = document.getElementById("eemail").value;
			if ((/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/)
					.test(i)) {
				category_boolean = true;
				document.getElementById("email_init").innerHTML = '<font color="green">✔</font>';
			} else {
				category_boolean = false;
				document.getElementById('email_init').innerHTML = "<font color='red'>×</font>";
			}
		}
		function checktel() {
			var utel = document.getElementById("etel").value;
			if ((/^1[3|4|5|7|8][0-9]\d{4,8}$/).test(utel)) {
				tel_Boolean = true;
				document.getElementById("tel_init").innerHTML = '<font color="green">✔</font>';
			} else {
				tel_Boolean = false;
				document.getElementById('tel_init').innerHTML = "<font color='red'>×</font>";
			}
		}

		function checkFrom() {
			if (name_boolean & email_boolean & tel_boolean
					& upload_boolean == true) {
				return true;
			} else {
				alert("请完善信息，再提交！");
				return false;
			}
		}
	</script>
</body>
</html>