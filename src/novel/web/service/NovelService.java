package novel.web.service;

import java.util.List;

import novel.model.Novel;

public interface NovelService {
	/**
	 * @param id
	 * @return
	 */
	public Novel findNovelInfo(String id);
	
	/**
	 * 根据id查找小说的第一章节内容地址
	 * @param id
	 * @return
	 */
	public Novel findNowRead(String id);
	
	/**
	 * 根据小说名字或者作者查找小说
	 * @param kw
	 * @return
	 */
	public List<Novel> findNovelName(String kw);
	/**
	 * 查找都市小说
	 * @return
	 */
	public List<Novel> findUrbanNovel();
	/**
	 * 查找玄幻魔法小说
	 * @return
	 */
	public List<Novel> findFantasyMagicNovel();
	/**
	 * 查找玄幻魔法小说
	 * @return
	 */
	public List<Novel> findComprehensionNovel();
	/**
	 * 查找都市言情5条小说
	 * @return
	 */
	public List<Novel> findUrbanLimitNovel();
	/**
	 * 查找玄幻魔法5条小说
	 * @return
	 */
	public List<Novel> findFantasyMagicLimitNovel();
	/**
	 * 查找仙侠修真5条小说
	 * @return
	 */
	public List<Novel> findComprehensionLimitNovel();
	/**
	 * 查找科幻灵异的小说
	 * @return
	 */
	public List<Novel> findScienceFictionNovel();
	/**
	 * 查找恐怖惊悚的小说
	 * @return
	 */
	public List<Novel> findHorrorNovel();
	/**
	 * 查找网游竞技的小说
	 * @return
	 */
	public List<Novel> findOnlineGameNovel();
	/**
	 * 查找网游竞技的小说
	 * @return
	 */
	public List<Novel> findHistoricalNovel();
	/**
	 * 查找其他类型的小说
	 * @return
	 */
	public List<Novel> findOtherNovel();
	/**
	 * 查找科幻灵异的5本小说
	 * @return
	 */
	public List<Novel> findScienceFictionLimitNovel();
	/**
	 * 查找恐怖惊悚的5本小说
	 * @return
	 */
	public List<Novel> findHorrorLimitNovel();
	/**
	 * 查找网游竞技的5本小说
	 * @return
	 */
	public List<Novel> findOnlineGameLimitNovel();
	/**
	 * 查找历史军事的5本小说
	 * @return
	 */
	public List<Novel> findHistoricalLimitNovel();
	/**
	 * 查找其他类型的5本小说
	 * @return
	 */
	public List<Novel> findOtherLimitNovel();

}
