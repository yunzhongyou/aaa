package novel.spider.util;

import novel.spider.NovelSiteEnum;
import novel.spider.impl.chapter.DefaultChapterDetailSpider;
import novel.spider.interfaces.IChapterDetailSpider;

public final class ChapterDetailSpiderFactory {
	private  ChapterDetailSpiderFactory() {}
	/**
	 * ͨ��������URL����һ��ʵ����IChapterDetailSpider�ľ���ʵ����
	 * @param url
	 * @return
	 */
	public static IChapterDetailSpider getsChapterDetailSpider(String url) {
		IChapterDetailSpider spider = null;
		System.out.println("ChapterDetailSpiderFactory.IChapterDetailSpider.getsChapterDetailSpider ������");
		//NovelSiteEnum novelSiteEnum = NovelSiteEnum.getEnumByUrl(url);
//		switch (novelSiteEnum) {
//		case Bxwx:
			spider =new DefaultChapterDetailSpider();
//			break;
//		}
		return spider;
	}

}
