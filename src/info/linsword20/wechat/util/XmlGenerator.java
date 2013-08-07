package info.linsword20.wechat.util;

import info.linsword20.wechat.bean.message.BaseMessage;
import info.linsword20.wechat.bean.message.MusicMessage;
import info.linsword20.wechat.bean.message.NewsMessage;
import info.linsword20.wechat.bean.message.TextMessage;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


/**
 * 产生响应xml
 * 
 * @author Jason
 * 
 */
public class XmlGenerator
{
	/**
	 * 产生String类型的XML字符串
	 * 
	 * @param map
	 * @return
	 */
	public static String generateXml(BaseMessage msg)
	{
		if (null == msg)
		{
			return null;
		}

		String msgType = msg.getMsgType();

		// 图文消息
		if ("news".equals(msgType))
		{
			NewsMessage respMsg = (NewsMessage) msg;
			return genNewsXml(respMsg);
		}
		// 音乐消息
		else if ("music".equals(msgType))
		{
			MusicMessage respMsg = (MusicMessage) msg;
			return genMusicXml(respMsg);
		}
		// 普通消息
		else
		{
			TextMessage respMsg = (TextMessage) msg;
			return genTextXml(respMsg);
		}
	}

	private static String genNewsXml(NewsMessage respMsg)
	{
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("utf-8");
		Element root = document.addElement("xml");

		root.addElement("ToUserName").addText(respMsg.getToUserName());
		root.addElement("FromUserName").addText(respMsg.getFromUserName());
		root.addElement("CreateTime").addText(respMsg.getCreateTime());
		root.addElement("MsgType").addText(respMsg.getMsgType());

		root.addElement("ArticleCount").addText(
				respMsg.getArticleCount().toString());

		Element articles = root.addElement("Articles");

		for (int i = 0; i < respMsg.getArticleCount(); i++)
		{
			// 生成消息节点
			Element itme = articles.addElement("item");

			itme.addElement("Title").addText(
					respMsg.getItems().get(i).getTitle());
			itme.addElement("Description").addText(
					respMsg.getItems().get(i).getDescription());
			itme.addElement("PicUrl").addText(
					respMsg.getItems().get(i).getPicUrl());
			itme.addElement("Url").addText(respMsg.getItems().get(i).getUrl());
		}

		String xml = document.getRootElement().asXML();
		return xml;
	}

	private static String genMusicXml(MusicMessage respMsg)
	{
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("utf-8");
		Element root = document.addElement("xml");

		root.addElement("ToUserName").addText(respMsg.getToUserName());
		root.addElement("FromUserName").addText(respMsg.getFromUserName());
		root.addElement("CreateTime").addText(respMsg.getCreateTime());
		root.addElement("MsgType").addText(respMsg.getMsgType());
		Element music = root.addElement("Music");

		music.addElement("Title").addText(respMsg.getTitle());
		music.addElement("Description").addText(respMsg.getDescription());
		music.addElement("MusicUrl").addText(respMsg.getMusicUrl());
		music.addElement("HQMusicUrl").addText(respMsg.getHQMusicUrl());

		String xml = document.getRootElement().asXML();

		return xml;
	}

	private static String genTextXml(TextMessage respMsg)
	{
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("utf-8");
		Element root = document.addElement("xml");

		root.addElement("ToUserName").addText(respMsg.getToUserName());
		root.addElement("FromUserName").addText(respMsg.getFromUserName());
		root.addElement("CreateTime").addText(respMsg.getCreateTime());
		root.addElement("Content").addText(respMsg.getContent());
		root.addElement("MsgType").addText(respMsg.getMsgType());

		String xml = document.getRootElement().asXML();

		return xml;
	}
}
