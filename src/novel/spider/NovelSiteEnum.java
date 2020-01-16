package novel.spider;

/**
 * 已经被支持的小说网站枚举
 * @author chengxuguodu
 */
public enum NovelSiteEnum {
	DingDianXiaoShuo(3, "23wx.com"),
	BiQuGe(2, "www.xs.la"),
//	KanShuZhong(3, "kanshuzhong.com"),
	Bxwx(1, "bxwx9.org");
	private int id;
	private String url;
	private NovelSiteEnum(int id, String url) {
		this.id = id;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public static NovelSiteEnum getEnumById(int id) {
		switch (id) {
		case 3 : return DingDianXiaoShuo;
		case 2 : return BiQuGe;
		case 1 : return Bxwx;
		default : throw new RuntimeException("id=" + id + "是不被支持的小说网站");
		}
	}
	public static NovelSiteEnum getEnumByUrl(String url) {
		System.out.println("NovelSiteEnum getEnumByUrl yunxingle");
		System.out.println("NovelSiteEnum url="+url);
		for (NovelSiteEnum novelSiteEnum : values()) {
//			if (url.contains(novelSiteEnum.url)) {
				
				
				
				
				//System.out.println("novelSiteEnum url = "+url.substring(0,20));
				System.out.println("novelSiteEnum ="+novelSiteEnum);
				novelSiteEnum = novelSiteEnum.Bxwx;
				return novelSiteEnum;
//			}
		}
		throw new RuntimeException("url=" + url.substring(0,33) + "是不被支持的小说网站");
	}
}
