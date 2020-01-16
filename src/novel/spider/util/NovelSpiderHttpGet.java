package novel.spider.util;

import java.net.URI;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;

public class NovelSpiderHttpGet extends HttpGet {

	public NovelSpiderHttpGet() {
	}

	public NovelSpiderHttpGet(URI uri) {
		super(uri);
	}

	public NovelSpiderHttpGet(String uri) {
		
		super(uri);
		System.out.println("NovelSpiderHttpGet.NovelSpiderHttpGet.uri="+uri);
		setDefaultConfig();
	}
	
	/**
	 * ����Ĭ�ϵ��������
	 */
	private void setDefaultConfig() {
		this.setConfig(RequestConfig.custom()
				.setSocketTimeout(20_000)
				.setConnectTimeout(10_000)	//�������ӷ������ĳ�ʱʱ�� Ĭ��10000
				.setConnectionRequestTimeout(20_000)	//���ôӷ�������ȡ���ݵĳ�ʱʱ��
				.build());
		this.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");//��������ͷ
	}

}
