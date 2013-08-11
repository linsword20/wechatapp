package info.linsword20.log.action;

import info.linsword20.log.annotation.LoggingRequired;
import info.linsword20.log.annotation.LogoutLogging;
import info.linsword20.log.annotation.WechatLogging;
import info.linsword20.log.bean.Log;
import info.linsword20.log.dao.LogDAO;
import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.bean.User;

import java.sql.Timestamp;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.opensymphony.xwork2.ActionContext;

@Aspect
public class LogAspect extends BaseAction
{
	private static final long serialVersionUID = 1L;

	private LogDAO logDao;

	public LogDAO getLogDao()
	{
		return logDao;
	}

	public void setLogDao(LogDAO logDao)
	{
		this.logDao = logDao;
	}

	/*
	 * 日志切入点
	 */
	@Pointcut("@annotation(info.linsword20.log.annotation.LoggingRequired)")
	public void loggingRequire()
	{
	}

	/*
	 * 普通日志
	 */
	@After(value = "loggingRequire()&&" + "@annotation(loggingRequired)", argNames = "loggingRequired")
	public void logging(LoggingRequired loggingRequired)
	{
		String desc = loggingRequired.desc();
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = ((User) session.get("user")).getUsername();
		Timestamp time = new Timestamp(new java.util.Date().getTime());
		Log log = new Log();
		log.setDescription(desc);
		log.setTimestamp(time);
		log.setUsername(username);
		this.logDao.addLog(log);
	}

	/*
	 * 注销等后置切入点
	 */
	@Pointcut("@annotation(info.linsword20.log.annotation.LogoutLogging)")
	public void logoutLogging()
	{
	}

	/*
	 * 注销等日志
	 */
	@Before(value = "logoutLogging()&&" + "@annotation(logoutLogging)", argNames = "logoutLogging")
	public void logoutlogging(LogoutLogging logoutLogging)
	{
		String desc = logoutLogging.desc();
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = ((User) session.get("user")).getUsername();
		Timestamp time = new Timestamp(new java.util.Date().getTime());
		Log log = new Log();
		log.setDescription(desc);
		log.setTimestamp(time);
		log.setUsername(username);
		this.logDao.addLog(log);
	}

	/*
	 * 微信端切入点
	 */
	@Pointcut("@annotation(info.linsword20.log.annotation.WechatLogging)")
	public void wechatLogging()
	{
	}

	/*
	 * 微信端日志
	 */
	@After(value = "wechatLogging()&&" + "@annotation(wechatLogging)", argNames = "joinPoint, wechatLogging")
	public void wechatlogging(JoinPoint joinPoint, WechatLogging wechatLogging)
	{

		Log log = new Log();
		String username = "";
		String desc = wechatLogging.desc();
		Timestamp time = new Timestamp(new java.util.Date().getTime());
		log.setDescription(desc);
		log.setTimestamp(time);

		if ("listAllTask".equals(joinPoint.getSignature().getName()))
		{
			String wid = (String) joinPoint.getArgs()[0];
			username = this.logDao.getUserNameByWid(wid);
		}
		else
		{
			String wid = (String) joinPoint.getArgs()[1];
			username = this.logDao.getUserNameByWid(wid);
		}
		log.setUsername(username);

		this.logDao.addLog(log);
	}

}
