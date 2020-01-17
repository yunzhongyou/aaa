<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>懒人看书</title>
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
	<div class="top">
		<h1 class="fl">
			<img src="${path}/public/images/logo_ks.png" width="76" height="32" />
		</h1>
		<p class="fr">
			<a href="#" class="icon_user" title="个人中心">个人中心</a>
		</p>
	</div>
	<div class="top_menu">
		<div class="topnav">
			<a href="${path}/novel/index.do" class="cur">首页</a> <a href="#">排行</a>
			<a href="#">免费</a> <a href="#">留言</a> <a href="#">书架</a>
		</div>
	</div>
	<div class="search">
		<div class="searchbox mt10 clearfix">
			<form action="${path}/novel/search.do" method="post" >
				<input type="hidden" name="sid" value="" /> <input name="kw"
					type="text" class="t_i" placeholder="搜书搜作者" autocomplete="off"
					value="${msg}" /> <input type="hidden" name="search" value="aname" />
				<div class="searchbtn">
					<span class="t_b"></span> <span class="t_t">搜索</span> <input
						type="submit" value="" />
				</div>
			</form>
		</div>
	</div>