package info.linsword20.todo.action.user;

import info.linsword20.todo.action.BaseAction;
import info.linsword20.todo.bean.User;
import info.linsword20.todo.service.user.UserService;
import info.linsword20.todo.util.Mail;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class UserRegisterAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

	private String  username;
	
	private String password;
	
	private String repassword;

	private String email;
	
	private UserService userService;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRepassword()
	{
		return repassword;
	}

	public void setRepassword(String repassword)
	{
		this.repassword = repassword;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception
	{
		Map<String, String> existInfo = this.userService.isExist(username, email, "");
		if(existInfo.size() == 0)
		{
			User user = new User();
			user.setEmail(email);
			user.setUsername(username);
			user.setPassword(password);
			this.userService.saveUser(user);
			Mail.execute(email);
			return SUCCESS;
		}
		else{
			Set<Entry<String, String>> set = existInfo.entrySet();
			for(Entry<String, String> entry : set)
			{
				this.addFieldError(entry.getKey(), entry.getValue());	
			}
			return INPUT;
		}
	}
	
}
