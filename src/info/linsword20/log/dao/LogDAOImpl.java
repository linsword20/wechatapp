package info.linsword20.log.dao;

import info.linsword20.log.bean.Log;
import info.linsword20.todo.bean.User;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LogDAOImpl extends HibernateDaoSupport implements LogDAO
{

	@Override
	public void addLog(Log log)
	{
		this.getHibernateTemplate().save(log);
	}

	// 用于微信端日志管理
	@SuppressWarnings("unchecked")
	@Override
	public String getUserNameByWid(String wid)
	{
		List<User> users = this.getHibernateTemplate().find(
				"from User u where u.wid=?", wid);
		return users.get(0).getUsername();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Log> listAll(int startPage, int pageSize)
	{
		final int offset = startPage;
		final int length = pageSize;
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback()
				{
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException
					{
						Query query = session.createQuery("from Log");
						query.setFirstResult(offset);
						query.setMaxResults(length);
						List list = query.list();
						return list;
					}
				});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int count()
	{
		List list = this.getHibernateTemplate().find("from Log");
		return list.size();
	}

}
