package info.linsword20.wechat.action;

import info.linsword20.wechat.service.MsgProcessService;
import info.linsword20.wechat.util.SHA1;

import java.io.BufferedInputStream;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class WechatAction extends ActionSupport
{
	private String TOKEN = "845C2550903CE6FA54CACDB82EAD4350";

	private String signature;
	private String echostr;
	private String timestamp;
	private String nonce;
	private MsgProcessService msgProcessService;

	public String getSignature()
	{
		return signature;
	}

	public void setSignature(String signature)
	{
		this.signature = signature;
	}

	public String getEchostr()
	{
		return echostr;
	}

	public void setEchostr(String echostr)
	{
		this.echostr = echostr;
	}

	public String getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp(String timestamp)
	{
		this.timestamp = timestamp;
	}

	public String getNonce()
	{
		return nonce;
	}

	public void setNonce(String nonce)
	{
		this.nonce = nonce;
	}

	public MsgProcessService getMsgProcessService()
	{
		return msgProcessService;
	}

	public void setMsgProcessService(MsgProcessService msgProcessService)
	{
		this.msgProcessService = msgProcessService;
	}

	@Override
	public String execute() throws Exception
	{
		String method = ServletActionContext.getRequest().getMethod();
		if ("GET".equals(method)) {
			String[] str =
			{ TOKEN, timestamp, nonce };
			Arrays.sort(str); // 字典序排序
			String bigStr = str[0] + str[1] + str[2];
			// SHA1加密
			String digest = new SHA1().getDigestOfString(bigStr.getBytes())
					.toLowerCase();

			// 确认请求来至微信
			if (digest.equals(signature)) {
				ServletActionContext.getResponse().getWriter().print(echostr);
			}

			return null;
		}
		
		/*
		 *  处理微信消息
		 */
		if ("POST".equals(method)) {
			HttpServletRequest request = ServletActionContext.getRequest();
			BufferedInputStream bf = new BufferedInputStream(request
					.getInputStream());
			//接收到的XML消息
			StringBuffer receiveXml = new StringBuffer();
			byte[] buffer = new byte[200];
			int length = 0;
			while (-1 != (length = bf.read(buffer, 0, 200))) {
				String str = new String(buffer, 0, length,"utf-8");
				receiveXml.append(str);
			}
			
	//		System.out.println(receiveXml);
			
			/*
			 * 消息处理
			 */
			String responseXml = this.msgProcessService.exectue(receiveXml
					.toString());

	//		System.out.println(responseXml);
			
			//回复消息
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.getWriter().println(responseXml);
		}

		return null;
	}
}
