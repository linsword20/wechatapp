package info.linsword20.todo.action.user;

import info.linsword20.todo.bean.Task;
import info.linsword20.todo.bean.User;
import info.linsword20.todo.service.task.TaskService;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.opensymphony.xwork2.Action;

@Aspect
public class UserControlAspect
{

	@Around("execution(* info.linsword20.todo.service.task.TaskService.markTask(..))")
	public void markControl(ProceedingJoinPoint joinPoint) throws Throwable
	{
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		User user = (User) session.get("user");

		TaskService taskService = (TaskService) joinPoint.getTarget();

		Task task = taskService.findById((Integer) joinPoint.getArgs()[0]);

		if (user.getId() != task.getUser_id())
		{
			return;
		}
		joinPoint.proceed();
	}

	@Around("execution(* info.linsword20.todo.service.task.TaskService.deleteTask(..))")
	public String delControl(ProceedingJoinPoint joinPoint) throws Throwable
	{
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		User user = (User) session.get("user");
		Task task = (Task) joinPoint.getArgs()[0];
		if (user.getId() != task.getUser_id())
		{
			return Action.ERROR;
		}
		joinPoint.proceed();
		return Action.SUCCESS;
	}

	@Around("execution(* info.linsword20.todo.service.task.TaskService.findById(..))")
	public Object findControl(ProceedingJoinPoint joinPoint) throws Throwable
	{
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		User user = (User) session.get("user");

		TaskService taskService = (TaskService) joinPoint.getTarget();

		Task task = taskService.findById((Integer) joinPoint.getArgs()[0]);

		if (user.getId() != task.getUser_id()) return null;
		return joinPoint.proceed();
	}
	
	@Around("execution(* info.linsword20.todo.service.task.TaskService.updateTask(..))")
	public void updateControl(ProceedingJoinPoint joinPoint) throws Throwable
	{
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		User user = (User) session.get("user");
		Task task = (Task) joinPoint.getArgs()[0];
		if (user.getId() != task.getUser_id())
		{
			return;
		}
		joinPoint.proceed();
	}

}
