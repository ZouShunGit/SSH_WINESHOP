<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/register.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.8.3.js"></script>
<script src="js/sinlar.js"></script>
</head>
<body oncontextmenu=self.event.returnValue=false>
	<div align="left">
		<form action="photo/photoAction_select.action?pageBean.page=1"
			method="post">
			<table width="461" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<th width="92" nowrap="nowrap" scope="col"><div align="center">是否已选：</div></th>
					<th width="68" nowrap="nowrap" scope="col"><div align="center">
							<select name="sign" id="sign"><option value="1">未选</option>
								<option value="2">已选</option>
								<option selected="selected" value="0">全部</option>
							</select>
						</div></th>
					<th width="339" nowrap="nowrap" scope="col">
						<div align="left">
							<input type="submit" name="button" id="button" value="查询" />
						</div>
					</th>
				</tr>
			</table>

		</form>
	</div>
	<s:if test="list == null">
		<h2 align="left" style="color: red;">
			<s:actionmessage />
		</h2>
	</s:if>
	<s:if test="list != null">
		<div align="center">
			<h2 align="center" style="color: #00F">在先选片</h2>
			<table width="731" border="1" cellspacing="0" cellpadding="0"
				bordercolor="#EEEEEE">
				<tr>
					<th width="115" nowrap="nowrap" scope="col"><div
							align="center">序号</div></th>
					<th width="125" nowrap="nowrap" scope="col"><div
							align="center">相片编号</div></th>
					<th width="159" nowrap="nowrap" scope="col"><div
							align="center">图片</div></th>
					<th width="225" nowrap="nowrap" scope="col"><div
							align="center">订单编号</div></th>
					<th width="322" nowrap="nowrap" scope="col"><div
							align="center">选取标志</div></th>
				</tr>

				<s:iterator var="list" value="list" status="id" step="1">
					<c:if test="${id.index % 2 == 0 }">
						<tr bgcolor="#BDFFFF">
							<td nowrap="nowrap"><div align="center">${id.index +1 }</div></td>
							<td nowrap="nowrap"><div align="center">
									<s:property value="#list.pid" />
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<img class="data-img" src="images/<s:property value="#list.pimg" />" width="100"
										height="63" alt="选片图片" />
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<s:property value="#list.oid" />
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<s:if test="#list.sign != 2">
										<input type="button" value="选择"
											id="but<s:property value="#list.pid"/>"
											onclick="showDetail(<s:property value="#list.pid"/>,<s:property value="#list.oid"/>)" />
									</s:if>
									<s:if test="#list.sign == 2">
										<input type="button" value="取消"
											id="but<s:property value="#list.pid"/>"
											onclick="showDetail(<s:property value="#list.pid"/>,<s:property value="#list.oid"/>)" />
									</s:if>
								</div></td>
						</tr>
					</c:if>

					<c:if test="${id.index %2 != 0 }">
						<tr>
							<td nowrap="nowrap"><div align="center">${id.index +1 }</div></td>
							<td nowrap="nowrap"><div align="center">
									<s:property value="#list.pid" />
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<img class="data-img"
										src="images/<s:property value="#list.pimg" />" width="100"
										height="63" alt="选片图片" />
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<s:property value="#list.oid" />
								</div></td>
							<td nowrap="nowrap"><div align="center">
									<s:if test="#list.sign != 2">
										<input type="button" value="选择"
											id="but<s:property value="#list.pid"/>"
											onclick="showDetail(<s:property value="#list.pid"/>,<s:property value="#list.oid"/>)" />
									</s:if>
									<s:if test="#list.sign == 2">
										<input type="button" value="取消"
											id="but<s:property value="#list.pid"/>"
											onclick="showDetail(<s:property value="#list.pid"/>,<s:property value="#list.oid"/>)" />
									</s:if>
								</div></td>
						</tr>
					</c:if>
				</s:iterator>
			</table>
			<p align="center">
				每页显示：
				<s:property value="model.pageBean.rows" />
				/
				<s:property value="model.pageBean.listnum" />
				条记录！当前页：
				<s:property value="model.pageBean.page" />
				/
				<s:property value="model.pageBean.totalPage" />
				页！
				<s:if test="model.pageBean.page != 1">
					<a style="color: #000"
						href="photo/photoAction_select.action?sign=<s:property value="model.sign"/>&oid=<s:property value="model.oid"/>&pageBean.page=1">首页</a>&nbsp;
		<a style="color: #000"
						href="photo/photoAction_select.action?sign=<s:property value="model.sign"/>&oid=<s:property value="model.oid"/>&pageBean.page=<s:property value="model.pageBean.page-1"/>">上一页</a>&nbsp;
		</s:if>

				<s:if test="model.pageBean.page != model.pageBean.totalPage">
					<a style="color: #000"
						href="photo/photoAction_select.action?sign=<s:property value="model.sign"/>&oid=<s:property value="model.oid"/>&pageBean.page=<s:property value="model.pageBean.page+1" />">下一页</a>&nbsp;
			<a style="color: #000"
						href="photo/photoAction_select.action?sign<s:property value="model.sign"/>&oid=<s:property value="model.oid"/>&pageBean.page=<s:property value="model.pageBean.totalPage"/>">尾页</a>
				</s:if>
			</p>
		</div>
	</s:if>
</body>
<script type="text/javascript">
	function showDetail(pid,oid) {
		var but = document.getElementById("but" + pid);
		if (but.value == "选择") {
			// 1.创建异步对象
			var xhr = createXmlHttp();
			// 2.设置监听
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					if (xhr.responseText != 1) {
						alert("您选择的相片已超出规定的数目，多选的将例外支付费用！多选图片3以内，每张30元，多选图片3以上，每张25元！");
					}
				}
			}
			// 3.打开连接
			xhr.open("GET",
					"photo/photoAction_edit.action?pid="
							+ pid + "&sign=2&oid="+oid+"", true);
			// 4.发送
			xhr.send(null);
			but.value = "取消";
		} else {
			// 1.创建异步对象
			var xhr = createXmlHttp();
			// 2.设置监听
			xhr.onreadystatechange = function() {
			}
			// 3.打开连接
			xhr.open("GET",
					"photo/photoAction_edit.action?pid="
							+ pid + "&sign=1&oid="+oid+"", true);
			// 4.发送
			xhr.send(null);
			but.value = "选择";
		}
	}
	function createXmlHttp() {
		var xmlHttp;
		try { // Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {// Internet Explorer
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}
		return xmlHttp;
	}
</script>
</html>