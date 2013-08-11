package info.linsword20.todo.action.user;

import info.linsword20.log.annotation.LoggingRequired;
import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.annotation.UserAccessAnnotation;
import info.linsword20.todo.bean.User;
import info.linsword20.todo.myenum.ISLOGIN;
import info.linsword20.todo.myenum.ROLE;
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
	@UserAccessAnnotation(isLogin=ISLOGIN.YES,authority=ROLE.ADMIN)
	@LoggingRequired(desc="查看用户")
	public String execute() throws Exception
	{
		List<User> users = this.userService.listAllUser();
		request.put("users", users);
		return SUCCESS;
	}
	
	
}
