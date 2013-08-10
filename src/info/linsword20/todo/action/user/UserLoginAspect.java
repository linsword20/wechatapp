package info.linsword20.todo.action.user;

import info.linsword20.todo.Exception.AdminNoLoginException;
import info.linsword20.todo.Exception.UserNoLoginException;
import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.annotation.UserAccessAnnotation;
import info.linsword20.todo.myenum.ISLOGIN;
import info.linsword20.todo.myenum.ROLE;
import info.linsword20.todo.service.user.UserService;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UserLoginAspect extends BaseAction
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

	@Pointcut("@annotation(info.linsword20.todo.annotation.UserAccessAnnotation)")
	public void userAccess()
	{
	}

	@Before(value = "userAccess()&&" + "@annotation(userAccessAnnotation)", argNames="userAccessAnnotation")
	public void checkLogin(UserAccessAnnotation userAccessAnnotation)
			throws Exception
	{
		ISLOGIN isLogin = userAccessAnnotation.isLogin();

		ROLE role = userAccessAnnotation.authority();
		//未登录
		if (!this.userService.isLogin().equals(isLogin))
		{
			if(role.equals(ROLE.USER)){//用户登录
				throw new UserNoLoginException(getText("user_no_login_error"));
			}
			else{//管理员登录
				throw new AdminNoLoginException(getText("admin_no_login_error"));
			}			
		}
		//已登录
		else
		{	//需要管理员权限执行，但session中用户没有admin角色
			if(role.equals(ROLE.ADMIN) && !this.userService.getRole().equals(role))
			{
				throw new AdminNoLoginException(getText("admin_no_login_error"));
			}
		}
	}
}
