package info.linsword20.todo.action.user;

import info.linsword20.log.annotation.LoggingRequired;
import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.annotation.UserAccessAnnotation;
import info.linsword20.todo.myenum.ISLOGIN;
import info.linsword20.todo.myenum.ROLE;
import info.linsword20.todo.service.user.UserService;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class AlterUserAction extends BaseAction
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
	@LoggingRequired(desc="修改用户权限")
	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		String role = request.getParameter("role");
		this.userService.updateUser(id, role);
		return null;
	}
	public String role() throws Exception
	{
		return null;
	}
	
}
