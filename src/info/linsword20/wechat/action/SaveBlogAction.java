package info.linsword20.wechat.action;

import info.linsword20.todo.action.BaseAction;
import info.linsword20.wechat.bean.message.NewsItem;
import info.linsword20.wechat.service.WechatService;

public class SaveBlogAction extends BaseAction
{
	private static final long serialVersionUID = 1L;
	
	private NewsItem newsItem;

	private WechatService wechatService;
	
	public NewsItem getNewsItem()
	{
		return newsItem;
	}

	public void setNewsItem(NewsItem newsItem)
	{
		this.newsItem = newsItem;
	}
	
	public WechatService getWechatService()
	{
		return wechatService;
	}

	public void setWechatService(WechatService wechatService)
	{
		this.wechatService = wechatService;
	}

	@Override
	public String execute() throws Exception
	{
		if(null == this.newsItem)
			return INPUT;

		this.wechatService.save(this.newsItem);
		return SUCCESS;
	}
	
	
	
}
