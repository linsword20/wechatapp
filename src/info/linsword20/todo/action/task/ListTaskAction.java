package info.linsword20.todo.action.task;

import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.bean.Task;
import info.linsword20.todo.bean.User;
import info.linsword20.todo.service.task.TaskService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

@SuppressWarnings("serial")
public class ListTaskAction extends BaseAction
{
	private TaskService tasksService;

	public TaskService getTasksService()
	{
		return tasksService;
	}

	public void setTasksService(TaskService tasksService)
	{
		this.tasksService = tasksService;
	}
	
	
	// 默认，未完成
	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User)this.session.get("user");
		int user_id = user.getId();
		
		List<Task>tasks = this.tasksService.listAllTask(user_id);

		request.setAttribute("list", tasks);
		return SUCCESS;
	}

	// 已完成
	public String execute1() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User)this.session.get("user");
		int user_id = user.getId();
		List<Task> tasks = this.tasksService.listAllTask(1,user_id);
		
		request.setAttribute("list", tasks);
		return SUCCESS;
	}

	// 全部
	public String execute2() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User)this.session.get("user");
		int user_id = user.getId();
		List<Task> tasks = this.tasksService.listAllTask(2,user_id);
		request.setAttribute("list", tasks);
		return SUCCESS;
	}

	public String add() throws Exception
	{
		return SUCCESS;
	}
}
