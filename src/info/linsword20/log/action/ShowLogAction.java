package info.linsword20.log.action;

import info.linsword20.log.bean.Log;
import info.linsword20.log.dao.LogDAO;
import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.annotation.UserAccessAnnotation;
import info.linsword20.todo.myenum.ISLOGIN;
import info.linsword20.todo.myenum.ROLE;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class ShowLogAction extends BaseAction
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

	@Override
	@UserAccessAnnotation(isLogin = ISLOGIN.YES, authority = ROLE.ADMIN)
	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		final int pageSize = 20;
		int startPage;
		int max = this.logDao.count();
		String page = request.getParameter("page");
		
		if (page != null && page.equals("end"))
		{
			// 总记录数/pageSize + 1
			startPage = max / pageSize + 1;
			
		}
		else
		{
			if (page == null)
			{
				page = "1";
			}
			startPage = Integer.parseInt(page);
		}
		startPage = (startPage - 1) * pageSize;
		List<Log> logs = this.logDao.listAll(startPage, pageSize);

		request.setAttribute("list", logs);
		request.setAttribute("page", startPage/pageSize + 1);
		request.setAttribute("max", max/ pageSize + 1);
		return SUCCESS;
	}
}
