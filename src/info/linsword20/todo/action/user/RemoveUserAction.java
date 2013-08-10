package info.linsword20.todo.action.user;

import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.annotation.UserAccessAnnotation;
import info.linsword20.todo.bean.User;
import info.linsword20.todo.myenum.ISLOGIN;
import info.linsword20.todo.myenum.ROLE;
import info.linsword20.todo.service.user.UserService;

public class RemoveUserAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

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
	@UserAccessAnnotation(isLogin=ISLOGIN.YES,authority=ROLE.ADMIN)
	public String execute() throws Exception
	{
		this.userService.removeUser(this.user);
		return SUCCESS;
	}
	
	
	
	
}
