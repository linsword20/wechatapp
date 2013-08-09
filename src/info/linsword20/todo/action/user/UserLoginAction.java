package info.linsword20.todo.action.user;

import info.linsword20.todo.bean.User;
import info.linsword20.todo.service.user.UserService;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserLoginAction extends ActionSupport implements SessionAware
{
	// Map类型的request
	protected Map<String, Object> request;
	// Map类型的session
	protected Map<String, Object> session;
	// Map类型的application
	protected Map<String, Object> application;

	private UserService userService;
	private User user;

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@Override
	public String execute() throws Exception
	{
		return INPUT;
	}

	public String login() throws Exception
	{
		User loginUser = this.userService.login(user.getUsername(), user
				.getPassword());
		if (null != loginUser)
		{
			session.put("user", loginUser);
		}
		else
		{
			return INPUT;
		}
		return SUCCESS;
	}

	public String logout() throws Exception
	{
		if (session != null && session.size() > 0)
		{
			session.clear();
		}
		return INPUT;
	}
}
