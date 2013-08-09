package info.linsword20.todo.action.task;

import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.annotation.UserAccessAnnotation;
import info.linsword20.todo.bean.Task;
import info.linsword20.todo.bean.User;
import info.linsword20.todo.myenum.ISLOGIN;
import info.linsword20.todo.service.task.TaskService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class ListTaskAction extends BaseAction
{
	private static final long serialVersionUID = 1L;
	private TaskService tasksService;

	public TaskService getTasksService()
	{
		return tasksService;
	}

	public void setTasksService(TaskService tasksService)
	{
		this.tasksService = tasksService;
	}

	private String opt = "0";

	public String getOpt()
	{
		return opt;
	}

	public void setOpt(String opt)
	{
		if(!"".equals(opt))
		this.opt = opt;
	}

	/*
	 * 默认表示列出未完成待办事项 opt=1表示列出已完成待办事项 opt=2表示列出全部事项 
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@UserAccessAnnotation(isLogin = ISLOGIN.YES)
	public String execute() throws Exception
	{

		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) this.session.get("user");
		int user_id = user.getId();
		List<Task> tasks = null;
		if (Integer.parseInt(opt) == 1)
		{
			tasks = this.tasksService.listAllTask(1,user_id);
		}
		else if (Integer.parseInt(opt) == 2)
		{
			tasks = this.tasksService.listAllTask(2, user_id);
		}
		else
		{
			tasks = this.tasksService.listAllTask(user_id);
		}
		request.setAttribute("list", tasks);
		return SUCCESS;
	}
}
