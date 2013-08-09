package info.linsword20.todo.bean;

public class User
{
	private int id;

	private String username;

	private String password;

	private String wid = " ";

	private String email;

	private String role = "USER";

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

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

	public String getWid()
	{
		return wid;
	}

	public void setWid(String wid)
	{
		this.wid = wid;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

}
