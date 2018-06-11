<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>套餐评价</title>
<link href="css/public.css" rel="stylesheet" type="text/css" />
<link href="css/message.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/jquery-1.8.3.js"></script>
	<script src="js/sinlar.js"></script>
</head>
<body oncontextmenu=self.event.returnValue=false>
	<div align="center">
		<table width="921">
			<tr>
				<td colspan="2"><div align="center"
						style="font-size: 24px; color: #00F">
						<strong>套餐详情</strong>
					</div></td>
			</tr>
			<tr>
				<td width="458">
					<div style="width: 80%">
						<img class="data-img" src="images/<s:property value="set.setimg"/>" width="458"
							height="279" alt="套餐图片" />

					</div>
				</td>
				<td width="451">
					<div style="font-size: 18px">
						<dl>
							<dt>
								套餐名称：
								<s:property value="set.setname" />
							</dt>
							<dd>
								门面价：￥
								<s:property value="set.facdeprice" />
								元
							</dd>
							<dd>
								网上价：<font color="red">￥<s:property
										value="set.onlineprice" />元
								</font>
							</dd>
							<dd>
								服装数：
								<s:property value="set.clothingnum" />
								套
							</dd>
							<dd>
								相片数：
								<s:property value="set.imgnum" />
								张
							</dd>
							<dd>
								<div align="left">
									描述：
									<textarea rows="5" readonly="readonly" cols="44"
										style="font-size: 18px"><s:property
											value="set.setdesc" /></textarea>
								</div>
							</dd>
						</dl>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<s:if test="list == null">
		<s:actionmessage />
	</s:if>
	<s:if test="list != null">
		<div class="mian">
			<div class="liuyan">
				<div class="title">
					<a href="">评论</a>
				</div>
				<ul>
					<s:iterator value="list" var="list" status="id" step="1">

						<li>
							<div class="layout recListLeft f14">
								<div class="recDes">
									<div class="vm bold c999">
										<a class="c4095ce" target="_blank" href="#">${id.index+1 }楼</a> <span><s:property value="#list.creattime" /></span>
									</div>
									<p class="recBox">
										<s:property value="#list.comdesc" />
									</p>
								</div>
							</div>
						</li>
					</s:iterator>
				</ul>
			</div>
					<div class="digg">
						<p align="center" style="">
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
						href="comment/comments_index.action?set.setid=<s:property value="#list.setid" />&pageBean.page=1">首页</a>&nbsp;
		<a style="color: #000"
						href="comment/comments_index.action?set.setid=<s:property value="#list.setid" />&pageBean.page=<s:property value="model.pageBean.page-1"/>">上一页</a>&nbsp;
		</s:if>

				<s:if test="model.pageBean.page != model.pageBean.totalPage">
					<a style="color: #000"
						href="comment/comments_index.action?set.setid=<s:property value="#list.setid" />&pageBean.page=<s:property value="model.pageBean.page+1" />">下一页</a>&nbsp;
			<a style="color: #000"
						href="comment/comments_index.action?set.setid=<s:property value="#list.setid" />&pageBean.page=<s:property value="model.pageBean.totalPage"/>">尾页</a>
				</s:if><a style="color: #000" href="javascript:history.go(-1)">返回</a>
			</p>
			</div>
		</div>
	</s:if>
</body>
</html>
