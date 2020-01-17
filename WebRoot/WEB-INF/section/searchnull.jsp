<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索小说</title>
<link href="../../favicon.png" rel="apple-touch-icon-precomposed" />
<meta name="viewport"
	content="width=device-width, minimum-scale=1, maximum-scale=1,user-scalable=no">
<link rel="stylesheet" href="${path}/public/css/style.css">
<script type="text/javascript">
	window.bd && bd._qdc && bd._qdc.init({
		app_id : '05474db5b2698122a1cb42a8'
	});
</script>
</head>
<body>
	<script type="text/javascript">
		var ks_host = "../../3g";
		var ks_uid = 0;
	</script>

	<div class="header">
		<span class="nav_left"><a href="javascript:history.go(-1)">返回</a></span>
		<h1>搜索小说</h1>
		<span class="nav_right"> <a rel="internal"
			href="${path}/novel/index.do">首页</a>
		</span>
	</div>
	<div class="search">
		<div class="searchbox mt10 clearfix">
			<form action="${path}/novel/search.do" method="post">
				<input type="hidden" name="sid" value="" /> <input name="kw"
					type="text" class="t_i" placeholder="搜书搜作者" autocomplete="off"
					value="" /> <input type="hidden" name="search" value="aname" />
				<div class="searchbtn">
					<span class="t_b"></span> <span class="t_t">搜索</span> <input
						type="submit" value="" />
				</div>
			</form>
		</div>
	</div>
	<div class="section">
		<div class="box tab-pane clearfix">
			<div class="blist tab-content active">
				<span style="color: red;height: 100px;">请输入搜索关键字，搜索类型：书名、作者！</span>
			</div>
		</div>
	</div>
	<div class="footer home-bg">
		<div class="footer_nav clearfix">
			<a href="#">首页</a> <a href="#">书架</a> <a href="#">分类</a> <a href="#">留言</a>
			<a href="#">个人中心</a>
		</div>

		<p class="copyright mt20">
			<b>懒人看书</b>
		</p>
		<a href="#toIndex" target="_self"> <span id="gotop"
			class="icons icon-gotop"></span>
		</a>

	</div>
	<div class="pop_cover"></div>
	<div class="pop_tip">
		<div class="pop_inner">
			<div class="pop_cont"></div>
		</div>
	</div>
</body>
</html>