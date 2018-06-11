<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/public.css" rel="stylesheet" type="text/css" />
<link href="css/register.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function initMenu() {
  $('#piece0 ul').hide();
  $('#piece0 ul:first').show();
   $('#menu ul').hide();
  $('#menu ul:first').show();
  $('#menu li a').click(
    function() {
      var checkElement = $(this).next();
      if((checkElement.is('ul')) && (checkElement.is(':visible'))) {
        return false;
        }
      if((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
        $('#menu ul:visible').slideUp('normal');
        checkElement.slideDown('normal');
        return false;
        }
      }
    );
  }
$(document).ready(function() {
initMenu();
$(".close").click(
			function () {
				$(this).parent().fadeTo(400, 0, function () { // Links with the class "close" will close parent
					$(this).slideUp(400);
				});
				return false;
			}
		);
});
</script>
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

<body>
	<div class="mian">
		<div id="slider1" class="slider">
			<div class="conbox">
				<div>
					<a href="#" title=""><img src="tp/ddf.jpg" width="1000"
						height="355" /></a>
				</div>
				<div>
					<a href="#" title=""><img src="tp/dde.jpg" width="1000"
						height="355" /></a>
				</div>
			</div>

			<div class="switcher">
				<a href="#" class="cur">1</a> <a href="#">2</a> 
			</div>
		</div>
		<div id="tabs0">
			<div class="hdk">
				<ul class="menu0" id="menu0">
					<li onClick="setTab(0,0)" class="hover">关于我们</li>
				</ul>
			</div>
			<div class="piece" id="piece0">
				<ul class="block">
					<li>
						<div class="about">尊贵的客户，您好！欢迎进入幸福影楼客户服务中心！这里将为您展示新人的幸福瞬间。与此同时，并将最美好的祝福送给每对新人。
							幸福影楼客户咨询热线：0451-88195252 太阳城欢迎广大追求美的新人前来咨询，我们将留给您不一样的记忆。
							了解我们，从这里开始 | 摄影常见问题解答 | 服务须知：拍摄当天 | 服务须知：拍摄前准备 | 高端定制服务服务流程 |
							高端定制服务服务说明
							郑重声明：伯爵客户服务频道所展示的作品均来自真实客人定制照片，并经由客户本人同意在唯一官方网站www.stbjhs.com进行发表。
							未经允许不得转载或用于任何商业用途，违者必究！幸福影楼客户咨询热线：0451-88195252
							太阳城欢迎广大追求美的新人前来咨询，我们将留给您不一样的记忆。 了解我们，从这里开始 | 摄影常见问题解答 | 服务须知：拍摄当天
							| 服务须知：拍摄前准备 | 高端定制服务服务流程 | 高端定制服务服务说明
							郑重声明：伯爵客户服务频道所展示的作品均来自真实客人定制照片，并经由客户本人同意在唯一官方网站www.stbjhs.com进行发表。
							未经允许不得转载或用于任何商业用途，幸福影楼客户咨询热线：0451-88195252
							太阳城欢迎广大追求美的新人前来咨询，我们将留给您不一样的记忆。 了解我们，从这里开始 | 摄影常见问题解答 | 服务须知：拍摄当天
							| 服务须知：拍摄前准备 | 高端定制服务服务流程 | 高端定制服务服务说明
							郑重声明：伯爵客户服务频道所展示的作品均来自真实客人定制照片，并经由客户本人同意在唯一官方网站www.stbjhs.com进行发表。
							未经允许不得转载或用于任何商业用途，</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>