package info.linsword20.wechat.service;

import info.linsword20.wechat.bean.message.BaseMessage;

public interface NewsResponseService
{
	public BaseMessage NewsMsgExtract(String content, String ToUserName);
}
