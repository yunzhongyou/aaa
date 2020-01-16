package novel.spider.interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import novel.model.Novel;

/**
 * ��ȡĳ��վ���С˵�б�
 */
public interface INovelSpider {
	/** ץȡĳһ��ҳ��ʱ���ĳ��Դ���3 */
	public static final int MAX_TRY_TIMES = 3;
	/**
	 * ����һ��URL���Ҿ͸���һ�ѵ�С˵ʵ��
	 * @param url
	 * @param maxTryTimes ��ҳ���ص�������������ʧ�����ԵĴ�����
	 * @return
	 */
	public List<Novel> getsNovel(String url, Integer maxTryTimes);
	public boolean hasNext();
	public String next();
	public Iterator<List<Novel>> iterator(String firstPage, Integer maxTryTimes);
	
//	List<Novel> novels = new ArrayList<>();
////    ����novels���кܶ��Ԫ��
//  for (int index = 0, size = novels.size(); index < size; index++) {
//  	System.out.println("��" + index + "��Ԫ���ǣ�" + novels.get(index));
//  }
	/**
	 * 
	 * for (Novel novel : novels) {
	 * 	System.out.println(novel);
	 * }
	 * Iterator<Novel> iterator = novels.iterator();
	 * while (iterator.hasNext()) {
	 * 	Novel novel = iterator.next();
	 * 	System.out.println(novel);
	 * }
	 * */
}
