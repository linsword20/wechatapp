package info.linsword20.wechat.bean.message;
/**
 * 接收消息类，不存在的字段默认为null
 * @author Jason
 *
 */
public class RecvMessage extends BaseMessage
{
	private Long MsgId;
	
	private String Content = null; //文本消息内容
	
	private String PicUrl = null;  //图片消息

	/*
	 * 地理位置消息
	 */
	private String Location_X = null;
	
	private String Location_y = null;
	
	private String Scale = null;
	
	private String Label = null;
	
	/*
	 * 链接消息
	 */
	private String Title = null;
	
	private String Description = null;
	
	private String Url = null;
	
	/*
	 * 事件消息
	 */
	private String Event = null;
	
	private String EventKey = null;

	public String getMsgId()
	{
		return MsgId.toString();
	}

	public void setMsgId(String msgId)
	{
		MsgId = Long.parseLong(msgId);
	}

	public String getContent()
	{
		return Content;
	}

	public void setContent(String content)
	{
		Content = content;
	}

	public String getPicUrl()
	{
		return PicUrl;
	}

	public void setPicUrl(String picUrl)
	{
		PicUrl = picUrl;
	}

	public String getLocation_X()
	{
		return Location_X;
	}

	public void setLocation_X(String locationX)
	{
		Location_X = locationX;
	}

	public String getLocation_y()
	{
		return Location_y;
	}

	public void setLocation_y(String locationY)
	{
		Location_y = locationY;
	}

	public String getScale()
	{
		return Scale;
	}

	public void setScale(String scale)
	{
		Scale = scale;
	}

	public String getLabel()
	{
		return Label;
	}

	public void setLabel(String label)
	{
		Label = label;
	}

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

	public String getUrl()
	{
		return Url;
	}

	public void setUrl(String url)
	{
		Url = url;
	}

	public String getEvent()
	{
		return Event;
	}

	public void setEvent(String event)
	{
		Event = event;
	}

	public String getEventKey()
	{
		return EventKey;
	}

	public void setEventKey(String eventKey)
	{
		EventKey = eventKey;
	}
	
	
}
