package novel.spider.util;

import novel.spider.NovelSiteEnum;
import novel.spider.impl.chapter.BxwxChapterSpider;
import novel.spider.interfaces.IChapterSpider;

public final class ChapterSpiderFactory {
	private ChapterSpiderFactory() {}
	/**
	 * ͨ��������URL����һ��ʵ����IChapterSpider�ӿڵ�ʵ����
	 * @param url
	 * @return
	 */
	public static IChapterSpider getChapterSpider(String url) {
		NovelSiteEnum novelSiteEnum = NovelSiteEnum.getEnumByUrl(url);
		IChapterSpider chapterSpider = null;
		switch (novelSiteEnum) {
		case Bxwx:
			chapterSpider =new BxwxChapterSpider();
			break;
		/*case KSW:
		case WDWX:
		case QB:
		case SHU:
			chapterSpider =new DefaultChapterSpider();
			break;*/
		}
		return chapterSpider;
	}
}
