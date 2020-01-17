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
			<form action="${path}/novel/search.do" method="get">
				<input type="hidden" name="sid" value="" /> <input name="kw"
					id="kw" type="text" class="t_i" placeholder="搜书搜作者" value="" /> <input
					type="hidden" name="search" value="${msg}" />
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
				<ul>
					<c:forEach items="${NovelName}" var="temp" varStatus="status">
						<li><a
							href='${path }/novel/novelInfo.do?id=${temp.id}&baseUrl=${temp.chapterUrl}'>
								<div class="bcover fl">
									<img src="${temp.img}" alt="${temp.name}" height="130"
										width="100" />
								</div>
								<div class="bintro pl10">
									<h4>${temp.name}</h4>
									<p>${temp.type}.
										(${temp.status}) 共${temp.length}字<br>
										${temp.introduction}
									</p>
								</div>
						</a></li>
					</c:forEach>
				</ul>
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