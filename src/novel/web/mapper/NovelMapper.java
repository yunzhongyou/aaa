package novel.web.mapper;

import java.util.List;

import novel.model.Novel;

public interface NovelMapper {
	/** 批量插入数据 */
	public void batchInsert(List<Novel> novels);

	/** 查找都市小说 */
	public List<Novel> findUrbanNovel();

	/** 根据id查找小说 */
	public Novel findNovelInfo(String id);

	/** 根据id查找小说的第一章节内容地址 */
	public Novel findNowRead(String id);

	/** 根据小说名字或作者查找小说 */
	public List<Novel> findNovelName(String kw);

	/** 查找玄幻魔法小说 */
	public List<Novel> findFantasyMagicNovel();

	/** 查找仙侠修真小说 */
	public List<Novel> findComprehensionNovel();

	/** 查找都市言情5本小说 */
	public List<Novel> findUrbanLimitNovel();

	/** 查找玄幻魔法5本小说 */
	public List<Novel> findFantasyMagicLimitNovel();

	/** 查找仙侠修真5本小说 */
	public List<Novel> findComprehensionLimitNovel();

	/** 查找科幻灵异小说 */
	public List<Novel> findScienceFictionNovel();

	/** 查找恐怖惊悚小说 */
	public List<Novel> findHorrorNovel();

	/** 查找网游竞技小说 */
	public List<Novel> findOnlineGameNovel();

	/** 查找历史军事小说 */
	public List<Novel> findHistoricalNovel();

	/** 查找其他类型小说 */
	public List<Novel> findOtherNovel();
	/** 查找科幻灵异5本小说 */
	public List<Novel> findScienceFictionLimitNovel();
	/** 查找恐怖惊悚5本小说 */
	public List<Novel> findHorrorLimitNovel();
	/** 查找网游竞技5本小说 */
	public List<Novel> findOnlineGameLimitNovel();
	/** 查找历史军事5本小说 */
	public List<Novel> findHistoricalLimitNovel();
	/** 查找其他类型5本小说 */
	public List<Novel> findOtherLimitNovel();

}