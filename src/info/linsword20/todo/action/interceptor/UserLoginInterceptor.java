package info.linsword20.todo.action.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class UserLoginInterceptor extends AbstractInterceptor
{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		Map<String, Object> map = invocation.getInvocationContext()
				.getSession();

		if (null == map.get("user")) // 用户没有登录
		{
			return Action.LOGIN; // 返回到登录界面
		}
		else
		{
			return invocation.invoke();
		}

	}

}
