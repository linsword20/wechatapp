package info.linsword20.todo.action.user;

import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.bean.User;
import info.linsword20.todo.service.user.UserService;

import java.util.List;

public class ListUserAction extends BaseAction
{
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}


	@Override
	public String execute() throws Exception
	{
		List<User> users = this.userService.listAllUser();
		request.put("users", users);
		return SUCCESS;
	}
	
	
}
