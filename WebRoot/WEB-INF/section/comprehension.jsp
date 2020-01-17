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
<title>仙侠修真</title>
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
		<h1>仙侠修真</h1>
	</div>
	<div class="section">
		<div class="box tab-pane clearfix">
			<div class="blist tab-content active">
				<ul>
					<c:forEach items="${Comprehension}" var="temp" varStatus="status">
						<li><a
							href='${path }/novel/novelInfo.do?id=${temp.id}&baseUrl=${temp.chapterUrl}'>
								<div class="bcover fl">
									<img src="${temp.img}" alt="${temp.name}" height="130"
										width="100" />
								</div>
								<div class="bintro pl10">
									<h4>${temp.name}</h4>
									<p>${temp.type}.
										(${temp.status}) 共${temp.length}字<br> ${temp.introduction}
									</p>
								</div>
						</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<%@include file="../common/foot.jsp"%>