package novel.spider.util;

import novel.spider.NovelSiteEnum;
import novel.spider.impl.chapter.BxwxChapterSpider;
import novel.spider.impl.chapter.DefaultChapterDetailSpider;
import novel.spider.impl.novel.BxwxNovelInfoSpider;
import novel.spider.impl.novel.BxwxNovelSpider;
import novel.spider.interfaces.IChapterDetailSpider;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.interfaces.INovelInfoSpider;
import novel.spider.interfaces.INovelSpider;

/**
 * �����鼮�б��ʵ����
 */
public final class NovelSpiderFactory {
	private NovelSpiderFactory() {}
	public static BxwxNovelSpider bxwxNovelSpider;
	public static BxwxNovelInfoSpider bxwxNovelInfoSpider;
	public static BxwxChapterSpider bxwxChapterSpider;
	public static DefaultChapterDetailSpider defaultChapterDetailSpider;
	
	public static INovelSpider getNovelSpider(String url) {
		System.out.println("NovelSpiderFactory 's getNovelSpider is going on");
		NovelSiteEnum novelSiteEnum = NovelSiteEnum.getEnumByUrl(url);
		
		switch (novelSiteEnum) {
		//case Bxwx : return bxwxNovelSpider==null?new BxwxNovelSpider():bxwxNovelSpider;
		case Bxwx : return new BxwxNovelSpider();
		default : throw new RuntimeException(url + "��ʱ����֧��");
		}
	}
	public static INovelInfoSpider getNovelInfoSpider(String url) {
		System.out.println("NovelSpiderFactory 's getNovelInfoSpider is going on");
		NovelSiteEnum novelSiteEnum = NovelSiteEnum.getEnumByUrl(url);
		System.out.println("NovelSpiderFactory 's NovelSiteEnum.getEnumByUrl(url) is going on");
		switch (novelSiteEnum) {
		case Bxwx : return bxwxNovelInfoSpider==null?new BxwxNovelInfoSpider():bxwxNovelInfoSpider;
		default : throw new RuntimeException(url + "��ʱ����֧��");
		}
	}
	public static IChapterSpider getChapterSpider(String url) {
		NovelSiteEnum novelSiteEnum = NovelSiteEnum.getEnumByUrl(url);
		switch (novelSiteEnum) {
		case Bxwx : return bxwxChapterSpider==null?new BxwxChapterSpider():bxwxChapterSpider;
		default : throw new RuntimeException(url + "��ʱ����֧��");
		}
	}
	public static IChapterDetailSpider getChapterDetailSpider(String url) {
		NovelSiteEnum novelSiteEnum = NovelSiteEnum.getEnumByUrl(url);
		switch (novelSiteEnum) {
		case Bxwx : return defaultChapterDetailSpider==null?new DefaultChapterDetailSpider():defaultChapterDetailSpider;
		default : throw new RuntimeException(url + "��ʱ����֧��");
		}
	}
}
