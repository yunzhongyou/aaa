<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作品简介</title>
<link href="../../favicon.png" rel="apple-touch-icon-precomposed" />
<meta name="viewport"
	content="width=device-width, minimum-scale=1, maximum-scale=1,user-scalable=no">
<link rel="stylesheet" href="${path}/public/css/style.css">
<script type="text/javascript">window.bd && bd._qdc && bd._qdc.init({app_id: '05474db5b2698122a1cb42a8'});</script>
</head>
<body>
	<script type="text/javascript">	var ks_host = "../../3g";		var ks_uid = 0;		</script>

	<div class="header">
		<span class="nav_left"><a href="javascript:history.go(-1)">返回</a></span>
		<h1>作品简介</h1>
		<span class="nav_right"> <a rel="internal"
			href="${path}/novel/index.do">首页</a>
		</span>
	</div>
	<div class="wrap clearfix">
	
		<div class="section bindex">
		<input type="hidden" name="id" id="id" value="${NovelInfo.id}">
		<input type="hidden" name="url" id="url" value="${NovelInfo.chapterUrl}">
			<div class="btitle">
				${ NovelInfo.name}<span>(${NovelInfo.status})</span>
			</div>
			<div class="blist">
				<ul>
					<li>
						<div class="bookwrap clearfix">
							<div class="bcover fl">
								<img
									src="${NovelInfo.img }"
									
									height="130" width="100">
							</div>
							<div class="bintro b_i pl10">
								<p>
									分类: <b class="tname"><a href="${path }/novel/urbanNovel.do"
										class="ye">${NovelInfo.type}</a></b><br /> 作者: ${NovelInfo.author }<br /> 共${NovelInfo.length }字 <br />
									收藏: ${NovelInfo.collection } 
								</p>
							</div>
						</div>
						
						<div class="blink gyb bl3 mt5">
							<a href='${path}/novel/nowRead.do?url=${ NovelInfo.firstcontenturl }&baseUrl=${NovelInfo.chapterUrl }&id=${NovelInfo.id}' class="cur">
							马上阅读</a> 
							<a href="#" class="book_fav" id="btn_fav">收藏</a>
							<a href="${path}/novel/chapterList.do?url=${NovelInfo.chapterUrl}&name=${NovelInfo.name}&id=${NovelInfo.id}" class="last">查看目录</a>
						</div>
					</li>
					<li>
						<span class="bname">
							<%-- <a href="${path}/novel/nowRead.do?url=${NovelInfo.lastUpdateChapterUrl }&baseUrl=${NovelInfo.chapterUrl }&id=${NovelInfo.id}"> --%>
								最新章节：<b class="ye">${NovelInfo.lastUpdateChapter}</b>
							</a>
						</span>
								更新时间：<b class="gy"><fmt:formatDate value="${NovelInfo.lastUpdateTime}" type="date" pattern="yyyy-MM-dd"/>(更新)</b>
							
					</li>
					<li>
						<div class="intro">
							<p>
								<b>简介：</b>${NovelInfo.introduction}
							</p>
						</div>
					</li>
				</ul>
			</div>
			<div class="blink bl4 gyb mt10">
				<a href="#"><i class="icons icon_cmt"></i> 书评</a> 
				<a href="#"><i class="icons icon_flw"></i> 红花</a> 
				<a href="#"><i class="icons icon_mny"></i> 打赏</a> 
				<a href="#" class="last"><i class="icons icon_fan"></i> 粉丝</a>
			</div>
		</div>
		<div class="footer home-bg">
			<div class="footer_nav clearfix">
				<a href="#">首页</a> 
				<a href="#">书架</a> 
				<a href="#">分类</a> 
				<a href="#">留言</a>
				<a href="#">个人中心</a>
			</div>

			<p class="copyright mt20">
				<b>懒人看书</b>
			</p>
			<span id="gotop" class="icons icon-gotop"></span>
		</div>
		<div class="pop_cover"></div>
		<div class="pop_tip">
			<div class="pop_inner">
				<div class="pop_cont"></div>
			</div>
		</div>
	</div>
</body>
</html>