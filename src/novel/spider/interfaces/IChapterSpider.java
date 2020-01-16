package novel.spider.interfaces;

import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import novel.model.Chapter;

public interface IChapterSpider {
	/**
	 * ������һ��������url�����Ǿ͸��㷵�����е��½��б����ص��½��б��������˳���
	 * @param url
	 * @return
	 */
	public List<Chapter> getChapters(String url);
	/**
	 * ������һ��������url�����Ǿ͸��㷵��ĳ����
	 * @param url
	 * @return
	 */
	public List<Chapter> getChapters(String url,int offset,int length);
	
	public Elements getChapterElements(String url); 
	
	public Chapter getChapterFromElement(Element e);
	
	public List<Chapter>  getChapterFromElements(Elements e,int offset,int length);
}
