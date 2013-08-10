package info.linsword20.todo.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail
{
	public static void execute(String toAddress)
	{
		String from = "linsword20@sina.com";// 发信邮箱
		String subject = "待办事项管理系统——注册成功";// 邮件主题
		String text = "\t您好！\n\t欢迎您使用待办事项系统。\n\t请妥善保存您的账户信息，如果由于失误或其他原因您丢失了用户名或者密码，\n" +
				"请给我发邮件，我将您的密码发送到您注册时留下的电子信箱里。\n现在可以登录系统使用了，谢谢\n\nJason";// 邮件内容

		Properties properties = new Properties();// 创建Properties对象
		properties.setProperty("mail.transport.protocol", "smtp");// 设置传输协议
		properties.put("mail.smtp.host", "smtp.sina.com");// 设置发信邮箱的SMTP地址
		properties.setProperty("mail.smtp.auth", "true"); // 验证

		Authenticator auth = new AjavaAuthenticator("linsword20",
				"Iverson@sina"); // 使用验证，创建一个Authenticator
		Session session = Session.getDefaultInstance(properties, auth);// 根据Properties，Authenticator创建Session
		try
		{
			Message message = new MimeMessage(session);// Message存储发送的电子邮件信息
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					toAddress));// 设置收信邮箱
			message.setSubject(subject);// 设置主题
			message.setText(text);// 设置内容
			Transport.send(message);// 发送

		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
	}
}

// 创建传入身份验证信息的 Authenticator类
class AjavaAuthenticator extends Authenticator
{
	private String user;
	private String pwd;

	public AjavaAuthenticator(String user, String pwd)
	{
		this.user = user;
		this.pwd = pwd;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(user, pwd);
	}
}
