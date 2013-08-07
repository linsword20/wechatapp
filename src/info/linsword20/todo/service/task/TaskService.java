package info.linsword20.todo.service.task;

import info.linsword20.todo.bean.Task;

import java.util.List;

public interface TaskService
{
	public void saveTask(Task task);
	
	public List<Task> listAllTask(int opt,int user_id);
	
	public List<Task> listAllTask(int user_id);
	
	public void markTask(int id);
	
	public void deleteTask(Task task);
	
	public Task findById(int id);
	
	public void updateTask(Task task);
	
	
}
