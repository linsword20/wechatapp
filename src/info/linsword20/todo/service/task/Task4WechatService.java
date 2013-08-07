package info.linsword20.todo.service.task;

public interface Task4WechatService
{
	public void saveTask(String content, String wid);

	public String listAllTask(String wid);

	public boolean deleteTask(int id, String wid);

	public boolean updateTask(int id, String wid, String content);

	public boolean markTask(int id, String wid);

	public String findById(int id);

	public boolean hasTaskOfId(int id);
}
