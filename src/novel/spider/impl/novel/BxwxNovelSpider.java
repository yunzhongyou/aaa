package novel.spider.impl.novel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import novel.model.Novel;
import novel.model.NovelInfo;
import novel.spider.NovelSiteEnum;
import novel.spider.interfaces.INovelInfoSpider;
import novel.spider.util.NovelSpiderFactory;
import novel.spider.util.NovelSpiderUtil;

/**
 * 笔下文学网站的书籍列表爬取
 */
public class BxwxNovelSpider extends AbstractNovelSpider {
	public BxwxNovelSpider() {}

	@Override
	public List<Novel> getsNovel(String url, Integer maxTryTimes) {
		System.out.println("BxwxNovelSpider 's getsNovel is going on");
		List<Novel> novels = new ArrayList<>();
		INovelInfoSpider infoSpider = NovelSpiderFactory.getNovelInfoSpider(url);
		System.out.println("BxwxNovelSpider 's NovelSpiderFactory.getNovelInfoSpider is going on");
		System.out.println("BxwxNovelSpider 's infoSpider ="+infoSpider);
		
		try {
			System.out.println("下一步执行或出错 BxwxNovelSpider Elements trs = super.getsTr(url, maxTryTimes)");
			Elements trs = super.getsTr(url, maxTryTimes);
			for (int index = 1, size = trs.size(); index < size; index++) {
				try{
					
					System.out.println("BxwxNovelSpider 's  infoSpider=" +infoSpider.toString()+"***********执行次数="+index+"次");
					
					
					Element tr = trs.get(index);
					
					Elements tds = tr.getElementsByTag("td");
					
					System.out.println("BxwxNovelSpider 's tdsSub =" +tds.toString().substring(0,20));
					Novel novel = new Novel();
					novel.setName(tds.first().text());
					//novel.setAuthor(tds.get(index).text());
					String novelUrl = tds.first().getElementsByTag("a").first().absUrl("href");
					System.out.println("BxwxNovelSpider 's novelUrl ="+novelUrl);
					System.out.println("BxwxNovelSpider 's novel 内容="+novel);
					
					System.out.println("下一步执行 BxwxNovelSpider's infoSpider.getNovelInfo(novelUrl) ");
					NovelInfo novelInfo = infoSpider.getNovelInfo(novelUrl);
					System.out.println("BxwxNovelSpider's infoSpider.getNovelInfo(novelUrl) is going");
					System.out.println("BxwxNovelSpider's novelInfo = "+novelInfo);
					novel.setNovelInfo(novelInfo);
					
					novel.setNovelUrl(novelUrl);
					novel.setLastUpdateChapter(tds.get(1).text());
					String result = tds.get(1).getElementsByTag("a").first().absUrl("href");
					novel.setLastUpdateChapterUrl(result);
					novel.setAuthor(tds.get(2).text());
					
					novel.setLastUpdateTime(NovelSpiderUtil.getDate(tds.get(4).text(), "yy-MM-dd"));//2016-10-14 yyyy-MM-dd
					novel.setStatus(NovelSpiderUtil.getNovelStatus(tds.get(5).text()));
					novel.setPlatformId(NovelSiteEnum.getEnumByUrl(url).getId());
					
					
					String firstUrl = super.crawl(result);
					System.out.println("BxwxNovelSpider's firstUrl = "+firstUrl.substring(0,30));
					Document doc = Jsoup.parse(firstUrl);
					doc.setBaseUri(url);
					//Map<String, String> contexts = NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(firstUrl));
					Map<String, String> contexts = NovelSpiderUtil.getContext(NovelSiteEnum.Bxwx);
					String contentSelector = contexts.get("chapter-list-selector");
						System.out.println("BxwxNovelSpider's contentSelector ="+contentSelector);
					String first = result.replace("index.html", "");
						System.out.println("BxwxNovelSpider's first ="+first);
					String firstContentUrl = first+doc.select(contentSelector).get(1).absUrl("href").replace("https://www.bxwx9.org/bsort/0/", "");
						System.out.println("BxwxNovelSpider's firstContentUrl"+firstContentUrl);
					novel.setFirstcontenturl(firstContentUrl);
					System.out.println("novel.setFirstcontenturl成功");
				
					
					
					novels.add(novel);
					//System.out.println("novel 的值"+novels.toString());
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return novels;
	}
}
