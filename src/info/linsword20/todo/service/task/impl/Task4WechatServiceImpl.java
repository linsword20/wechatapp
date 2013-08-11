package info.linsword20.todo.service.task.impl;

import info.linsword20.log.annotation.WechatLogging;
import info.linsword20.todo.bean.Task;
import info.linsword20.todo.bean.User;
import info.linsword20.todo.dao.task.TaskDAO;
import info.linsword20.todo.dao.user.UserDAO;
import info.linsword20.todo.service.task.Task4WechatService;
import info.linsword20.wechat.util.SHA1;

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
	@WechatLogging(desc="微信：查看待办事项")
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
	@WechatLogging(desc="微信：删除待办事项")
	public boolean deleteTask(int id, String wid)
	{
		Task task = new Task();
		if (authority(id, wid)) return false;
		task.setId(id);
		this.taskDao.DeleteTask(task);
		return true;
	}

	@Override
	@WechatLogging(desc="微信：更新待办事项")
	public boolean updateTask(int id, String wid, String content)
	{
		if (authority(id, wid)) return false;
		Task task = this.taskDao.findById(id);
		task.setContent(content);
		this.taskDao.updateTask(task);
		return true;
	}

	@Override
	@WechatLogging(desc="微信：标记完成待办")
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
	@Override
	public boolean userExist(String username, String password)
	{
		password = new SHA1().getDigestOfString(password.getBytes()).toLowerCase();
		User user = this.userDao.login(username, password);
		if(null != user)
			return true;
		return false;
	}
	@Override
	@WechatLogging(desc="微信：关联用户")
	public void registerWid(String username, String wid)
	{
		User user = this.userDao.getUserByName(username);
		user.setWid(wid);
		this.userDao.updateUser(user);	
	}
}
