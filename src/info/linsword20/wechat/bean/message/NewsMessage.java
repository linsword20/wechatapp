package info.linsword20.wechat.bean.message;

import java.util.ArrayList;
/**
 * 图文消息
 * @author Jason
 *
 */

public class NewsMessage extends BaseMessage
{
	private Integer ArticleCount = 1;
	
	private ArrayList<NewsItem> items;

	
	
	public Integer getArticleCount()
	{
		return ArticleCount;
	}

	public void setArticleCount(Integer articleCount)
	{
		ArticleCount = articleCount;
	}

	public ArrayList<NewsItem> getItems()
	{
		return items;
	}

	public void setItems(ArrayList<NewsItem> items)
	{
		this.items = items;
	}
}
