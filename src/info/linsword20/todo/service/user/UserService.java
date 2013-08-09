package info.linsword20.todo.service.user;

import info.linsword20.todo.bean.User;
import info.linsword20.todo.myenum.ISLOGIN;

import java.util.Map;

public interface UserService
{	
	public User login(String username, String password);
	
	public ISLOGIN isLogin();
	
	public Map<String, String> isExist(String username, String email, String wid);
	
	public void saveUser(User user);
}
