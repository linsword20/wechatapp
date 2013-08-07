package info.linsword20.weather.bean;

public class WeatherInfo
{
	private String date;
	
	private String temp;
	
	private String weather;

	private String wind;

	public String getDate()
	{
		return date;
	}

	public WeatherInfo setDate(String date)
	{
		this.date = date;
		return this;
	}

	public String getTemp()
	{
		return temp;
	}

	public WeatherInfo setTemp(String temp)
	{
		this.temp = temp;
		return this;
	}

	public String getWeather()
	{
		return weather;
	}

	public WeatherInfo setWeather(String weather)
	{
		this.weather = weather;
		return this;
	}

	public String getWind()
	{
		return wind;
	}

	public WeatherInfo setWind(String wind)
	{
		this.wind = wind;
		return this;
	}
}
