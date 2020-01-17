package novel.spider.impl.chapter;

import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import novel.model.ChapterDetail;
import novel.spider.NovelSiteEnum;
import novel.spider.impl.AbstractSpider;
import novel.spider.interfaces.IChapterDetailSpider;
import novel.spider.util.NovelSpiderUtil;

public abstract class AbstractChapterDetailSpider extends AbstractSpider implements IChapterDetailSpider{
	
	@Override
	public ChapterDetail getChapterDetail(String url) {
		try {
			System.out.println("AbstractChapterDetailSpider 's  getChapterDetail is going on");
			String result = super.crawl(url);
			System.out.println("String result = super.crawl(url); 运行成功");
			result = result.replace("&nbsp;", " ").replace("<br />", "${line}").replace("<br/>", "${line}");
			Document doc = Jsoup.parse(result);
			doc.setBaseUri(url);
			Map<String, String> contexts = NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url));
			
			
			System.out.println("开始拿标题内容**************");
			//拿标题内容
			String titleSelector = contexts.get("chapter-detail-title-selector");
			System.out.println("titleSelector="+titleSelector);
			String[] splits = titleSelector.split("\\,");
			System.out.println("splits="+splits);
			splits = parseSelector(splits);
			ChapterDetail detail = new ChapterDetail();
		
			detail.setTitle(doc.select(splits[0]).get(Integer.parseInt(splits[1])).text());
//			System.out.println("detail="+detail);
			
			System.out.println("开始拿章节内容**************");
			//拿章节内容
			String contentSelector = contexts.get("chapter-detail-content-selector");
			detail.setContent(doc.select(contentSelector).first().text().replace("${line}", "\n"));
			
			
			System.out.println("开始拿前一章的地址**************");
			//拿前一章的地址ַ
			String prevSelector = contexts.get("chapter-detail-prev-selector");
			splits = prevSelector.split("\\,");
			splits = parseSelector(splits);
			detail.setPrev(doc.select(splits[0]).get(Integer.parseInt(splits[1])).absUrl("href"));
			
			
			System.out.println("开始拿后一章的地址**************");
			//拿后一章的地址ַ
			String nextSelector = contexts.get("chapter-detail-next-selector");
			splits = nextSelector.split("\\,");
			splits = parseSelector(splits);
			detail.setNext(doc.select(splits[0]).get(Integer.parseInt(splits[1])).absUrl("href"));
			
			return detail;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 处理具体元素的下标索引
	 */
	private String[] parseSelector(String[] splits) {
		
		
		System.out.println("AbstractChapterDetailSpider parseSelector 运行了， splits==="+splits);
		
		String[] newSplits = new String[2];
		if (splits.length == 1) {
			System.out.println("split拥有长度");
			newSplits[0] = splits[0];
			newSplits[1] = "0";
			return newSplits;
		} else {
			return splits;
		}
	}

}
