package info.linsword20.todo.dao.user;

import info.linsword20.todo.bean.User;

public interface UserDAO
{
	public User login(String username, String password);

	public int getIdByWid(String wid);
}
