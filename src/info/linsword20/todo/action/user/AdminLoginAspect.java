package info.linsword20.todo.action.user;

import info.linsword20.todo.Exception.NoPermissionException;
import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.annotation.UserAccessAnnotation;
import info.linsword20.todo.myenum.ISLOGIN;
import info.linsword20.todo.service.user.UserService;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AdminLoginAspect extends BaseAction
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

		if (!this.userService.isLogin().equals(isLogin))
		{
			throw new NoPermissionException(getText("user_no_permission_error"));
		}
	}
}
