package info.linsword20.todo.service.task.impl;

import info.linsword20.todo.bean.Task;
import info.linsword20.todo.bean.User;
import info.linsword20.todo.dao.task.TaskDAO;
import info.linsword20.todo.service.task.TaskService;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

public class TaskServiceImpl implements TaskService
{
	private TaskDAO taskDao;
	private User user;

	public void setTaskDao(TaskDAO taskDao)
	{
		this.taskDao = taskDao;
	}

	public TaskDAO getTasksDao()
	{
		return taskDao;
	}

	@Override
	public void saveTask(Task task)
	{
		this.taskDao.saveTasks(task);

	}

	@Override
	public List<Task> listAllTask(int user_id)
	{
		return listAllTask(0, user_id);
	}

	@Override
	public List<Task> listAllTask(int opt, int user_id)
	{
		return this.taskDao.findAll(opt, user_id);
	}

	@Override
	public void markTask(int id)
	{
		user = getSessionUser();
		Task task = findById(id);
		if (user.getId() != task.getUser_id()) return;
		this.taskDao.MarkTask(id);
	}

	@Override
	public void deleteTask(Task task)
	{
		user = getSessionUser();
		if (user.getId() != findById(task.getId()).getUser_id()) return;
		this.taskDao.DeleteTask(task);
	}

	@Override
	public Task findById(int id)
	{
		user = getSessionUser();
		Task task = this.taskDao.findById(id);

		if (user.getId() != task.getUser_id()) return null;

		return task;
	}

	@Override
	public void updateTask(Task task)
	{
		user = getSessionUser();

		if (user.getId() != task.getUser_id()) return;

		task.setFlag(Byte.parseByte("0"));
		this.taskDao.updateTask(task);
	}

	private User getSessionUser()
	{
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		User user = (User) session.get("user");
		return user;
	}

}
