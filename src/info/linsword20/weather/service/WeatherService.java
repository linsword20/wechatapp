package info.linsword20.weather.service;

import info.linsword20.weather.bean.WeatherInfo;

import java.util.Map;

public interface WeatherService
{
	public  Map<Integer, WeatherInfo> excute(String city);
}
