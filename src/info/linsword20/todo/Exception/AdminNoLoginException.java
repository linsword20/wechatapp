package info.linsword20.todo.Exception;

public class AdminNoLoginException extends Exception
{
	private static final long serialVersionUID = 1L;

	public AdminNoLoginException()
	{
		super();
	}
	public AdminNoLoginException(String msg)
	{
		super(msg);
	}
}
