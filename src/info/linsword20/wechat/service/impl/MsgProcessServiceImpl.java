package info.linsword20.wechat.service.impl;

import info.linsword20.wechat.bean.message.BaseMessage;
import info.linsword20.wechat.bean.message.RecvMessage;
import info.linsword20.wechat.service.MsgProcessService;
import info.linsword20.wechat.service.NewsResponseService;
import info.linsword20.wechat.service.TextResponseService;
import info.linsword20.wechat.util.XmlGenerator;
import info.linsword20.wechat.util.XmlParser;


/**
 * 消息处理类
 * 
 * @author Jason
 * 
 */
public class MsgProcessServiceImpl implements MsgProcessService
{

	private TextResponseService textResponserService;
	private NewsResponseService newsResponseService;

	public TextResponseService getTextResponserService()
	{
		return textResponserService;
	}

	public void setTextResponserService(TextResponseService textResponserService)
	{
		this.textResponserService = textResponserService;
	}

	
	public NewsResponseService getNewsResponseService()
	{
		return newsResponseService;
	}

	public void setNewsResponseService(NewsResponseService newsResponseService)
	{
		this.newsResponseService = newsResponseService;
	}

	/**
	 * 接收XML,调用成员msgHandleService完成处理,返回XML
	 */
	public String exectue(String recvXml) throws Exception
	{
		// 接收的XML消息转换为消息对象
		BaseMessage recvMsg = XmlParser.parseXml(recvXml);

		// 对消息对象的处理
		BaseMessage respMsg = processMsg(recvMsg);

		// 回复对象转换为成XML消息
		String respXml = XmlGenerator.generateXml(respMsg);

		return respXml;
	}
	/*
	 * 针对不同的消息类型，分别处理
	 */
	private BaseMessage processMsg(BaseMessage msg)
	{
		RecvMessage recvMsg = (RecvMessage) msg;
		String msgType = recvMsg.getMsgType();

		if ("location".equals(msgType))
		{
			return processLocationMsg(recvMsg);
		}
		else if ("text".equals(msgType))
		{
			return processTextMsg(recvMsg);
		}
		else if ("image".equals(msgType))
		{
			return processImageMsg(recvMsg);
		}
		else if ("link".equals(msgType))
		{
			return processLinkMsg(recvMsg);
		}
		else if ("event".equals(msgType))
		{
			return processEventMsg(recvMsg);
		}
		else
		{
			return processUnknowMsg(recvMsg);
		}

	}

	// 针对文本消息的处理
	private BaseMessage processTextMsg(RecvMessage recvMsg)
	{
		String content = recvMsg.getContent();
		String ToUserName = recvMsg.getFromUserName();

		if(content.startsWith("天气") || "blog".equals(content))
		{
			return this.newsResponseService.NewsMsgExtract(content, ToUserName);
		}
		
		/*
		 * 默认回复文本消息
		 */
		else
		{
			return this.textResponserService
					.textMsgExtract(content, ToUserName);
		}
	}

	private BaseMessage processImageMsg(RecvMessage recvMsg)
	{
		return null;
	}

	private BaseMessage processLinkMsg(RecvMessage recvMsg)
	{
		return null;
	}

	private BaseMessage processEventMsg(RecvMessage recvMsg)
	{

		String content = recvMsg.getContent();
		String ToUserName = recvMsg.getFromUserName();
		//在没有其他功能情况下,默认回复文本消息
		return	this.textResponserService.textMsgExtract(content, ToUserName);
		

	}

	private BaseMessage processLocationMsg(RecvMessage recvMsg)
	{
		return null;
	}

	private BaseMessage processUnknowMsg(RecvMessage recvMsg)
	{
		return null;
	}

}
