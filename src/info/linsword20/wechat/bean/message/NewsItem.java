package info.linsword20.wechat.bean.message;

/**
 * 存储图文消息的item内容
 * 
 * @author Jason
 * 
 */
public class NewsItem
{
	private int id;

	private String Title = "";

	private String Description = "";

	private String PicUrl = "";

	private String Url = "";

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return Title;
	}

	public NewsItem setTitle(String title)
	{
		Title = title;
		return this;
	}

	public String getDescription()
	{
		return Description;
	}

	public NewsItem setDescription(String description)
	{
		Description = description;
		return this;
	}

	public String getPicUrl()
	{
		return PicUrl;
	}

	public NewsItem setPicUrl(String picUrl)
	{
		PicUrl = picUrl;
		return this;
	}

	public String getUrl()
	{
		return Url;
	}

	public NewsItem setUrl(String url)
	{
		Url = url;
		return this;
	}

}
