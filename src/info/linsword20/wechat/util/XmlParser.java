package info.linsword20.wechat.util;

import info.linsword20.wechat.bean.message.BaseMessage;
import info.linsword20.wechat.bean.message.RecvMessage;

import java.lang.reflect.Method;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class XmlParser
{
	/**
	 * 解析XML消息，存入map
	 * 
	 * @param xmlData
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public static BaseMessage parseXml(String xmlData)
	{
		Document document = null;
		/*
		 *利用反射，将xml消息set入bean 
		 */
		try
		{
			Class clazz = Class
					.forName("info.linsword20.wechat.bean.message.RecvMessage");
			RecvMessage recvMsg = (RecvMessage) clazz.getConstructor(
					new Class[]
					{}).newInstance(new Object[]
			{});

			document = DocumentHelper.parseText(xmlData);

			Element root = document.getRootElement();
			List<Element> list = root.elements();
			for (Element e : list)
			{
				
				String methodName = "set" + e.getName();
				Method method = clazz.getMethod(methodName, String.class);
				method.invoke(recvMsg, e.getText());
			}
			
			return recvMsg;

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
