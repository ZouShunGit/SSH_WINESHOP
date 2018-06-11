<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/public.css" rel="stylesheet" type="text/css" />
<link href="css/activity.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.Xslider.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	// 焦点图片水平滚动
	$("#slider1").Xslider({
		// 默认配置
		affect: 'scrollx', //效果  有scrollx|scrolly|fade|none
		speed: 800, //动画速度
		space: 6000, //时间间隔
		auto: true, //自动滚动
		trigger: 'mouseover', //触发事件 注意用mouseover代替hover
		conbox: '.conbox', //内容容器id或class
		ctag: 'div', //内容标签 默认为<a>
		switcher: '.switcher', //切换触发器id或class
		stag: 'a', //切换器标签 默认为a
		current:'cur', //当前切换器样式名称
		rand:false //是否随机指定默认幻灯图片
	});
	
	// 焦点图片垂直滚动
	$("#slider2").Xslider({
		affect:'scrolly',
		ctag: 'div',
		speed:400
	});
	
	// 焦点图片淡隐淡现
	$("#slider3").Xslider({
		affect:'fade',
		ctag: 'div'
	});
	
	// 选项卡
	$("#slider4").Xslider({
		affect:'none',
		ctag: 'div',
		speed:10
	});
	
	
});
</script>
</head>
<body oncontextmenu=self.event.returnValue=false>
<div id="slider1" class="slider">
			<div class="conbox">
				<div><a href="#" title=""><img src="tp/ddf.jpg" width="1000" height="355" /></a></div>
				<div><a href="#" title=""><img src="tp/dde.jpg" width="1000" height="355" /></a></div>
				</div>

			<div class="switcher">
				<a href="#" class="cur">1</a>
				<a href="#">2</a>
			</div>
</div>
<div class="mian">
	<div class="matter">
    	<div class="left">
            <div class="a01">
            	<div class="biaoti">
                	<h1>巴黎公主婚纱摄</h1>
                    仅售3688元！价值15999元的巴黎公主婚纱摄3天2夜厦门海岛婚纱之旅，免费精品酒
店住宿2晚，免费提供WiFi。成就一个永恒的幸福瞬间。
                </div>
                <div class="content">
               	  <div class="m">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td><a href="user/userlogin.jsp"><img src="images/img_22.jpg" width="206" height="61" /></a></td>
                      </tr>
                      <tr>
                        <td height="30"></td>
                      </tr>
                      <tr>
                        <td align="center" class="baomi">共281 人已报名</td>
                      </tr>
                      <tr>
                        <td height="30"></td>
                      </tr>
                      <tr>
                        <td align="center" class="shuzi">¥298 </td>
                      </tr>
                       <tr>
                        <td>&nbsp;</td>
                      </tr>
                    </table>
                    </div>
                    <div class="n"><img src="tp/8.jpg" width="458" height="279" /></div>
              </div>
            </div>
        </div>
        <div class="right">
       	  <div class="b01">
            	<div class="info">客服服务</div>
                <div class="content"><img src="images/img_23.jpg" width="232" height="43" /></div>
            </div>
            <div class="b01">
           	  <div class="info">客服服务</div>
                <div class="content1">
                <span class="red">尊贵的客户</span>，您好！欢迎进入幸福影楼客户服务中心！这里将为您展示新人的
                幸福瞬间。与此同时，并将最美好的祝福
                送给每对新人。<br />
                婚纱摄影客户咨询热线：0451-88195252
                 欢迎广大追求美的新人前来咨询我
                们将留给您不一样的记忆。<br />
                了解我们，从这里开始 | 摄影常见问题解
                答 | 服务须知：拍摄当天 | 服务须知：拍
                摄前准备 | 高端定制服务服务流程 | 高端
                定制服务服务说明<br />
                 </div>
            </div>
        </div>
    </div>

 </div>
</body>
</html>