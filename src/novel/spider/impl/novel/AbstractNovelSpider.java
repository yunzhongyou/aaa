package novel.spider.impl.novel;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import novel.model.Novel;
import novel.spider.NovelSiteEnum;
import novel.spider.impl.AbstractSpider;
import novel.spider.interfaces.INovelSpider;
import novel.spider.util.NovelSpiderUtil;

/**
 * һ�������С˵�б�ץȡ���Ѿ�ʵ���˽���trԪ�صķ���
 */
public abstract class AbstractNovelSpider extends AbstractSpider implements INovelSpider {
	protected Element nextPageElement;
	/** ��һҳ��url */
	protected String nextPage;
	/**
	 * Ĭ�ϵ�ץȡ���������᳢�� {@link INovelSpider#MAX_TRY_TIMES} ������
	 * @param url
	 * @return
	 * @throws Exception
	 */
	protected Elements getsTr(String url) throws Exception {
		return getsTr(url, INovelSpider.MAX_TRY_TIMES);
	}
	/**
	 * ��ָ����������ʽȥ������Ӧ��ҳ
	 * @param url
	 * @param maxTryTimes ���Ϊnull�� �� Ĭ���� {@link INovelSpider#MAX_TRY_TIMES}
	 * @return
	 * @throws Exception
	 */
	protected Elements getsTr(String url, Integer maxTryTimes) throws Exception {
		System.out.println("AbstractNovelSpider 's getsTr is going on");
		maxTryTimes = maxTryTimes == null ? INovelSpider.MAX_TRY_TIMES : maxTryTimes;
		Elements trs = null;
		for (int i = 0; i < maxTryTimes ; i++) {
			try {
					System.out.println("AbstractNovelSpider 's ִ����String result = super.crawl(url)"+i+"��");
				String result = super.crawl(url);
				String resultSub= result.substring(0,10);
					System.out.println("AbstractNovelSpider 's getsTr's  crawl 's result����=" +resultSub);
				Map<String, String> context = NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url));
					System.out.println("AbstractNovelSpider 's context= "+context);
				String novelSelector = context.get("novel-selector");
					System.out.println("AbstractNovelSpider 's novelSelector= "+novelSelector);
				if (novelSelector == null) throw new RuntimeException(NovelSiteEnum.getEnumByUrl(url).getUrl() + ",url=" + url + "Ŀǰ��֧��ץȡС˵�б�");
				Document doc = Jsoup.parse(result);
				doc.setBaseUri(url);
				trs = doc.select(novelSelector);
					System.out.println("AbstractNovelSpider 's trs= "+trs.toString().substring(0,20));
				
				String nextPageSelector = context.get("novel-next-page-selector");
					System.out.println("AbstractNovelSpider 's nextPageSelector= "+nextPageSelector);
				if (nextPageSelector != null) {
					Elements nextPageElements = doc.select(nextPageSelector);
					nextPageElement = nextPageElements == null ? null : nextPageElements.first();
					
					if (nextPageElement != null) {
						nextPage = nextPageElement.absUrl("href");
					} else {
						nextPage = "";
					}
					System.out.println("AbstractNovelSpider 's nextPage= "+nextPage);
				}
				return trs;
			} catch (Exception e) {
				
			}
		}
		throw new RuntimeException(url + ",������" + maxTryTimes + "����Ȼ����ʧ���ˣ�");
	}
	
	@Override
	public boolean hasNext() {
		return !nextPage.isEmpty();
	}

	@Override
	public String next() {
		return nextPage;
	}
	@Override
	public Iterator<List<Novel>> iterator(String firstPage, Integer maxTryTimes) {
		nextPage = firstPage;
		return new NovelIterator(maxTryTimes);
	}
	/**
	 * һ����������ר�����ڶ�С˵��վ�����б�ץȡ
	 */
	private class NovelIterator implements Iterator<List<Novel>> {
		private Integer maxTryTimes;
		public NovelIterator(Integer maxTryTimes) {
			this.maxTryTimes = maxTryTimes;
		}
		@Override
		public boolean hasNext() {
			return AbstractNovelSpider.this.hasNext();
		}
		@Override
		public List<Novel> next() {
			System.out.println("AbstractNovelSpider's List<Novel> next() is going on");
			List<Novel> novels = getsNovel(nextPage, maxTryTimes);
			System.out.println("AbstractNovelSpider's  getsNovel �ɹ� ");
			return novels;
		}
	}
}
