package info.linsword20.todo.action.task;

import info.linsword20.log.annotation.LoggingRequired;
import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.annotation.UserAccessAnnotation;
import info.linsword20.todo.bean.Task;
import info.linsword20.todo.myenum.ISLOGIN;
import info.linsword20.todo.service.task.TaskService;

@SuppressWarnings("serial")
public class DeleteTaskAction extends BaseAction
{
	private Task task;
	
	private TaskService taskService;

	public Task getTask()
	{
		return task;
	}

	public void setTask(Task task)
	{
		this.task = task;
	}

	public TaskService getTaskService()
	{
		return taskService;
	}

	public void setTaskService(TaskService taskService)
	{
		this.taskService = taskService;
	}
	@Override
	@UserAccessAnnotation(isLogin = ISLOGIN.YES)
	@LoggingRequired(desc="删除待办事项")
	public String execute() throws Exception
	{
		this.taskService.deleteTask(this.task);
		return SUCCESS;
	}
}
