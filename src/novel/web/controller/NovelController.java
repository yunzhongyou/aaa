package novel.web.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import novel.model.ChapterDetail;
import novel.spider.util.ChapterDetailSpiderFactory;
import novel.spider.util.ChapterSpiderFactory;
import novel.spider.util.NovelSpiderUtil;
import novel.web.service.NovelService;

@Controller
@RequestMapping("/novel")
public class NovelController {
	
	@Resource
	private NovelService service;
	
	/**
	 *С˵��վ������������
	 */
		static {
			//NovelSpiderUtil.setConfPath("H:\\Program Files\\tomcat\\webapps\\ssm18\\WEB-INF\\classes\\conf\\SqlMapConfig.xml");
			
		}


	/**
	 * ��ת����ҳ
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView Index(ModelAndView model) {
		System.out.println("NovelController ModelAndView Index������");
		model =new ModelAndView(new MappingJackson2JsonView());
		model.addObject("UrbanNovel", service.findUrbanLimitNovel());
		model.addObject("FantasyMagic", service.findFantasyMagicLimitNovel());
		model.addObject("Comprehension", service.findComprehensionLimitNovel());
		
		model.addObject("ScienceFiction", service.findScienceFictionLimitNovel());
		model.addObject("Horror", service.findHorrorLimitNovel());
		model.addObject("OnlineGame", service.findOnlineGameLimitNovel());
		model.addObject("Historical", service.findHistoricalLimitNovel());
		model.addObject("Other", service.findOtherLimitNovel());
		
		
		//model.setViewName("3g/index");
		System.out.println("model = "+model);
		return model;
	}

	/**
	 * ��ת������С˵
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/urbanNovel.do", method = RequestMethod.GET)
	public ModelAndView UrbanNovel(ModelAndView model) {
		model =new ModelAndView(new MappingJackson2JsonView());
		//model.addObject("UrbanNovel", service.findUrbanNovel());
		model.addObject("Subjects", service.findUrbanNovel());
		//model.setViewName("3g/section/urbanNovel");
		System.out.println("model = "+model);
		return model;
	}

	/**
	 * ��ת������ħ��
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/fantasyMagic.do", method = RequestMethod.GET)
	public ModelAndView FantasyMagic(ModelAndView model) {
		model =new ModelAndView(new MappingJackson2JsonView());
		//model.addObject("FantasyMagic", service.findFantasyMagicNovel());
		model.addObject("Subjects", service.findFantasyMagicNovel());
		//model.setViewName("3g/section/fantasyMagic");
		return model;
	}
	/**
	 * ��ת����������
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/comprehension.do", method = RequestMethod.GET)
	public ModelAndView Comprehension(ModelAndView model) {
		model =new ModelAndView(new MappingJackson2JsonView());
		//model.addObject("Comprehension", service.findComprehensionNovel());
		model.addObject("Subjects", service.findComprehensionNovel());
		//model.setViewName("3g/section/comprehension");
		return model;
	}
	/**
	 * ��ת���ƻ�����
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/scienceFiction.do", method = RequestMethod.GET)
	public ModelAndView ScienceFiction(ModelAndView model) {
		model =new ModelAndView(new MappingJackson2JsonView());
		model.addObject("ScienceFiction", service.findScienceFictionNovel());
		//model.setViewName("3g/section/scienceFiction");
		return model;
	}
	/**
	 * ��ת���ֲ����
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/horror.do", method = RequestMethod.GET)
	public ModelAndView Horror(ModelAndView model) {
		model =new ModelAndView(new MappingJackson2JsonView());
		model.addObject("Horror", service.findHorrorNovel());
		//model.setViewName("3g/section/horror");
		return model;
	}
	/**
	 * ��ת�����ξ���
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/onlineGame.do", method = RequestMethod.GET)
	public ModelAndView OnlineGame(ModelAndView model) {
		model.addObject("OnlineGame", service.findOnlineGameNovel());
		model.setViewName("/section/onlineGame");
		return model;
	}
	/**
	 * ��ת����ʷ����
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/historical.do", method = RequestMethod.GET)
	public ModelAndView Historical(ModelAndView model) {
		model.addObject("Historical", service.findHistoricalNovel());
		model.setViewName("3g/section/historical");
		return model;
	}
	/**
	 * ��ת����������
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/other.do", method = RequestMethod.GET)
	public ModelAndView Other(ModelAndView model) {
		model=new ModelAndView(new MappingJackson2JsonView());
		model.addObject("Other", service.findOtherNovel());
		//model.setViewName("/section/other");
		return model;
	}


	/**
	 * ��ת����Ʒ���
	 * @param model
	 * @param id
	 * @return
	 */
	/** http://localhost:8080/ssm18/novel/novelInfo.do
	 * ?id=203677&baseUrl=http://www.bxwx8.la/b/5/5740/index.html**/
	@RequestMapping(value = "/novelInfo.do", method = RequestMethod.GET)
	public ModelAndView novelInfo(ModelAndView model, String id, String url) {
		model =new ModelAndView(new MappingJackson2JsonView());
		model.addObject("NovelInfo", service.findNovelInfo(id));

		//model.setViewName("/novelinfo/novelinfo"); //��ת�����ҳ���õġ�

		return model;
	}

