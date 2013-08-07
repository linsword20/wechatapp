package info.linsword20.todo.service.user.impl;

import info.linsword20.todo.bean.User;
import info.linsword20.todo.dao.user.UserDAO;
import info.linsword20.todo.service.user.UserService;
import info.linsword20.wechat.util.SHA1;

public class UserServiceImpl implements UserService
{
	private UserDAO userDao;

	public UserDAO getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDAO userDao)
	{
		this.userDao = userDao;
	}

	private String encryption(String password)
	{
		return new SHA1().getDigestOfString(password.getBytes()).toLowerCase();
	}

	@Override
	public User login(String username, String password)
	{
		return this.userDao.login(username, encryption(password));
	}
}
