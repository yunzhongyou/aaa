package novel.spider.interfaces;

import java.util.List;

import novel.model.NovelInfo;

public interface INovelInfoSpider {
	/**
	 * ������һ��������url�����Ǿ͸��㷵��С˵��Ϣ
	 * @param url
	 * @return
	 */
	NovelInfo getNovelInfo(String url);
}
