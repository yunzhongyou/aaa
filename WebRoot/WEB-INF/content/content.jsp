<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ChapterDetailName.name }</title>
<link href="../../favicon.png" rel="apple-touch-icon-precomposed" />
<meta name="viewport"
	content="width=device-width, minimum-scale=1, maximum-scale=1,user-scalable=no">
<link rel="stylesheet" href="${path}/public/css/style.css">
<script type="text/javascript">window.bd && bd._qdc && bd._qdc.init({app_id: '05474db5b2698122a1cb42a8'});</script>
</head>
<body>
	<script type="text/javascript">
		var ks_host = "../../3g";
		var ks_uid = 0;
	</script>
	<div class="wrap">
		<div class="header">
			<span class="nav_left"><a href="javascript:history.go(-1)">返回</a></span>
			<%-- <h1>${ChapterDetailName.name}</h1> --%>
			<span class="nav_right"> <a rel="internal"
				href="${path}/novel/index.do">首页</a>
			</span>
		</div>
	
		<input type="hidden" name="id" id="id" value="${ChapterList.id}">
		<div class="chaplink">
			<a href=${path}/novel/chapterDetail.do?url=${chapterDetail.prev }&baseUrl=${baseUrl}&id=${nowReadName.id}" class="prevchap bggy" id="btn_prev">上一章</a>
			<a href="${path}/novel/chapterList.do?url=${baseUrl }&id=${nowReadName.id}" class="prevchap bggy">章节列表</a>
			<a href="${path}/novel/chapterDetail.do?url=${chapterDetail.next }&baseUrl=${baseUrl}&id=${nowReadName.id}" class="nextchap bgye" style="width:30%"
				id="btn_next">下一章</a>
		</div>
		<div class="chapter" id="chapter">
			<div class="chapter-inner">
				<p class="chapname">
					<span class="bname" id="chaptitle">${chapterDetail.title }</span>
				</p>
				<p id="chapcont">
					<c:if test="${isSuccess }">
						${chapterDetail.content }
					</c:if>
					<c:if test="${!isSuccess }">
						很抱歉，读取章节内容失败了，请再试一次！
					</c:if>
				</p>
			</div>
		</div>
		<div class="chaplink">
			<a href=${path}/novel/chapterDetail.do?url=${chapterDetail.prev }&baseUrl=${baseUrl}&id=${ChapterDetailName.id}" class="prevchap bggy" id="btn_prev">上一章</a>
			<a href="${path}/novel/chapterList.do?url=${baseUrl }&id=${ChapterDetailName.id}" class="prevchap bggy">章节列表</a>
			<a href="${path}/novel/chapterDetail.do?url=${chapterDetail.next }&baseUrl=${baseUrl}&id=${ChapterDetailName.id}" class="nextchap bgye" style="width:30%"
				id="btn_next">下一章</a>
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
</body>
</html>