package novel.spider.util;

import novel.spider.NovelSiteEnum;
import novel.spider.impl.chapter.DefaultChapterDetailSpider;
import novel.spider.interfaces.IChapterDetailSpider;

public final class ChapterDetailSpiderFactory {
	private  ChapterDetailSpiderFactory() {}
	/**
	 * 通过给定的URL返回一个实现了IChapterDetailSpider的具体实现类
	 * @param url
	 * @return
	 */
	public static IChapterDetailSpider getsChapterDetailSpider(String url) {
		IChapterDetailSpider spider = null;
		System.out.println("ChapterDetailSpiderFactory.IChapterDetailSpider.getsChapterDetailSpider 运行了");
		//NovelSiteEnum novelSiteEnum = NovelSiteEnum.getEnumByUrl(url);
//		switch (novelSiteEnum) {
//		case Bxwx:
			spider =new DefaultChapterDetailSpider();
//			break;
//		}
		return spider;
	}

}
