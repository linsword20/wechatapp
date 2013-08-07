package info.linsword20.todo.dao.task;

import info.linsword20.todo.bean.Task;

import java.util.List;

public interface TaskDAO
{
	public void saveTasks(Task task);

	public List<Task> findAll(int opt, int user_id);

	public void MarkTask(int id);

	public void DeleteTask(Task task);

	public Task findById(int id);

	public void updateTask(Task task);
}
