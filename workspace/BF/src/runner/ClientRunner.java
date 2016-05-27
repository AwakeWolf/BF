package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.sun.glass.ui.TouchInputSupport;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import rmi.RemoteHelper;
import service.IOService;
import ui.LoginScene;
import ui.MainScene;

public class ClientRunner extends Application{
	private RemoteHelper remoteHelper;
	public static Controller controller;
	private LoginScene loginScene;
	public static Stage primaryStage;
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
		loginScene=new LoginScene(new GridPane(),300,150);
		
//		mainScene = new MainScene(new BorderPane(),500,400);
	}
	
	public void test(){
		try {
			System.out.println(remoteHelper.getUserService().login("admin", "123456a"));
			System.out.println(remoteHelper.getIOService().writeFile("2", "admin", "testFile"));
			System.out.println(remoteHelper.getIOService().readProjectList("hello"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage=primaryStage;
		primaryStage.setScene(loginScene);
		
		primaryStage.setTitle("Login");
		primaryStage.show();
	}
	
}
