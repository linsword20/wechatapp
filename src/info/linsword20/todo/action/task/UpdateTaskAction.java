package info.linsword20.todo.action.task;

import info.linsword20.todo.bean.Task;
import info.linsword20.todo.service.task.TaskService;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateTaskAction extends ActionSupport
{

	private TaskService taskService;

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
		int time = Integer.parseInt(request.getParameter("time"));
		Task task = this.taskService.findById(id);
		task.setContent(request.getParameter("content"));
		task
		.setStartTime(new Timestamp(new java.util.Date()
				.getTime()));
		task.setStopTime(new Timestamp(new java.util.Date().getTime()
						+ time * 86400000));
		this.taskService.updateTask(task);
		
		String stopTime = new SimpleDateFormat("yyyy-MM-dd").format(task.getStopTime());
		
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(stopTime);
		out.flush();
		return null;
	}
}
