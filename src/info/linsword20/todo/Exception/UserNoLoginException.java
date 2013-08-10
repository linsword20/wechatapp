package info.linsword20.todo.Exception;

public class UserNoLoginException extends Exception
{
	private static final long serialVersionUID = 1L;
	public UserNoLoginException(){
        super();
    }
    public UserNoLoginException(String msg){
        super(msg);
    }
}
