package info.linsword20.todo.action.task;

import info.linsword20.log.annotation.LoggingRequired;
import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.annotation.UserAccessAnnotation;
import info.linsword20.todo.myenum.ISLOGIN;
import info.linsword20.todo.service.task.TaskService;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

@SuppressWarnings("serial")
public class MarkTaskAction extends BaseAction

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

	@Override
	@UserAccessAnnotation(isLogin = ISLOGIN.YES)
	@LoggingRequired(desc="标记完成待办事项")
	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
	
		byte id = Byte.parseByte(request.getParameter("id"));
		this.tasksService.markTask(id);
		
		ServletActionContext.getResponse().getWriter().print("");
		
		return null;
	}
}
