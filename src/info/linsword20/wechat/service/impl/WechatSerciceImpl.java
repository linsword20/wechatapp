package info.linsword20.wechat.service.impl;

import info.linsword20.wechat.bean.message.NewsItem;
import info.linsword20.wechat.dao.WechatDAO;
import info.linsword20.wechat.service.WechatService;

public class WechatSerciceImpl implements WechatService
{
	private WechatDAO wechatDao;
	
	public WechatDAO getWechatDao()
	{
		return wechatDao;
	}

	public void setWechatDao(WechatDAO wechatDao)
	{
		this.wechatDao = wechatDao;
	}


	@Override
	public void save(NewsItem newsItem)
	{
		this.wechatDao.save(newsItem);
	}

}
