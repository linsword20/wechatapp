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

	@SuppressWarnings("unchecked")
	@Override
	public boolean findByUsername(String username)
	{
		List user = this.getHibernateTemplate().find("from User u where u.username=?", username);
		if(user.size() > 0)
			return true;
		return false;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean findByEmail(String email)
	{
		List user = this.getHibernateTemplate().find("from User u where u.email=?", email);
		if(user.size() > 0)
			return true;
		return false;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean findByWid(String wid)
	{
		List user = this.getHibernateTemplate().find("from User u where u.wid=?", wid);
		if(user.size() > 0)
			return true;
		return false;
	}
	
	@Override
	public void saveUser(User user)
	{
		this.getHibernateTemplate().save(user);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll()
	{
		return this.getHibernateTemplate().find("from User");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User getUserByName(String username)
	{
		List users = this.getHibernateTemplate().find("from User u where u.username=?", username);
		User user = null;
		if(users.size() > 0)
			user = (User) users.get(0);			
		return user;	
	}
	@Override
	public void updateUser(User user)
	{
		this.getHibernateTemplate().saveOrUpdate(user);		
	}
	@Override
	public void deleteUser(User user)
	{
		this.getHibernateTemplate().delete(user);
	}
	@Override
	public User getUserById(int id)
	{
		return this.getHibernateTemplate().get(User.class, id);
	}
}
