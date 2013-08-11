package info.linsword20.weather.service.impl;

import info.linsword20.weather.bean.WeatherInfo;
import info.linsword20.weather.dao.CityInfoDAO;
import info.linsword20.weather.service.WeatherService;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class WeatherServiceImpl implements WeatherService
{
	private CityInfoDAO cityInfoDao;

	public CityInfoDAO getCityInfoDao()
	{
		return cityInfoDao;
	}

	public void setCityInfoDao(CityInfoDAO cityInfoDao)
	{
		this.cityInfoDao = cityInfoDao;
	}
	/**
	 * 获得对应城市天气json字符串
	 * @param city
	 * @return
	 * @throws Exception
	 */
	private String getWeatherInfo(String city) throws Exception
	{
		//查询数据库，获得城市代码
		String code = this.cityInfoDao.findBycity(city);
		if(null == code)
		{
			return null;
		}
		// 获取天气信息URL
		URL url = new URL("http://m.weather.com.cn/data/" + code + ".html");
		URLConnection conn = url.openConnection();
		InputStream inStream = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inStream,"utf-8"));
		StringBuffer sb = new StringBuffer();
		String data = null;
		while((data = br.readLine()) != null)
		{
			sb.append(data);
		}
		return sb.toString();
	}

	@SuppressWarnings("deprecation")
	private Map<Integer, WeatherInfo> parseWeacherInfo(String weaInfo)
	{
		if (weaInfo == null) // 天气信息为null，直接返回
		{
			return null;
		}
		else
		{
			/*
			 * 存储三天的天气信息对象，1、2、3分别表示今天、明天、后天
			 */
			Map<Integer, WeatherInfo> map = new HashMap<Integer, WeatherInfo>();
			WeatherInfo bean1 = new WeatherInfo();
			WeatherInfo bean2 = new WeatherInfo();
			WeatherInfo bean3 = new WeatherInfo();
			JSONObject json = new JSONObject(weaInfo)
					.getJSONObject("weatherinfo");
			Date date = new Date();
			String date0 = new SimpleDateFormat("MM月dd日   E").format(date);
			date.setDate(date.getDate() + 1);
			String date1 = new SimpleDateFormat("MM月dd日  E ").format(date);
			date.setDate(date.getDate() + 1);
			String date2 = new SimpleDateFormat("MM月dd日  E ").format(date);

			bean1.setDate(date0).setWeather(json.getString("weather1"))
					.setTemp(json.getString("temp1")).setWind(
							json.getString("wind1"));

			bean2.setDate(date1).setWeather(json.getString("weather2"))
					.setTemp(json.getString("temp2")).setWind(
							json.getString("wind2"));

			bean3.setDate(date2).setWeather(json.getString("weather3"))
					.setTemp(json.getString("temp3")).setWind(
							json.getString("wind3"));
			map.put(1, bean1);
			map.put(2, bean2);
			map.put(3, bean3);
			return map;
		}
	}
	public Map<Integer, WeatherInfo> excute(String city)
	{
		try
		{
			String weaInfo = getWeatherInfo(city);

			Map<Integer, WeatherInfo> map = parseWeacherInfo(weaInfo);
			if (null == map)
			{
				return null;
			}
			return map;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
}
