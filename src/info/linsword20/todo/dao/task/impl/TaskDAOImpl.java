package info.linsword20.todo.dao.task.impl;

import info.linsword20.todo.bean.Task;
import info.linsword20.todo.dao.task.TaskDAO;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TaskDAOImpl extends HibernateDaoSupport implements TaskDAO
{

	@Override
	public void saveTasks(Task task)
	{
		this.getHibernateTemplate().save(task);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> findAll(int opt, int user_id)
	{
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		// 已完成事件
		if (1 == opt)
		{
			return hibernateTemplate
					.find(
							"from Task task where task.flag=1 and task.user_id=? order by task.id ",
							user_id);
		}
		// 全部事件
		else if (2 == opt)
		{
			return hibernateTemplate.find(
					"from Task task where task.user_id=? order by task.flag ", user_id);
		}
		// 默认未完成事件
		else
		{
			return hibernateTemplate
					.find(
							"from Task task where task.flag=0 and task.user_id=? order by task.id ",
							user_id);
		}

	}

	@Override
	public void MarkTask(int id)
	{
		HibernateTemplate hibernate = this.getHibernateTemplate();
		Task task = hibernate.get(Task.class, id);
		task.setFlag(Byte.parseByte("1"));
		hibernate.saveOrUpdate(task);
	}

	@Override
	public void DeleteTask(Task task)
	{
		Task obj = this.getHibernateTemplate().get(Task.class, task.getId());
		this.getHibernateTemplate().delete(obj);
	}

	@Override
	public Task findById(int id)
	{
		return this.getHibernateTemplate().get(Task.class, id);
	}

	@Override
	public void updateTask(Task task)
	{
		this.getHibernateTemplate().saveOrUpdate(task);
	}
}
