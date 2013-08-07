package info.linsword20.wechat.service;

import info.linsword20.wechat.bean.message.BaseMessage;

public interface TextResponseService
{
	public BaseMessage textMsgExtract(String content,String ToUserName);
}
