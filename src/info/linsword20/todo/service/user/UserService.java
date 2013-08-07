package info.linsword20.todo.service.user;

import info.linsword20.todo.bean.User;

public interface UserService
{	
	public User login(String username, String password);
}
