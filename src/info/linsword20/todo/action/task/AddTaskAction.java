package info.linsword20.todo.action.task;

import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.annotation.UserAccessAnnotation;
import info.linsword20.todo.myenum.ISLOGIN;

public class AddTaskAction extends BaseAction
{
	private static final long serialVersionUID = 1L;
	
	@Override
	@UserAccessAnnotation(isLogin = ISLOGIN.YES)
	public String execute() throws Exception
	{
		return SUCCESS;
	}

}
