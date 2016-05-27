package runner;

import java.rmi.RemoteException;

import rmi.RemoteHelper;

public class Controller {

	RemoteHelper remoteHelper;
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

}
