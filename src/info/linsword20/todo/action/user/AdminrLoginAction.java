package info.linsword20.todo.action.user;

import info.linsword20.log.annotation.LoggingRequired;
import info.linsword20.log.annotation.LogoutLogging;
import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.bean.User;
import info.linsword20.todo.service.user.UserService;

@SuppressWarnings("serial")
public class AdminrLoginAction extends BaseAction
{
	private UserService userService;
	private User user;

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
	@LoggingRequired(desc="管理员登录")
	public String login() throws Exception
	{
		User loginUser = this.userService.login(user.getUsername(), user
				.getPassword());
		if (null != loginUser && loginUser.getRole().equals("ADMIN"))
		{
			session.put("user", loginUser);
		}
		else
		{
			this.addActionError("用户名或密码有误");
			return INPUT;
		}
		return SUCCESS;
	}
	
	@LogoutLogging(desc="管理员注销")
	public String logout() throws Exception
	{
		if (session != null && session.size() > 0)
		{
			session.clear();
		}
		return INPUT;
	}
}
