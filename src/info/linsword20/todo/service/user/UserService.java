package info.linsword20.todo.service.user;

import info.linsword20.todo.bean.User;
import info.linsword20.todo.myenum.ISLOGIN;
import info.linsword20.todo.myenum.ROLE;

import java.util.List;
import java.util.Map;

public interface UserService
{	
	public User login(String username, String password);
	
	public ISLOGIN isLogin();
	
	public Map<String, String> isExist(String username, String email, String wid);
	
	public void saveUser(User user);
	
	public List<User> listAllUser();
	
	public void removeUser(User user);
	
	public ROLE getRole();
	
	public void updateUser(int id, String role);

}
