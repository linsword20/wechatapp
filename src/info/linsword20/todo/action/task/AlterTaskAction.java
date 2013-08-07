package info.linsword20.todo.action.task;

import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.bean.Task;
import info.linsword20.todo.service.task.TaskService;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

@SuppressWarnings("serial")
public class AlterTaskAction extends BaseAction
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
	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		int id = Integer.parseInt(request.getParameter("id"));
		this.task = this.taskService.findById(id);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(task.getContent());
		out.flush();
		
		return null;
	}
}
