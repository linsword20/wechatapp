package info.linsword20.log.dao;

import info.linsword20.log.bean.Log;

import java.util.List;

public interface LogDAO  
{
	public void addLog(Log log);
	
	public String getUserNameByWid(String wid);
	
	public List<Log> listAll(int startPage, int pageSize);
	
	public int count();
}
