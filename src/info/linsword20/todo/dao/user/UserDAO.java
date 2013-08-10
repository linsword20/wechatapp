package info.linsword20.todo.dao.user;

import info.linsword20.todo.bean.User;

import java.util.List;

public interface UserDAO
{
	public User login(String username, String password);

	public int getIdByWid(String wid);
	
	public boolean findByUsername(String username);
	
	public boolean findByEmail(String email);
	
	public boolean findByWid(String wid);
	
	public void saveUser(User user);
	
	public List<User> findAll();
	
	public User getUserByName(String username);
	
	public void updateUser(User user);
}
