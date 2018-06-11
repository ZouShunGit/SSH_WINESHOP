<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员首页</title>
</head>
<body marginheight="0" marginwidth="0">
	<s:if test="#session.samples == null">
	<%  
    response.sendRedirect("/photographic_studio/adminLogin.jsp");  
%> 
	</s:if><s:if test="#session.samples != null">
	<table style="margin: 0 0;" cellpadding="0" cellspacing="0" width="100%">
	<tr><td colspan="2"><jsp:include page="/admin/top.jsp"></jsp:include></td><tr>
		<tr>
			<td width="15%">
				<div
					style="height: 700px; background-color: #DDF0FB; padding: 0 30px;"><jsp:include
						page="/admin/left.jsp"></jsp:include></div>
			</td>
			<td width="85%">
			<iframe frameborder="0" style="width:100%;height:700px;background-color:#f5fafe" name=right></iframe>
			</td>

		</tr>
	</table>
	</s:if>
</body>
</html>