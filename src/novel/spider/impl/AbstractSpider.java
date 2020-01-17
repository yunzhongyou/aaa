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
	 * ץȡָ��С˵��վ������
	 * @param url
	 * @return
	 * @throws Exception
	 */
	protected String crawl(String url) throws Exception {
		System.out.println("AbstractSpider crawl is going on,url = "+url);
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			CloseableHttpResponse httpResponse = httpClient.execute(new NovelSpiderHttpGet(url))) {
			
			System.out.println("δִ�л�ִ��ʱ����AbstractSpider's crawl ������ ,ִ���� NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url)) ");
			System.out.println("AbstractSpider's crawl NovelSpiderUtil.getContext��ֵ ====="+NovelSpiderUtil.getContext(NovelSiteEnum.Bxwx).get("charset"));
			//String result = EntityUtils.toString(httpResponse.getEntity(), NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url)).get("charset"));
			String result = EntityUtils.toString(httpResponse.getEntity(), NovelSpiderUtil.getContext(NovelSiteEnum.Bxwx).get("charset"));
			String resultSUB= result.substring(0,10);
			System.out.println("AbstractSpider's crawl ������ ,ִ���� NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url)) ");
			System.out.println("AbstractSpider's crawl ������ ,result���� =*************************** "+resultSUB);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}


}
