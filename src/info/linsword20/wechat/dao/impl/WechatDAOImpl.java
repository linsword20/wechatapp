package info.linsword20.wechat.dao.impl;

import info.linsword20.wechat.bean.message.NewsItem;
import info.linsword20.wechat.dao.WechatDAO;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class WechatDAOImpl extends HibernateDaoSupport implements WechatDAO
{

	@Override
	public void save(NewsItem newsItem)
	{
		this.getHibernateTemplate().save(newsItem);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NewsItem> getNewsItems()
	{
		List<NewsItem> items = this.getHibernateTemplate().find("from NewsItem order by id desc limit 5");
		return items;
	}
	
	
}
