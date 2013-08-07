package info.linsword20.wechat.bean.message;
/**
 * 音乐消息
 * @author Jason
 *
 */
public class MusicMessage extends BaseMessage
{
	private String Title;
	
	private String Description = "";
	
	private String MusicUrl;
	
	private String HQMusicUrl = "";

	public String getTitle()
	{
		return Title;
	}

	public void setTitle(String title)
	{
		Title = title;
	}

	public String getDescription()
	{
		return Description;
	}

	public void setDescription(String description)
	{
		Description = description;
	}

	public String getMusicUrl()
	{
		return MusicUrl;
	}

	public void setMusicUrl(String musicUrl)
	{
		MusicUrl = musicUrl;
	}

	public String getHQMusicUrl()
	{
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl)
	{
		HQMusicUrl = hQMusicUrl;
	}
	
	
}
