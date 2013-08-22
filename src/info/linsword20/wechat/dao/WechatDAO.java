package info.linsword20.wechat.dao;

import info.linsword20.wechat.bean.message.NewsItem;

import java.util.List;

public interface WechatDAO
{
	public void save(NewsItem newsItem);
	
	public List<NewsItem> getNewsItems();
}
