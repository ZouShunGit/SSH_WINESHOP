<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>jQuery支持拖拽图片上传的图片批量上传插件</title>

<link rel="stylesheet" type="text/css" href="css/webuploader.css" />
<link rel="stylesheet" type="text/css" href="css/stylea.css" />
<style>
.width_auto {
	width: 900px;
	margin: 100px auto;
}
</style>

</head>
<body>
	<div class="width_auto">
		<div id="container">
			<!--头部，相册选择和格式选择-->
			<div id="uploader">

				<div class="item_container">
					<div id="" class="queueList">
						<div id="dndArea" class="placeholder">
							<div id="filePicker"></div>
						</div>
					</div>
				</div>
				<div class="statusBar" style="display: none;">
					<div class="progress">
						<span class="text">0%</span> <span class="percentage"></span>
					</div>
					<div class="info"></div>
					<div class="btns">
						<div id="filePicker2"></div>
						<div class="uploadBtn">开始上传</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery-1.9.min.js"></script>
	<script src="js/webuploader.js"></script>
	<script src="js/jquery.sortable.js"></script>
	<script src="js/upload.js"></script>

</body>
</html>