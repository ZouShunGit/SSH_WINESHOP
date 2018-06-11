<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<s:if test="#session.samples == null">
		<%
			response.sendRedirect("../index/indexAction_find.action");
		%>
	</s:if>
	<s:if test="#session.samples != null">
		<div style="width: 100%; margin: 0 auto;">

			<jsp:include page="/top.jsp"></jsp:include>
			<div>
				<iframe name=myFrame src="indexitem.jsp" width="99%" height="940"
					frameborder="0" style="margin: 0 5px;"></iframe>
			</div>
			<jsp:include page="/bottom.jsp"></jsp:include>
		</div>
	</s:if>
</body>
</html>