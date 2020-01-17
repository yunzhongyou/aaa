<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>
<div class="top_class">
	<div class="list_nav">
		<ul>
			<li style="width: 21%;"><a href='${path}/novel/urbanNovel.do'>都市言情</a></li>
			<li style="width: 21%;"><a href='${path}/novel/comprehension.do'>仙侠修真</a></li>
			<li style="width: 21%;"><a href='${path}/novel/fantasyMagic.do'>玄幻魔法</a></li>
			<li style="width: 21%;"><a href='${path}/novel/scienceFiction.do'>科幻灵异</a></li>
			<li style="width: 21%;"><a href='${path}/novel/horror.do'>同人小说</a></li>
			<li style="width: 21%;"><a href='${path}/novel/onlineGame.do'>网游竞技</a></li>
			<li style="width: 21%;"><a href='${path}/novel/historical.do'>历史军事</a></li>
			<li style="width: 21%;"><a href='${path}/novel/other.do'>其他类型</a></li>
		</ul>
	</div>
</div>
<div class="section">
	<h3 class="title">
		<span class="b_l">都市小说
			<span style='float:right;'><a href="${path}/novel/urbanNovel.do" class="more">更多作品&gt;</a></span>
		</span>
		
	</h3>
	<div class="box tab-pane clearfix">
		<div class="blist tab-content active">
			<ul>
				<c:forEach items="${UrbanNovel}" var="temp" varStatus="status">
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
<div class="section">
	<h3 class="title">
		<span class="b_l">玄幻魔法
			<span style='float:right;'><a href="${path}/novel/fantasyMagic.do" class="more">更多作品&gt;</a></span>
		</span>
	</h3>
	<div class="box tab-pane clearfix">
		<div class="blist tab-content active">
			<ul>
				<c:forEach items="${FantasyMagic}" var="temp" varStatus="status">
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
<div class="section">
	<h3 class="title">
		<span class="b_l">武侠修真
			<span style='float:right;'><a href="${path}/novel/comprehension.do" class="more">更多作品&gt;</a></span>
		</span>
	</h3>
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

<div class="section">
	<h3 class="title">
		<span class="b_l">科幻灵异
			<span style='float:right;'><a href="${path}/novel/scienceFiction.do" class="more">更多作品&gt;</a></span>
		</span>
	</h3>
	<div class="box tab-pane clearfix">
		<div class="blist tab-content active">
			<ul>
				<c:forEach items="${ScienceFiction}" var="temp" varStatus="status">
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

<div class="section">
	<h3 class="title">
		<span class="b_l">同人小说
			<span style='float:right;'><a href="${path}/novel/horror.do" class="more">更多作品&gt;</a></span>
		</span>
		
	</h3>
	<div class="box tab-pane clearfix">
		<div class="blist tab-content active">
			<ul>
				<c:forEach items="${Horror}" var="temp" varStatus="status">
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

<div class="section">
	<h3 class="title">
		<span class="b_l">网游竞技
			<span style='float:right;'><a href="${path}/novel/onlineGame.do" class="more">更多作品&gt;</a></span>
		</span>
	</h3>
	<div class="box tab-pane clearfix">
		<div class="blist tab-content active">
			<ul>
				<c:forEach items="${OnlineGame}" var="temp" varStatus="status">
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

<div class="section">
	<h3 class="title">
		<span class="b_l">历史军事
			<span style='float:right;'><a href="${path}/novel/historical.do" class="more">更多作品&gt;</a></span>
		</span>
	</h3>
	<div class="box tab-pane clearfix">
		<div class="blist tab-content active">
			<ul>
				<c:forEach items="${Historical}" var="temp" varStatus="status">
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


<div class="section">
	<h3 class="title">
		<span class="b_l">其他类型
			<span style='float:right;'><a href="${path}/novel/other.do" class="more">更多作品&gt;</a></span>
		</span>
	</h3>
	<div class="box tab-pane clearfix">
		<div class="blist tab-content active">
			<ul>
				<c:forEach items="${Other}" var="temp" varStatus="status">
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

<%@include file="common/foot.jsp"%>