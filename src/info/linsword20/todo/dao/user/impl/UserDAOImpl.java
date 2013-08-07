package info.linsword20.todo.dao.user.impl;

import info.linsword20.todo.bean.User;
import info.linsword20.todo.dao.user.UserDAO;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO
{

	@SuppressWarnings("unchecked")
	@Override
	public User login(String username, String password)
	{

		if (username != null && password != null)
		{
			Object[] queryParams =
			{ username, password };

			String hql = "from User as u where u.username=? and password=?";

			List<User> users = this.getHibernateTemplate().find(hql,
					queryParams);

			if (users != null && users.size() > 0)
			{
				return users.get(0);
			}
			return null;
		}

		return null;
	}
	
	@SuppressWarnings("unchecked")
	public int getIdByWid(String wid)
	{
		List users =  this.getHibernateTemplate().find("from User u where u.wid=?", wid);
		if (users != null && users.size() > 0)
		{
			User user = (User)users.get(0);
			return user.getId();
		}
		return 0;
	}

}
