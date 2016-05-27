package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.omg.CORBA.ARG_IN;

import javafx.application.Application;
import javafx.stage.Stage;
import rmi.RemoteHelper;
import service.IOService;
import ui.LoginApplication;
import ui.LoginFrame;
import ui.MainApplication;
import ui.MainFrame;

public class ClientRunner {
	private RemoteHelper remoteHelper;
	private Controller controller;
	public ClientRunner() {
		linkToServer();
		controller=new Controller(this.remoteHelper);
		initGUI();
	}
	
	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8888/DataRemoteObject"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	private void initGUI() {
		LoginApplication loginApplication=new LoginApplication(controller);
		
//		MainApplication mainFrame = new MainApplication(projects)
	}
	
	public void test(){
		try {
			System.out.println(remoteHelper.getUserService().login("admin", "123456a"));
			System.out.println(remoteHelper.getIOService().writeFile("2", "admin", "testFile"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		ClientRunner cr = new ClientRunner();
		
//		cr.test();
	}
}
