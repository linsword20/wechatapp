package info.linsword20.todo.bean;

import java.sql.Timestamp;

public class Task
{
	private int id;

	private String content;

	private byte flag = 0;

	private int user_id;

	private Timestamp startTime;

	private Timestamp stopTime;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public byte getFlag()
	{
		return flag;
	}

	public void setFlag(byte flag)
	{
		this.flag = flag;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int userId)
	{
		user_id = userId;
	}

	public Timestamp getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Timestamp startTime)
	{
		this.startTime = startTime;
	}

	public Timestamp getStopTime()
	{
		return stopTime;
	}

	public void setStopTime(Timestamp stopTime)
	{
		this.stopTime = stopTime;
	}

}
