package info.linsword20.todo.service.task.impl;

import info.linsword20.todo.bean.Task;
import info.linsword20.todo.dao.task.TaskDAO;
import info.linsword20.todo.service.task.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService
{
	private TaskDAO taskDao;

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
		this.taskDao.MarkTask(id);
	}

	@Override
	public void deleteTask(Task task)
	{
		this.taskDao.DeleteTask(task);
	}

	@Override
	public Task findById(int id)
	{
		return this.taskDao.findById(id);
	}

	@Override
	public void updateTask(Task task)
	{
		task.setFlag(Byte.parseByte("0"));
		this.taskDao.updateTask(task);
	}
}
