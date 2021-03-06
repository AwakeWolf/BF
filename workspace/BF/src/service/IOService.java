//服务器IOService的Stub，内容相同
package service;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IOService extends Remote{
	public boolean writeFile(String file, String userId, String fileName)throws RemoteException;
	
	public String readFile(String userId, String fileName)throws RemoteException;
	
	public File[] readFileList(String userId,String projectName)throws RemoteException;
	
	public File[] readProjectList(String userId)throws RemoteException;
	
	public boolean creatNewProject(String userId,String projectName)throws RemoteException;

}
