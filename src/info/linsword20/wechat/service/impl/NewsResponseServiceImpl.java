package info.linsword20.wechat.service.impl;

import info.linsword20.weather.bean.WeatherInfo;
import info.linsword20.weather.service.WeatherService;
import info.linsword20.wechat.bean.message.BaseMessage;
import info.linsword20.wechat.bean.message.NewsItem;
import info.linsword20.wechat.bean.message.NewsMessage;
import info.linsword20.wechat.service.NewsResponseService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class NewsResponseServiceImpl implements NewsResponseService
{
	private final String MYID = "gh_6c458f5eba1a";

	private WeatherService weatherService;

	public WeatherService getWeatherService()
	{
		return weatherService;
	}

	public void setWeatherService(WeatherService weatherService)
	{
		this.weatherService = weatherService;
	}

	@Override
	public BaseMessage NewsMsgExtract(String content, String ToUserName)
	{
		NewsMessage newsRespMsg = new NewsMessage();

		newsRespMsg.setToUserName(ToUserName);
		newsRespMsg.setFromUserName(MYID);
		newsRespMsg.setCreateTime(new Date().getTime() + "");
		newsRespMsg.setMsgType("news");

		ArrayList<NewsItem> items = new ArrayList<NewsItem>();

		if (content.startsWith("天气"))
		{
			Map<Integer, WeatherInfo> weatherInfo = this.weatherService
					.excute(content.substring(2));
			if (null == weatherInfo)
			{
				return new TextResponseServiceImpl().textMsgExtract("error",
						ToUserName);
			}
			StringBuffer str1 = new StringBuffer();
			StringBuffer str2 = new StringBuffer();
			StringBuffer str3 = new StringBuffer();
			str1.append(weatherInfo.get(1).getDate()).append("\n").append(
					weatherInfo.get(1).getWeather()).append(
					weatherInfo.get(1).getTemp()).append("  ").append(
					weatherInfo.get(1).getWind());
			str2.append(weatherInfo.get(2).getDate()).append("\n").append(
					weatherInfo.get(2).getWeather()).append(
					weatherInfo.get(2).getTemp()).append("  ").append(
					weatherInfo.get(2).getWind());
			str3.append(weatherInfo.get(3).getDate()).append("\n").append(
					weatherInfo.get(3).getWeather()).append(
					weatherInfo.get(3).getTemp()).append("  ").append(
					weatherInfo.get(3).getWind());

			items.add(new NewsItem().setTitle(str1.toString()).setPicUrl(
					"http://linsword20.vicp.cc/weixin/media/weather_bg.jpg"));
			items.add(new NewsItem().setTitle(str2.toString()));
			items.add(new NewsItem().setTitle(str3.toString()));

			newsRespMsg.setArticleCount(3);
		}
		if ("blog".equals(content))
		{
			items.add(new NewsItem().setDescription(
					"在编写java代码的时候经常会遇到java.lang.ClassNotFoundExcetpion，它涉及到了java的类加载器概念。").setTitle(
					"浅析Java类加载器").setPicUrl(
					"http://blog.linsword20.info/media/images/classloader.jpg")
					.setUrl("http://blog.linsword20.info/2013/08/Java-ClassLoader/"));
			
			newsRespMsg.setArticleCount(1);

		}

		newsRespMsg.setItems(items);
		return newsRespMsg;
	}
}
