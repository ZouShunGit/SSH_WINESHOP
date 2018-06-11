<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/dtree.css"
	rel="stylesheet" type="text/css">
<title>menu</title>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/dtree.js"></script>
<body>
	<table width="90%" border="0" cellspacing="1" cellpadding="2"
		align="center">
		<thead>
			<tr>
				<th style="color: green;">欢迎您：<s:property
						value="#session.existAdmin.aname" /></th>
			</tr>
		</thead>

		<tr>
			<td>
				<div class="dtree">
					<a href="javascript: d.openAll();">展开所有</a> | <a
						href="javascript: d.closeAll();">关闭所有</a>
					<s:if test="#session.existAdmin.alevel == 1 ">
					<script type="text/javascript">
					    d=new dTree('d');
					    
					    d.add('01','-1','幸福影楼管理系统');
					    d.add('0101','01','用户管理');
					    d.add('010101','0101','用户列表','${pageContext.request.contextPath}/user/userAction_findAllUser.action?pageBean.page=1','','right');
						
					    d.add('0102','01','信息管理');
					    d.add('010201','0102','部门管理');
					    d.add('01020101','010201','部门列表','${pageContext.request.contextPath}/dept/deptAction_findAll.action?pageBean.page=1','','right');
					
					    d.add('010202','0102','员工级别管理');
					    d.add('01020201','010202','级别列表','${pageContext.request.contextPath}/empLevel/empLevelAction_findAll.action?pageBean.page=1','','right');
					    
					    d.add('010203','0102','员工管理');
					    d.add('01020301','010203','员工列表','${pageContext.request.contextPath}/emp/empAction_findAll.action?pageBean.page=1','','right');
					    
				/* 	    d.add('010204','0102','服装管理');
					    d.add('01020401','010204','分类管理');
					    d.add('0102040101','01020401','一级分类管理','${pageContext.request.contextPath}/category/category_findAll.action?pageBean.page=1','','right');
					    d.add('0102040102','01020401','二级分类管理','${pageContext.request.contextPath}/scategory/scategory_findAll.action?pageBean.page=1','','right');
					    d.add('01020402','010204','服装列表','${pageContext.request.contextPath}/clothing/clothing_findAll.action?pageBean.page=1','','right');
					    
						d.add('010205','0102','样片管理');
						d.add('01020501','010205','样片类别','${pageContext.request.contextPath}/samplecategory/samplecategory_findAll.action?pageBean.page=1','','right');
						d.add('01020502','010205','样片列表','${pageContext.request.contextPath}/sample/sampleAction_findAll.action?pageBean.page=1&sampleCategory.scid=0','','right');
						
						d.add('010206','0102','套餐管理');
						d.add('01020601','010206','套餐列表','${pageContext.request.contextPath}/set/setAction_findAll.action?pageBean.page=1','','right');
						 */
					    d.add('0103','01','管理员管理');
				
					 /*    d.add('010301','0103','管理员列表','${pageContext.request.contextPath}/admin/adminAction_findAll.action?pageBean.page=1','','right'); */
					    d.add('010302','0103','修改密码','${pageContext.request.contextPath}/admin/adminAction_editPassPage.action','','right');
					    /* 
					    d.add('0104','01','订单管理');
					    d.add('010401','0104','订单列表','${pageContext.request.contextPath}/order/orderAction_findAll.action?pageBean.page=1&ostate=0','','right');
					    d.add('010402','0104','选片列表','${pageContext.request.contextPath}/photo/photoAction_findAll.action?pageBean.page=1','','right');
					    
					    d.add('0105','01','评论管理');
					    d.add('010501','0105','信息列表','${pageContext.request.contextPath}/user/userAction_findAllUser.action？page=1','','right');
					     */
					    /*     d.add('0106','01','留言管理');
					    d.add('010601','0106','留言列表','${pageContext.request.contextPath}/user/userAction_findAllUser.action？page=1','','right');
					    */
					    d.add('0107','-1','退出','${pageContext.request.contextPath}/admin/adminAction_quit.action','','_top');
					    
					    document.write(d);
					 
					  </script>
					</s:if>
					<s:if test="#session.existAdmin.alevel == 2 ">
					<script type="text/javascript">
					    d=new dTree('d');
					    
					    d.add('01','-1','幸福影楼管理系统');
					  /*   d.add('0101','01','用户管理');
					    d.add('010101','0101','用户列表','${pageContext.request.contextPath}/user/userAction_findAllUser.action?pageBean.page=1','','right');
						 */
					    d.add('0102','01','信息管理');
					   /*  d.add('010201','0102','部门管理');
					    d.add('01020101','010201','部门列表','${pageContext.request.contextPath}/dept/deptAction_findAll.action?pageBean.page=1','','right');
					
					    d.add('010202','0102','员工级别管理');
					    d.add('01020201','010202','级别列表','${pageContext.request.contextPath}/empLevel/empLevelAction_findAll.action?pageBean.page=1','','right');
					    
					    d.add('010203','0102','员工管理');
					    d.add('01020301','010203','员工列表','${pageContext.request.contextPath}/emp/empAction_findAll.action?pageBean.page=1','','right');
					     */
				 	    d.add('010204','0102','服装管理');
					    d.add('01020401','010204','分类管理');
					    d.add('0102040101','01020401','一级分类管理','${pageContext.request.contextPath}/category/category_findAll.action?pageBean.page=1','','right');
					    d.add('0102040102','01020401','二级分类管理','${pageContext.request.contextPath}/scategory/scategory_findAll.action?pageBean.page=1','','right');
					    d.add('01020402','010204','服装列表','${pageContext.request.contextPath}/clothing/clothing_findAll.action?pageBean.page=1','','right');
					    
						d.add('010205','0102','样片管理');
						d.add('01020501','010205','样片类别','${pageContext.request.contextPath}/samplecategory/samplecategory_findAll.action?pageBean.page=1','','right');
						d.add('01020502','010205','样片列表','${pageContext.request.contextPath}/sample/sampleAction_findAll.action?pageBean.page=1&sampleCategory.scid=0','','right');
						
						d.add('010206','0102','套餐管理');
						d.add('01020601','010206','套餐列表','${pageContext.request.contextPath}/set/setAction_findAll.action?pageBean.page=1','','right');
						
					    d.add('0103','01','管理员管理');
				
					    /* d.add('010301','0103','管理员列表','${pageContext.request.contextPath}/admin/adminAction_findAll.action?pageBean.page=1','','right'); */
					    d.add('010302','0103','修改密码','${pageContext.request.contextPath}/admin/adminAction_editPassPage.action','','right');
					    
					    d.add('0104','01','订单管理');
					    d.add('010401','0104','订单列表','${pageContext.request.contextPath}/order/orderAction_findAll.action?pageBean.page=1&ostate=0','','right');
					    d.add('010402','0104','选片列表','${pageContext.request.contextPath}/photo/photoAction_findAll.action?pageBean.page=1','','right');
					    
					    d.add('0105','01','评论管理');
					    d.add('010501','0105','信息列表','${pageContext.request.contextPath}/comment/comments_findAll.action?page=1','','right');
					   

					    d.add('0107','-1','退出','${pageContext.request.contextPath}/admin/adminAction_quit.action','','_top');
					    
					    document.write(d);
					 
					  </script>
					</s:if>
						<s:if test="#session.existAdmin.alevel == 3 ">
					<script type="text/javascript">
					    d=new dTree('d');
					    
					    d.add('01','-1','幸福影楼管理系统');
					    d.add('0101','01','用户管理');
					    d.add('010101','0101','用户列表','${pageContext.request.contextPath}/user/userAction_findAllUser.action?pageBean.page=1','','right');
						 
					    d.add('0102','01','信息管理');
					    d.add('010201','0102','部门管理');
					    d.add('01020101','010201','部门列表','${pageContext.request.contextPath}/dept/deptAction_findAll.action?pageBean.page=1','','right');
					
					    d.add('010202','0102','员工级别管理');
					    d.add('01020201','010202','级别列表','${pageContext.request.contextPath}/empLevel/empLevelAction_findAll.action?pageBean.page=1','','right');
					    
					    d.add('010203','0102','员工管理');
					    d.add('01020301','010203','员工列表','${pageContext.request.contextPath}/emp/empAction_findAll.action?pageBean.page=1','','right');
					     
				 	    d.add('010204','0102','服装管理');
					    d.add('01020401','010204','分类管理');
					    d.add('0102040101','01020401','一级分类管理','${pageContext.request.contextPath}/category/category_findAll.action?pageBean.page=1','','right');
					    d.add('0102040102','01020401','二级分类管理','${pageContext.request.contextPath}/scategory/scategory_findAll.action?pageBean.page=1','','right');
					    d.add('01020402','010204','服装列表','${pageContext.request.contextPath}/clothing/clothing_findAll.action?pageBean.page=1','','right');
					    
						d.add('010205','0102','样片管理');
						d.add('01020501','010205','样片类别','${pageContext.request.contextPath}/samplecategory/samplecategory_findAll.action?pageBean.page=1','','right');
						d.add('01020502','010205','样片列表','${pageContext.request.contextPath}/sample/sampleAction_findAll.action?pageBean.page=1&sampleCategory.scid=0','','right');
						
						d.add('010206','0102','套餐管理');
						d.add('01020601','010206','套餐列表','${pageContext.request.contextPath}/set/setAction_findAll.action?pageBean.page=1','','right');
						
					    d.add('0103','01','管理员管理');
				
					    d.add('010301','0103','管理员列表','${pageContext.request.contextPath}/admin/adminAction_findAll.action?pageBean.page=1','','right');
					    d.add('010302','0103','修改密码','${pageContext.request.contextPath}/admin/adminAction_editPassPage.action','','right');
					    
					    d.add('0104','01','订单管理');
					    d.add('010401','0104','订单列表','${pageContext.request.contextPath}/order/orderAction_findAll.action?pageBean.page=1&ostate=0','','right');
					    d.add('010402','0104','选片列表','${pageContext.request.contextPath}/photo/photoAction_findAll.action?pageBean.page=1','','right');
					    
					    d.add('0105','01','评论管理');
					    d.add('010501','0105','信息列表','${pageContext.request.contextPath}/comment/comments_findAll.action?pageBean.page=1','','right');
					   
					    
					    d.add('0107','-1','退出','${pageContext.request.contextPath}/admin/adminAction_quit.action','','_top');
					    
					    document.write(d);
					 
					  </script>
					</s:if>
					
				</div>
			</td>
		</tr>
	</table>
</body>
</html>