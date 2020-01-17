package novel.spider.impl;

import java.util.List;



import org.apache.http.client.methods.CloseableHttpResponse;

import org.apache.http.util.EntityUtils;
import org.apache.http.client.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import novel.model.Chapter;
import novel.spider.NovelSiteEnum;
import novel.spider.util.NovelSpiderHttpGet;
import novel.spider.util.NovelSpiderUtil;

public abstract class AbstractSpider {
	
	
	/**
	 * 抓取指定小说网站的内容
	 * @param url
	 * @return
	 * @throws Exception
	 */
	protected String crawl(String url) throws Exception {
		System.out.println("AbstractSpider crawl is going on,url = "+url);
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			CloseableHttpResponse httpResponse = httpClient.execute(new NovelSpiderHttpGet(url))) {
			
			System.out.println("未执行或执行时出错AbstractSpider's crawl 运行了 ,执行了 NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url)) ");
			System.out.println("AbstractSpider's crawl NovelSpiderUtil.getContext的值 ====="+NovelSpiderUtil.getContext(NovelSiteEnum.Bxwx).get("charset"));
			//String result = EntityUtils.toString(httpResponse.getEntity(), NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url)).get("charset"));
			String result = EntityUtils.toString(httpResponse.getEntity(), NovelSpiderUtil.getContext(NovelSiteEnum.Bxwx).get("charset"));
			String resultSUB= result.substring(0,10);
			System.out.println("AbstractSpider's crawl 运行了 ,执行了 NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url)) ");
			System.out.println("AbstractSpider's crawl 运行了 ,result精简 =*************************** "+resultSUB);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}


}
