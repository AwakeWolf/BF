package runner;

import java.io.File;
import java.rmi.RemoteException;

import rmi.RemoteHelper;

public class Controller {

	private RemoteHelper remoteHelper;
	private String currentUser;
	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public Controller(RemoteHelper remoteHelper) {
		// TODO Auto-generated constructor stub
		this.remoteHelper=remoteHelper;
	}
	
	public boolean login(String userName,String password){
		try {
			boolean result=remoteHelper.getUserService().login(userName, password);
			return result;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public boolean signin(String userName,String password) {
		boolean result;
		try {
			result = remoteHelper.getUserService().signin(userName, password);
			return result;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public File[] getProjects(){
		try {
			File[] result=remoteHelper.getIOService().readProjectList(currentUser);
			return result;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public File[] getFileList(String project) {
		try {
			return remoteHelper.getIOService().readFileList(currentUser, project);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String readFile(String project,String filename){
		try {
			return remoteHelper.getIOService().readFile(currentUser, project+"/"+filename);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
