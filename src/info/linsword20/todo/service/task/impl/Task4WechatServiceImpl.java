package info.linsword20.todo.service.task.impl;

import info.linsword20.todo.bean.Task;
import info.linsword20.todo.dao.task.TaskDAO;
import info.linsword20.todo.dao.user.UserDAO;
import info.linsword20.todo.service.task.Task4WechatService;

import java.util.Iterator;
import java.util.List;

public class Task4WechatServiceImpl implements Task4WechatService
{
	private TaskDAO taskDao;
	private UserDAO userDao;

	public TaskDAO getTaskDao()
	{
		return taskDao;
	}

	public void setTaskDao(TaskDAO taskDao)
	{
		this.taskDao = taskDao;
	}

	public UserDAO getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDAO userDao)
	{
		this.userDao = userDao;
	}

	@Override
	public void saveTask(String content, String wid)
	{

		Task task = new Task();
		task.setContent(content);
		task.setUser_id(this.userDao.getIdByWid(wid));
		this.taskDao.saveTasks(task);
	}

	@Override
	public String listAllTask(String wid)
	{
		StringBuffer contents = new StringBuffer("");
		int i = 1;

		List<Task> tasks = this.taskDao
				.findAll(0, this.userDao.getIdByWid(wid));
		Iterator<Task> iter = tasks.iterator();
		while (iter.hasNext())
		{
			Task task = iter.next();
			contents.append(i++).append(".  ").append(task.getContent())
					.append("(id=").append(task.getId()).append(")\n");
		}

		return contents.toString();
	}

	@Override
	public boolean deleteTask(int id, String wid)
	{
		Task task = new Task();
		if (authority(id, wid)) return false;
		task.setId(id);
		this.taskDao.DeleteTask(task);
		return true;
	}

	@Override
	public boolean updateTask(int id, String wid, String content)
	{
		if (authority(id, wid)) return false;
		Task task = this.taskDao.findById(id);
		task.setContent(content);
		this.taskDao.updateTask(task);
		return true;
	}

	@Override
	public boolean markTask(int id, String wid)
	{
		if (authority(id, wid)) return false;
		this.taskDao.MarkTask(id);
		return true;
	}

	@Override
	public String findById(int id)
	{
		return this.taskDao.findById(id).getContent();
	}

	@Override
	public boolean hasTaskOfId(int id)
	{
		if (null != this.taskDao.findById(id)) return true;
		else return false;
	}

	private boolean authority(int id, String wid)
	{
		if (this.taskDao.findById(id).getUser_id() == this.userDao
				.getIdByWid(wid)) return false;
		return true;

	}
}