	/**
	 * ����С˵
	 * @param keyword
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public ModelAndView getsNovelByKeyword(ModelAndView model, String kw) {
		System.out.println("kw="+kw);
//		if (kw == null ||kw == "") {
//			model.addObject("msg", "����Ϊ��");
//			model.setViewName("/section/searchnull");
//		}else {
		
		model =new ModelAndView(new MappingJackson2JsonView());
			model.addObject("NovelName", service.findNovelName(kw));
			//model.setViewName("/section/search");
//		}
		
		return model;
	}

	/**
	 * ��ת���½��б�
	 * @param url
	 * @return
	 */
	
	
//	ע�������õ���chapterUrl ����novelURL �����½ڻ��������
	
	/**http://localhost:8080/ssm18/novel/chapterList.do
	 * ?url=http://www.bxwx8.la/b/5/5740/index.html&name=Ԫ��&id=203677**/
	
	@RequestMapping(value = "/chapterList.do", method = RequestMethod.GET)
	public ModelAndView showChapterList(String url, String id) {
		System.out.println("chapterList.doyunxingle");
		System.out.println("url="+url+"*********"+"id="+id);
		ModelAndView view ;
		view= new ModelAndView(new MappingJackson2JsonView());
		
//		/novel/chapterDetail.do?url=${chapter.url }&baseUrl=${baseUrl }&id=${ChapterList.id}
		
		
		
		//view.setViewName("/chapter/chapterlist");
		
		
		
		view.addObject("ChapterList", service.findNovelInfo(id));
		ModelAndView model1=new ModelAndView();
		model1 = view;
		System.out.println("****************"+model1.toString());
		
		view.getModel().put("chapters", ChapterSpiderFactory.getChapterSpider(url).getChapters(url));
		
		view.getModel().put("baseUrl", url);
		return view;
	}

	/**
	 * ��ת�����Ķ�
	 * @param url
	 * @return
	 */
	@RequestMapping(value = "/nowRead.do", method = RequestMethod.GET)
	public ModelAndView nowRead(String url, String id, String baseUrl) {
		System.out.println("��ת�����Ķ� id="+id);
		ModelAndView view = new ModelAndView();
		view.setViewName("/content/nowReadContent");
		view.addObject("nowReadName", service.findNovelInfo(id));
		try {
			ChapterDetail detail = ChapterDetailSpiderFactory.getsChapterDetailSpider(url).getChapterDetail(url);
			System.out.println("ModelAndView nowRead -----------detail="+detail.toString());
			detail.setContent(detail.getContent().replaceAll("\n", "<br>"));
			view.getModel().put("chapterDetail", detail);
			view.getModel().put("isSuccess", true);
		} catch (Exception e) {
			e.printStackTrace();
			view.getModel().put("isSuccess", false);
		}
		view.getModel().put("baseUrl", baseUrl);
		return view;
	}

	/**
	 * ��ת���Ķ�����ҳ��
	 * @param url
	 * @param baseUrl
	 * @return
	 */
	@RequestMapping(value = "/chapterDetail.do", method = RequestMethod.GET)
	public ModelAndView showChapterDetail(String url, String id, String baseUrl) {
		/**
		 * http://localhost:8080/ssm18/novel/chapterDetail.do
		 * ?url=http://www.bxwx8.la/b/5/5740/43095181.html&baseUrl=http://www.bxwx8.la/b/5/5740/index.html&id=203677
		 * **/
		ModelAndView view = new ModelAndView(new MappingJackson2JsonView());
		//view.setViewName("/content/content");
		view.addObject("ChapterDetailName", service.findNovelInfo(id));
		try {
			ChapterDetail detail = ChapterDetailSpiderFactory.getsChapterDetailSpider(url).getChapterDetail(url);
			System.out.println("noverController ChapterDetail ���гɹ���");
			detail.setContent(detail.getContent().replaceAll("\n", "<br>"));
			view.getModel().put("chapterDetail", detail);
			view.getModel().put("isSuccess", true);
		} catch (Exception e) {
			e.printStackTrace();
			view.getModel().put("isSuccess", false);
		}
		view.getModel().put("baseUrl", baseUrl);
		return view;
	}
}
