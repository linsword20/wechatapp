package info.linsword20.wechat.bean.message;

/**
 * 文本消息
 * @author Jason
 *
 */
public class TextMessage extends BaseMessage
{
	private String Content;

	public String getContent()
	{
		return Content;
	}

	public void setContent(String content)
	{
		Content = content;
	}

}
