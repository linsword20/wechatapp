package info.linsword20.todo.action.task;

import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.annotation.UserAccessAnnotation;
import info.linsword20.todo.bean.Task;
import info.linsword20.todo.bean.User;
import info.linsword20.todo.myenum.ISLOGIN;
import info.linsword20.todo.service.task.TaskService;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

/**
 * 
 * @author Jason
 * 
 */

public class SaveTaskAction extends BaseAction
{
	private static final long serialVersionUID = 1L;
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
	@UserAccessAnnotation(isLogin = ISLOGIN.YES)
	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] contents = request.getParameterValues("content");
		String[] times = request.getParameterValues("time");
		for (int i = 0; i < contents.length; i++)
		{
			if (!"".equals(contents[i]))
			{
				Task task = new Task();
				int time = Integer.parseInt(times[i]);
				task.setContent(contents[i]);
				task
						.setStartTime(new Timestamp(new java.util.Date()
								.getTime()));
				task.setStopTime(new Timestamp(new java.util.Date().getTime()
						+ time * 86400000));
				User user = (User)this.session.get("user");
				task.setUser_id(user.getId());
				this.taskService.saveTask(task);
			}

		}
		return SUCCESS;
	}

}
