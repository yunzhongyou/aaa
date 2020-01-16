package novel.storage.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import novel.dao.NovelMapper;
import novel.model.Novel;
import novel.spider.interfaces.INovelSpider;
import novel.spider.util.NovelSpiderFactory;
import novel.storage.Processor;

public abstract class AbstractNovelStorage implements Processor {
	protected SqlSessionFactory sqlSessionFactory;
	protected Map<String, String> tasks = new TreeMap<>();
	public AbstractNovelStorage() throws FileNotFoundException {
		//�ϴ���Linux������    /usr/local/tomcat/app/conf/SqlMapConfig.xml
		//�ڱ��ط�����   /conf/SqlMapConfig.xml
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream("E:\\apache-tomcat-7.0.92\\webapps\\ssm18\\WEB-INF\\classes\\conf\\SqlMapConfig.xml"));
	}
	
	public AbstractNovelStorage(String confPath) throws FileNotFoundException {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream(confPath));
	}
	
	@Override
	public void process() {
		System.out.println("AbstractNovelStorage 's process is going on ");
		ExecutorService service = Executors.newFixedThreadPool(tasks.size());
		List<Future<String>> futures = new ArrayList<>(tasks.size());
		for (Entry<String, String> entry : tasks.entrySet()) {
			final String key = entry.getKey();
			final String value = entry.getValue();
			//value = ��ȡ����ַ
			
			futures.add(service.submit(new Callable<String> () {
				@Override
				public String call() throws Exception {
						System.out.println("AbstractNovelStorage 's call() is going on");
						System.out.println("��һ��ִ��AbstractNovelStorage 's call() NovelSpiderFactory.getNovelSpider");
					INovelSpider spider = NovelSpiderFactory.getNovelSpider(value);
						System.out.println("AbstractNovelStorage 's spider.iterator isgoing  spider="+spider.toString());
					
						System.out.println("AbstractNovelStorage 's call() NovelSpiderFactory.getNovelSpider  is going on");
					Iterator<List<Novel>> iterator = spider.iterator(value, 10);
					
					
						System.out.println("AbstractNovelStorage 's iterator ="+iterator.toString());
					while (iterator.hasNext()) {
						
						System.out.println("AbstractNovelStorage  ��ʼץȡ[" + key + "] �� URL:" + spider.next());
						List<Novel> novels = iterator.next();
						for (Novel novel : novels) {
							novel.setFirstLetter(key.charAt(0)+"");	//����С˵�����ֵ�����ĸ
							System.out.println(novel.getAuthor()+"novel.getauthor AbstractNovelStorage is going on");
						}
						SqlSession session = sqlSessionFactory.openSession();
//						session.insert("batchInsert", novels);
						session.getMapper(NovelMapper.class).batchInsert(novels);
						System.out.println("AbstractNovelStorage �������ݿ�ɹ�");
						session.commit();
						session.close();
						Thread.sleep(1_000);
					}
					return key;
				}
				
			}));
		}
		service.shutdown();
		for (Future<String> future : futures) {
			try {
				System.out.println("AbstractNovelStorage  ץȡ[" + future.get() + "]������");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
