package info.linsword20.todo.Exception;

public class NoPermissionException extends Exception
{
	private static final long serialVersionUID = 1L;
	public NoPermissionException(){
        super();
    }
    public NoPermissionException(String msg){
        super(msg);
    }
}
