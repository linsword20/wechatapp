package info.linsword20.todo.service.user.impl;

import info.linsword20.todo.bean.User;
import info.linsword20.todo.dao.user.UserDAO;
import info.linsword20.todo.myenum.ISLOGIN;
import info.linsword20.todo.service.user.UserService;
import info.linsword20.wechat.util.SHA1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

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

	public ISLOGIN isLogin()
	{
		Map<String, Object> map = ServletActionContext.getContext().getSession();

		if (null == map.get("user")) // 用户没有登录
		{
			return ISLOGIN.NO; // 返回到登录界面
		}
		else
		{
			return ISLOGIN.YES;
		}
	}
	
	@Override
	public Map<String, String> isExist(String username, String email, String wid)
	{
		Map<String, String> map = new HashMap<String, String>();
		if(this.userDao.findByUsername(username))
		{
			map.put("username", "用户名" + username + "已存在");
			return map;
		}
		if(this.userDao.findByEmail(email))
		{
			map.put("email", email + "已经注册");
			return map;
		}
		if(this.userDao.findByWid(wid))
		{
			map.put("wid", "微信号已注册");
			return map;
		}
		return map;
	}
	
	@Override
	public void saveUser(User user)
	{	
		user.setPassword(new SHA1().getDigestOfString(user.getPassword().getBytes()).toLowerCase());
		this.userDao.saveUser(user);
	}
	
	@Override
	public List<User> listAllUser()
	{
		return this.userDao.findAll();
	}
	
}
